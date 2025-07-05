package net.fawnoculus.ntm.items.custom.tools;

import net.fawnoculus.ntm.items.ModDataComponentTypes;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;


public class SpecialShovelItem extends ShovelItem implements SpecialTool {
  public SpecialShovelItem(Settings settings, ToolMaterial material, float attackDamage, float attackSpeed) {
    super(material, attackDamage, attackSpeed, settings.component(ModDataComponentTypes.SELECTED_ABILITY_COMPONENT_TYPE, -1));
  }
  
  public final AtomicBoolean canBreakDepthRock = new AtomicBoolean(false);
  public final List<ItemAbility> abilities = new ArrayList<>();
  public final List<ItemModifier> modifiers = new ArrayList<>();
  
  public SpecialShovelItem addAbility(ItemAbility ability) {
    this.abilities.add(ability);
    return this;
  }
  
  public SpecialShovelItem addModifier(ItemModifier modifier) {
    this.modifiers.add(modifier);
    return this;
  }
  
  @Override
  public SpecialShovelItem addCanBreakDepthRock() {
    this.canBreakDepthRock.set(true);
    return this;
  }
  
  @Override
  public List<ItemAbility> getAbilities() {
    return this.abilities;
  }
  
  @Override
  public List<ItemModifier> getModifiers() {
    return this.modifiers;
  }
  
  @Override
  public boolean canBreakDepthRock() {
    return this.canBreakDepthRock.get();
  }
  
  @Override
  public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
    this.processMakerModifiers(stack, target, attacker);
    super.postHit(stack, target, attacker);
  }
  
  @Override  @SuppressWarnings("deprecation")
  public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> tooltip, TooltipType type) {
    this.processTooltip(stack, tooltip);
  }
  
  @Override
  public ActionResult use(World world, PlayerEntity player, Hand hand) {
    if (world.isClient()) {
      return super.use(world, player, hand);
    }
    if (player instanceof ServerPlayerEntity serverPlayer) {
      this.cycleAbility(player.getStackInHand(hand), serverPlayer);
      return ActionResult.SUCCESS;
    }
    
    return super.use(world, player, hand);
  }
}
