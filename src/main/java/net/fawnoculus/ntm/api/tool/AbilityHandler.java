package net.fawnoculus.ntm.api.tool;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.fawnoculus.ntm.items.NTMDataComponentTypes;
import net.fawnoculus.ntm.util.ClientTransferUtil;
import net.fawnoculus.ntm.util.WorldUtil;
import net.minecraft.block.BlockState;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Pair;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public record AbilityHandler(List<Pair<ItemAbility, @NotNull @Range(from = 1, to = 10) Integer>> ABILITIES,
                             StackData DEFAULT_STACK_DATA) {
    public static Builder builder() {
        return new Builder();
    }

    public @Range(from = 0, to = 10) int getMaxLevel(ItemAbility abilityType) {
        for (Pair<ItemAbility, Integer> pair : ABILITIES) {
            if (Objects.equals(pair.getLeft(), abilityType)) {
                return pair.getRight();
            }
        }
        return 0;
    }

    public StackData getStackData(ItemStack stack) {
        return stack.getOrDefault(NTMDataComponentTypes.ABILITY_COMPONENT_TYPE, DEFAULT_STACK_DATA.copy());
    }

    public boolean canNotSwitch(ItemStack stack) {
        return getStackData(stack).presets().size() <= 1;
    }

    /**
     * @param stack the stacks which's selection will be incremented
     * @param by    the amount to increment by
     */
    public void incrementPresetSelection(ItemStack stack, int by) {
        StackData stackData = getStackData(stack);
        stackData = stackData.incrementSelection(by);
        this.setStackData(stack, stackData);
    }

    /**
     * @param stack the stacks which's selection will be changed
     * @param to    the selected preset that should be selected
     */
    public void setSelectedPreset(ItemStack stack, int to) {
        StackData stackData = getStackData(stack);
        if (to < 0 || to > stackData.presets.size()) {
            return;
        }

        stackData = stackData.withSelectPreset(to);
        this.setStackData(stack, stackData);
    }

    public void setStackData(ItemStack stack, StackData stackData) {
        if (!stackData.isValid()) {
            return;
        }

        stack.set(NTMDataComponentTypes.ABILITY_COMPONENT_TYPE, stackData);
        if (this.abilitiesDisabled(stack)) {
            stack.remove(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE);
        } else {
            stack.set(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true);
        }
    }

    /**
     * Verifies that a List of Presets is valid for this specific Ability handler
     *
     * @param presets The presets which will be verified
     * @return true if the presets are valid, false if they are not
     */
    public boolean verifyPresets(List<Preset> presets) {
        if (presets.isEmpty()) {
            return false;
        }

        for (Preset preset : presets) {
            ItemAbility top = preset.topAbility;
            if (this.getMaxLevel(top) < preset.topAbilityLevel && top.isNotNone()) {
                return false;
            }

            ItemAbility bottom = preset.bottomAbility;
            if (this.getMaxLevel(bottom) < preset.bottomAbilityLevel && bottom.isNotNone()) {
                return false;
            }

            if (top.disablesOtherRow() && bottom.isNotNone()) {
                return false;
            }
            if (bottom.disablesOtherRow() && top.isNotNone()) {
                return false;
            }
        }

        return true;
    }

    public boolean abilitiesDisabled(ItemStack stack) {
        return getCurrentPreset(stack).topAbility.isNone() && getCurrentPreset(stack).bottomAbility.isNone();
    }

    public Preset getCurrentPreset(ItemStack stack) {
        StackData stackData = getStackData(stack);
        return Objects.requireNonNullElse(stackData.getPreset(stackData.selectedPreset), stackData.presets.getFirst());
    }

    public Text changeMessage(ItemStack stack) {
        Preset preset = getCurrentPreset(stack);
        ItemAbility top = preset.topAbility;
        ItemAbility bottom = preset.bottomAbility;

        if (top.isNotNone() && bottom.isNotNone()) {
            return Text.translatable("message.ntm.ability.enable_2", top.getFullName(preset.topAbilityLevel), bottom.getFullName(preset.bottomAbilityLevel)).formatted(Formatting.YELLOW);
        }

        if (top.isNotNone()) {
            return Text.translatable("message.ntm.ability.enable_1", top.getFullName(preset.topAbilityLevel)).formatted(Formatting.YELLOW);
        }

        if (bottom.isNotNone()) {
            return Text.translatable("message.ntm.ability.enable_1", bottom.getFullName(preset.bottomAbilityLevel)).formatted(Formatting.YELLOW);
        }

        return Text.translatable("message.ntm.ability.deactivate").formatted(Formatting.GOLD);
    }

    public void preBreak(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner) {
        Preset currentPreset = this.getCurrentPreset(stack);
        currentPreset.bottomAbility.preMine(stack, world, state, pos, miner, currentPreset.bottomAbilityLevel);
        currentPreset.topAbility.preMine(stack, world, state, pos, miner, currentPreset.topAbilityLevel);

        ArrayList<BlockPos> blocksToBreak = new ArrayList<>();
        blocksToBreak.add(pos);
        currentPreset.topAbility.addExtraBlocks(stack, world, state, pos, miner, currentPreset.topAbilityLevel, blocksToBreak);
        currentPreset.bottomAbility.addExtraBlocks(stack, world, state, pos, miner, currentPreset.bottomAbilityLevel, blocksToBreak);

        for (BlockPos breakingPos : blocksToBreak) {
            boolean doDrops1 = currentPreset.topAbility.onBreakBlock(stack, world, breakingPos, miner, currentPreset.topAbilityLevel);
            boolean doDrops2 = currentPreset.bottomAbility.onBreakBlock(stack, world, breakingPos, miner, currentPreset.bottomAbilityLevel);
            WorldUtil.removeBlock(world, breakingPos, miner, doDrops1 && doDrops2);
        }
    }

    public void appendTooltip(Consumer<Text> tooltip) {
        if (!this.ABILITIES().isEmpty()) {
            tooltip.accept(Text.translatable("tooltip.ntm.ability.start").formatted(Formatting.GRAY));
            for (Pair<ItemAbility, @NotNull @Range(from = 0, to = 10) Integer> pair : ABILITIES) {
                tooltip.accept(Text.literal("  ").append(pair.getLeft().getFullName(pair.getRight())).formatted(Formatting.GOLD));
            }
            tooltip.accept(Text.translatable("tooltip.ntm.ability.end1", ClientTransferUtil.getBoundKey("key.ntm.cycle_tool_ability").formatted(Formatting.YELLOW)).formatted(Formatting.GRAY));
            tooltip.accept(Text.translatable("tooltip.ntm.ability.end2", ClientTransferUtil.getBoundKey("key.ntm.cycle_tool_ability").formatted(Formatting.YELLOW)).formatted(Formatting.GRAY));
            tooltip.accept(Text.translatable("tooltip.ntm.ability.end3", ClientTransferUtil.getBoundKey("key.ntm.open_tool_ability_gui").formatted(Formatting.YELLOW)).formatted(Formatting.GRAY));
        }
    }

    public static class Builder {
        private final List<Pair<ItemAbility, @NotNull @Range(from = 0, to = 10) Integer>> abilities = new ArrayList<>();

        /**
         * Use this one if the ability doesn't support levels
         *
         * @param ability the ability to add
         */
        public Builder addAbility(ItemAbility ability) {
            abilities.add(new Pair<>(ability, 1));
            return this;
        }

        /**
         * Use this one if the ability does support levels
         *
         * @param ability  the ability to add
         * @param maxLevel the maximum level of the ability that will be supported
         */
        public Builder addAbility(ItemAbility ability, int maxLevel) {
            if (maxLevel < 1 || maxLevel > ability.maxLevel()) {
                throw new IllegalArgumentException("Max Level " + maxLevel + " is not valid for ability " + ability.getId());
            }

            abilities.add(new Pair<>(ability, maxLevel));
            return this;
        }

        private StackData makeDefaultStackData() {
            List<Preset> presets = new ArrayList<>(abilities.size());
            presets.add(new Preset(ItemAbility.NONE, 1, ItemAbility.NONE, 1));

            for (Pair<ItemAbility, @NotNull @Range(from = 0, to = 10) Integer> pair : abilities) {
                if (pair.getRight() < 1) {
                    continue;
                }

                if (pair.getLeft().isBottom()) {
                    presets.add(new Preset(ItemAbility.NONE, 1, pair.getLeft(), pair.getRight()));
                } else {
                    presets.add(new Preset(pair.getLeft(), pair.getRight(), ItemAbility.NONE, 1));
                }
            }

            return new StackData(presets, 0);
        }

        public AbilityHandler build() {
            return new AbilityHandler(abilities, this.makeDefaultStackData());
        }
    }


    /**
     * @param topAbility         Identifier of the top ability
     * @param topAbilityLevel    The level of the top ability, 0 if the ability doesn't support levels
     * @param bottomAbility      The Index to the bottom ability
     * @param bottomAbilityLevel The bottom of the top ability, 0 if the ability doesn't support levels
     */
    public record Preset(
      ItemAbility topAbility, @Range(from = 1, to = 10) int topAbilityLevel,
      ItemAbility bottomAbility, @Range(from = 1, to = 10) int bottomAbilityLevel
    ) {
        public static final Codec<Preset> CODEC = RecordCodecBuilder.create(instance ->
          instance.group(
            ItemAbility.CODEC.fieldOf("topAbility").forGetter(Preset::topAbility),
            Codec.INT.fieldOf("topAbilityLevel").forGetter(Preset::topAbilityLevel),
            ItemAbility.CODEC.fieldOf("bottomAbility").forGetter(Preset::bottomAbility),
            Codec.INT.fieldOf("bottomAbilityLevel").forGetter(Preset::bottomAbilityLevel)
          ).apply(instance, Preset::new)
        );

        public Preset copy() {
            return new Preset(topAbility, topAbilityLevel, bottomAbility, bottomAbilityLevel);
        }

        public boolean isValid() {
            return this.topAbilityLevel <= this.topAbility.maxLevel() && this.bottomAbilityLevel <= this.bottomAbility.maxLevel();
        }
    }

    public record StackData(List<Preset> presets, int selectedPreset) {
        public static final Codec<StackData> CODEC = RecordCodecBuilder.create(instance ->
          instance.group(
            Preset.CODEC.listOf().fieldOf("presets").forGetter(StackData::presets),
            Codec.INT.fieldOf("selectedPreset").forGetter(StackData::selectedPreset)
          ).apply(instance, StackData::new)
        );
        public static final PacketCodec<ByteBuf, StackData> PACKET_CODEC = new PacketCodec<>() {
            @Override
            public StackData decode(ByteBuf buf) {
                NbtCompound nbt = Objects.requireNonNull(PacketByteBuf.readNbt(buf));
                return new StackData(
                  nbt.get("presets", Preset.CODEC.listOf()).orElseThrow(),
                  nbt.getInt("selectedPreset").orElseThrow()
                );
            }

            @Override
            public void encode(ByteBuf buf, StackData value) {
                NbtCompound nbt = new NbtCompound();
                nbt.put("presets", Preset.CODEC.listOf(), value.presets);
                nbt.putInt("selectedPreset", value.selectedPreset);
                PacketByteBuf.writeNbt(buf, nbt);
            }
        };

        public boolean isValid() {
            for (Preset preset : this.presets) {
                if (!preset.isValid()) {
                    return false;
                }
            }
            return this.selectedPreset >= 0 && this.selectedPreset < this.presets.size();
        }

        public @Nullable Preset getPreset(int index) {
            if (index < 0 || index >= presets.size()) return null;
            return presets.get(index);
        }

        public StackData copy() {
            ArrayList<Preset> copiedPresets = new ArrayList<>(presets.size());
            for (Preset preset : presets) {
                copiedPresets.add(preset.copy());
            }
            return new StackData(copiedPresets, selectedPreset);
        }

        public StackData withSelectPreset(int index) {
            return new StackData(this.presets, index);
        }

        public StackData incrementSelection(int by) {
            return this.withSelectPreset((selectedPreset + by) % presets.size());
        }
    }
}
