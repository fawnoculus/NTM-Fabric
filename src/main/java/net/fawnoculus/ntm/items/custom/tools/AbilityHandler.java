package net.fawnoculus.ntm.items.custom.tools;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.fawnoculus.ntm.items.NTMDataComponentTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

import java.util.*;
import java.util.function.Consumer;

public record AbilityHandler(HashMap<Identifier, @NotNull @Range(from = -1, to = 10) Integer> MAX_LEVELS, StackData DEFAULT_STACK_DATA) {
  public @Range(from = -1, to = 10) int getMaxLevel(ItemAbility abilityType) {
    return MAX_LEVELS.getOrDefault(abilityType.getId(), -1);
  }

  public static Builder builder() {
    return new Builder();
  }

  public StackData getStackData(ItemStack stack){
    return stack.getOrDefault(NTMDataComponentTypes.ABILITY_COMPONENT_TYPE, DEFAULT_STACK_DATA.copy());
  }

  /**
   * @param stack the stacks which's selection will b e incremented
   * @param by the amount to increment by
   */
  public void incrementPresetSelection(ItemStack stack, int by){
    StackData stackData = getStackData(stack);
    stackData.incrementSelection(by);
    stack.set(NTMDataComponentTypes.ABILITY_COMPONENT_TYPE, stackData);
  }

  public void setPresets(ItemStack stack, List<Preset> presets) {
    StackData stackData = getStackData(stack);
    stackData.setPresets(presets);
    stack.set(NTMDataComponentTypes.ABILITY_COMPONENT_TYPE, stackData);
  }

  /**
   * Verifies that a List of Presets is valid for this specific Ability handler
   *
   * @param presets The presets which will be verified
   * @return true if the presets are valid, false if they are not
   */
  public boolean verifyPresets(List<Preset> presets) {
    for (Preset preset : presets) {
      Optional<ItemAbility> top = ItemAbility.get(preset.topAbility);
      if (top.isEmpty()) {
        return false;
      }
      if (this.getMaxLevel(top.get()) < preset.topAbilityLevel) {
        return false;
      }

      Optional<ItemAbility> bottom = ItemAbility.get(preset.bottomAbility);
      if (bottom.isEmpty()) {
        return false;
      }
      if (this.getMaxLevel(bottom.get()) < preset.bottomAbilityLevel) {
        return false;
      }

      if(top.get().disablesOtherRow() && bottom.get().isNotNone()){
        return false;
      }
      if(bottom.get().disablesOtherRow() && top.get().isNotNone()){
        return false;
      }
    }

    return true;
  }

  public boolean abilitiesDisabled(ItemStack stack){
    Optional<ItemAbility> top = ItemAbility.get(getCurrentPreset(stack).topAbility).filter(ItemAbility::isNotNone);
    Optional<ItemAbility> bottom = ItemAbility.get(getCurrentPreset(stack).bottomAbility).filter(ItemAbility::isNotNone);

    return top.isEmpty() && bottom.isEmpty();
  }

  public Preset getCurrentPreset(ItemStack stack) {
    StackData stackData = getStackData(stack);
    return Objects.requireNonNullElse(stackData.presets.get(stackData.selectedPreset), stackData.presets.getFirst());
  }

  public Text changeMessage(ItemStack stack) {
    Preset preset = getCurrentPreset(stack);
    Optional<Text> top = ItemAbility.get(preset.topAbility).filter(ItemAbility::isNotNone)
      .map(ability -> ability.getFullName(preset.topAbilityLevel));
    Optional<Text> bottom = ItemAbility.get(preset.bottomAbility).filter(ItemAbility::isNotNone)
      .map(ability -> ability.getFullName(preset.bottomAbilityLevel));

    if (top.isPresent() && bottom.isPresent()) {
      return Text.translatable("message.ntm.ability.enable_2", top.get(), bottom.get()).formatted(Formatting.YELLOW);
    }

    if(top.isPresent()){
      return Text.translatable("message.ntm.ability.enable_1", top.get()).formatted(Formatting.YELLOW);
    }

    if(bottom.isPresent()){
      return Text.translatable("message.ntm.ability.enable_1", bottom.get()).formatted(Formatting.YELLOW);
    }

    return Text.translatable("message.ntm.ability.deactivate").formatted(Formatting.GOLD);
  }

