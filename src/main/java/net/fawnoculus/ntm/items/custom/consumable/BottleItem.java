package net.fawnoculus.ntm.items.custom.consumable;

import net.fawnoculus.ntm.items.ModItems;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Consumer;

public class BottleItem extends Item {
  public final List<StatusEffectInstance> EFFECTS;
  public final List<Item> RETURN_ITEMS;

  public BottleItem(Settings settings, List<StatusEffectInstance> effects, List<Item> returnItems) {
    super(settings.component(DataComponentTypes.CONSUMABLE, ConsumableComponents.DRINK));
    this.EFFECTS = effects;
    this.RETURN_ITEMS = returnItems;
  }

  @Override  @SuppressWarnings("deprecation")
  public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> tooltip, net.minecraft.item.tooltip.TooltipType type) {
    tooltip.accept(Text.translatable("tooltip." + this.getTranslationKey().substring(5)).formatted(Formatting.GRAY));
    tooltip.accept(Text.translatable("tooltip.ntm.needs_bottle_opener").formatted(Formatting.GRAY));
  }

  @Override
  public ActionResult use(World world, PlayerEntity playerEntity, Hand hand) {
    if(world.isClient()){
      return ActionResult.PASS;
    }

    boolean hasBottleOpener = false;
    for(ItemStack stack : playerEntity.getInventory()){
      if(stack.getItem() == ModItems.BOTTLE_OPENER) {
        hasBottleOpener = true;
        break;
      }
    }
    if(!hasBottleOpener) {
      return ActionResult.FAIL;
    }

    return super.use(world, playerEntity, hand);
  }

  @Override
  public ItemStack finishUsing(ItemStack stack, World world, LivingEntity entity) {
    if (!world.isClient() && entity instanceof PlayerEntity player) {
      for (StatusEffectInstance effect : this.EFFECTS) {
        player.addStatusEffect(new StatusEffectInstance(effect));
      }
      for (Item returnItem : this.RETURN_ITEMS) {
        player.giveItemStack(new ItemStack(returnItem));
      }
    }
    return super.finishUsing(stack, world, entity);
  }
}
