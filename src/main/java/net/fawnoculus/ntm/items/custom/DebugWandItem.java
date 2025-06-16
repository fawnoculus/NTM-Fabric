package net.fawnoculus.ntm.items.custom;

import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.explosion.AdvancedExplosionBehavior;
import net.minecraft.world.explosion.ExplosionBehavior;

import java.util.Optional;
import java.util.function.Consumer;

public class DebugWandItem extends Item {
  public DebugWandItem(Settings settings) {
    super(settings);
  }
  
  @Override
  public ActionResult use(World world, PlayerEntity user, Hand hand) {
    if(world.isClient()){
      return ActionResult.SUCCESS;
    }
    
    Vec3d targetPos = user.raycast(256, 0, false).getPos();
    if(targetPos != null) {
      ExplosionBehavior explosionBehavior = new AdvancedExplosionBehavior(true, true, Optional.empty(), Optional.empty());
      world.createExplosion(user,  null, explosionBehavior, targetPos, 20, true, World.ExplosionSourceType.MOB);
    }
    
    return ActionResult.SUCCESS_SERVER;
  }
  
  @Override
  public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> tooltip, TooltipType type) {
    tooltip.accept(Text.translatable("tooltip.ntm.creative_only"));
    tooltip.accept(Text.translatable("tooltip.ntm.debug_wand"));
  }
}