  public void preBreak(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner){
    Preset currentPreset = this.getCurrentPreset(stack);
    ItemAbility.get(currentPreset.topAbility)
      .ifPresent(ability -> ability.preMine(stack, world, state, pos, miner, currentPreset.topAbilityLevel));
    ItemAbility.get(currentPreset.bottomAbility)
      .ifPresent(ability -> ability.preMine(stack, world, state, pos, miner, currentPreset.bottomAbilityLevel));
  }

  public void postBreak(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner){
    Preset currentPreset = this.getCurrentPreset(stack);
    ItemAbility.get(currentPreset.topAbility)
      .ifPresent(ability -> ability.postMine(stack, world, state, pos, miner, currentPreset.topAbilityLevel));
    ItemAbility.get(currentPreset.bottomAbility)
      .ifPresent(ability -> ability.postMine(stack, world, state, pos, miner, currentPreset.bottomAbilityLevel));
  }

  public void appendTooltip(Consumer<Text> tooltip) {
    if (!MAX_LEVELS.isEmpty()) {
      tooltip.accept(Text.translatable("tooltip.ntm.ability.start").formatted(Formatting.GRAY));
      for (Identifier key : MAX_LEVELS.keySet()) {
        ItemAbility.get(key)
          .ifPresent(abilityType -> tooltip.accept(Text.literal("  ").append(abilityType.getFullName(MAX_LEVELS.get(key))).formatted(Formatting.GOLD)));
      }
      tooltip.accept(Text.translatable("tooltip.ntm.ability.end1").formatted(Formatting.GRAY));
      tooltip.accept(Text.translatable("tooltip.ntm.ability.end2").formatted(Formatting.GRAY));
      tooltip.accept(Text.translatable("tooltip.ntm.ability.end3").formatted(Formatting.GRAY));
    }
  }

  public static class Builder {
    private final HashMap<Identifier, @NotNull @Range(from = -1, to = 10) Integer> maxLevels = new HashMap<>();

    /**
     * Use this one if the ability doesn't support levels
     * @param ability the ability to add
     */
    public Builder addAbility(ItemAbility ability) {
      maxLevels.put(ability.getId(), 0);
      return this;
    }

    /**
     * Use this one if the ability does support levels
     * @param ability  the ability to add
     * @param maxLevel the maximum level of the ability that will be supported
     */
    public Builder addAbility(ItemAbility ability, int maxLevel) {
      maxLevels.put(ability.getId(), maxLevel);
      return this;
    }

    private StackData makeDefaultStackData() {
      List<Preset> presets = new ArrayList<>(maxLevels.size());
      presets.add(new Preset(ItemAbility.NONE.getId(), 0, ItemAbility.NONE.getId(), 0));

      for(Identifier abilityID : maxLevels.keySet()){
        int maxLevel = maxLevels.get(abilityID);
        if(maxLevel < 0 || maxLevel > 10) continue;

        Optional<ItemAbility> optional = ItemAbility.get(abilityID);
        if(optional.isEmpty()) continue;
        if(optional.get().isBottom()){
          presets.add(new Preset(ItemAbility.NONE.getId(), 0, abilityID, maxLevel));
        }else {
          presets.add(new Preset(abilityID, maxLevel, ItemAbility.NONE.getId(), 0));
        }
      }

      return new StackData(new ArrayList<>(presets.reversed()), 0);
    }

    public AbilityHandler build() {
      return new AbilityHandler(maxLevels, this.makeDefaultStackData());
    }
  }

