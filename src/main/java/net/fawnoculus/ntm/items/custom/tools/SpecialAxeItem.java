package net.fawnoculus.ntm.items.custom.tools;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fawnoculus.ntm.api.messages.AdvancedMessage;
import net.fawnoculus.ntm.network.s2c.AdvancedMessagePayload;
import net.minecraft.block.BlockState;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.function.Consumer;


public class SpecialAxeItem extends AxeItem implements SpecialTool {
  private final AbilityHandler ABILITIES;
  private final ModifierHandler MODIFIERS;
  private final boolean CAN_BREAK_DEPTH_ROCK;

  public SpecialAxeItem(Settings settings, ToolMaterial material, float attackDamage, float attackSpeed) {
    this(settings, material, attackDamage, attackSpeed, AbilityHandler.builder().build(), ModifierHandler.builder().build(), false);
  }

  public SpecialAxeItem(Settings settings, ToolMaterial material, float attackDamage, float attackSpeed, AbilityHandler abilities, ModifierHandler modifiers, boolean canBreakDepthRock) {
    super(material, attackDamage, attackSpeed, settings);

    this.ABILITIES = abilities;
    this.MODIFIERS = modifiers;
    this.CAN_BREAK_DEPTH_ROCK = canBreakDepthRock;
  }

  @Override
  public AbilityHandler getAbilities() {
    return this.ABILITIES;
  }

  @Override
  public ModifierHandler getModifiers() {
    return this.MODIFIERS;
  }

  @Override
  public boolean getCanBreakDepthRock() {
    return this.CAN_BREAK_DEPTH_ROCK;
  }

  @Override
  public ActionResult use(World world, PlayerEntity player, Hand hand) {
    if (world.isClient()) {
      return ActionResult.SUCCESS;
    }

    if(player instanceof ServerPlayerEntity serverPlayer){
      ItemStack stack = player.getStackInHand(hand);
      if(player.isSneaking()){
        this.ABILITIES.setSelectedPreset(stack, 0);
      }else {
        this.ABILITIES.incrementPresetSelection(stack, 1);
      }

      if(this.ABILITIES.abilitiesDisabled(stack)){
        player.playSoundToPlayer(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 0.25f, 0.75f);
      }else {
        player.playSoundToPlayer(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 0.25f, 1.25f);
      }

      ServerPlayNetworking.send(serverPlayer, new AdvancedMessagePayload(
        new AdvancedMessage(SpecialTool.ADVANCED_MESSAGE_ID, this.ABILITIES.changeMessage(stack), 1000f)
      ));
    }

    return ActionResult.SUCCESS_SERVER;
  }

  @Override
  public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
    this.MODIFIERS.postHit(stack, target, attacker);
    super.postHit(stack, target, attacker);
  }

  @Override
  public void preMine(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner) {
    this.ABILITIES.preBreak(stack, world, state, pos, miner);
  }

  @Override
  public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
    if(miner instanceof PlayerEntity player){
      this.ABILITIES.postBreak(stack, world, state, pos, player);
    }
    return super.postMine(stack, world, state, pos, miner);
  }

  @Override
  @SuppressWarnings("deprecation")
  public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> tooltip, TooltipType type) {
    this.ABILITIES.appendTooltip(tooltip);
    this.MODIFIERS.appendTooltip(tooltip);

    if (this.CAN_BREAK_DEPTH_ROCK) {
      tooltip.accept(Text.empty());
      tooltip.accept(Text.translatable("tooltip.ntm.can_break_depth_rock").formatted(Formatting.RED));
    }
  }
}