  /**
   * @param topAbility    Identifier of the top ability
   * @param topAbilityLevel    The level of the top ability, 0 if the ability doesn't support levels
   * @param bottomAbility The Index to the bottom ability
   * @param bottomAbilityLevel The bottom of the top ability, 0 if the ability doesn't support levels
   */
  public record Preset(
    Identifier topAbility, @Range(from = 0, to = 10) int topAbilityLevel,
    Identifier bottomAbility, @Range(from = 0, to = 10) int bottomAbilityLevel
  ) {
    public static final Codec<Preset> CODEC = RecordCodecBuilder.create(instance ->
      instance.group(
        Identifier.CODEC.fieldOf("topAbility").forGetter(Preset::topAbility),
        Codec.INT.fieldOf("topAbilityLevel").forGetter(Preset::topAbilityLevel),
        Identifier.CODEC.fieldOf("bottomAbility").forGetter(Preset::bottomAbility),
        Codec.INT.fieldOf("bottomAbilityLevel").forGetter(Preset::bottomAbilityLevel)
      ).apply(instance, Preset::new)
    );

    public static final PacketCodec<ByteBuf, Preset> PACKET_CODEC = new PacketCodec<>() {
      @Override
      public Preset decode(ByteBuf buf) {
        return fromNBT(Objects.requireNonNull(PacketByteBuf.readNbt(buf)));
      }

      @Override
      public void encode(ByteBuf buf, Preset value) {
        PacketByteBuf.writeNbt(buf, toNBT(value));
      }
    };

    public Preset copy() {
      return new Preset(topAbility, topAbilityLevel, bottomAbility, bottomAbilityLevel);
    }

    public static NbtCompound toNBT(Preset preset){
      NbtCompound nbt = new NbtCompound();
      nbt.put("topAbility", Identifier.CODEC ,preset.topAbility);
      nbt.putInt("topAbilityLevel" ,preset.topAbilityLevel);
      nbt.put("bottomAbility", Identifier.CODEC ,preset.bottomAbility);
      nbt.putInt("bottomAbilityLevel" ,preset.bottomAbilityLevel);
      return nbt;
    }

    public static Preset fromNBT(NbtCompound nbt){
      return new Preset(
        nbt.get("topAbility", Identifier.CODEC).orElseThrow(),
        nbt.getInt("topAbilityLevel").orElseThrow(),
        nbt.get("bottomAbility", Identifier.CODEC).orElseThrow(),
        nbt.getInt("bottomAbilityLevel").orElseThrow()
      );
    }
  }

  public static final class StackData {
    public static final Codec<StackData> CODEC = RecordCodecBuilder.create(instance ->
      instance.group(
        Preset.CODEC.listOf().fieldOf("presets").forGetter(StackData::presets),
        Codec.INT.fieldOf("selectedPreset").forGetter(StackData::selectedPreset)
      ).apply(instance, StackData::new)
    );
    private List<Preset> presets;
    private int selectedPreset;

    public StackData(List<Preset> presets, int selectedPreset) {
      this.presets = presets;
      this.selectedPreset = selectedPreset;
    }

    public StackData copy() {
      ArrayList<Preset> copiedPresets = new ArrayList<>(presets.size());
      for (Preset preset : presets) {
        copiedPresets.add(preset.copy());
      }
      return new StackData(copiedPresets, selectedPreset);
    }

    public List<Preset> presets() {
      return presets;
    }

    public void setPresets(List<Preset> presets) {
      this.presets = presets;
    }

    public int selectedPreset() {
      return selectedPreset;
    }

    public void selectPreset(int index) {
      this.selectedPreset = index;
    }

    public void incrementSelection(int by) {
      this.selectPreset(by % presets.size());
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this) return true;
      if (obj == null || obj.getClass() != this.getClass()) return false;
      var that = (StackData) obj;
      return Objects.equals(this.presets, that.presets) &&
        this.selectedPreset == that.selectedPreset;
    }

    @Override
    public int hashCode() {
      return Objects.hash(presets, selectedPreset);
    }

    @Override
    public String toString() {
      return "StackData[" +
        "presets=" + presets + ", " +
        "selectedPreset=" + selectedPreset + ']';
    }

  }
}
