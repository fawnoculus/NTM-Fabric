package net.fawnoculus.ntm.mixin;

import net.fawnoculus.ntm.items.custom.genric.DangerousDrop;
import net.fawnoculus.ntm.items.custom.genric.ExtraInfo;
import net.fawnoculus.ntm.misc.ModKeybinds;
import net.fawnoculus.ntm.world.radiation.client.ClientRadiationRegistry;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(ItemStack.class)
public abstract class ClientsideItemStackMixin {
  @Shadow public abstract Item getItem();
  
  @Shadow private int count;
  @Unique
  private static final ClientRadiationRegistry clientRadiationRegistry = ClientRadiationRegistry.getInstance();
  
  @Inject(method = "appendTooltip", at = @At(
      value = "INVOKE",
      target = "Lnet/minecraft/item/Item;appendTooltip(" +
          "Lnet/minecraft/item/ItemStack;" +
          "Lnet/minecraft/item/Item$TooltipContext;" +
          "Lnet/minecraft/component/type/TooltipDisplayComponent;" +
          "Ljava/util/function/Consumer;" +
          "Lnet/minecraft/item/tooltip/TooltipType;" +
          ")V",
      shift = At.Shift.AFTER
  ))
  public void appendTooltip(
      Item.TooltipContext context, TooltipDisplayComponent displayComponent, @Nullable PlayerEntity player, TooltipType type, Consumer<Text> textConsumer, CallbackInfo ci
  ) {
    double milliRads = clientRadiationRegistry.getRadioactivity(this.getItem());
    if(milliRads > 0){
      textConsumer.accept(Text.translatable("tooltip.ntm.radioactive").formatted(Formatting.GREEN));
      textConsumer.accept(Text.translatable("genric.ntm.radiation.rads", milliRads / 1000.0).formatted(Formatting.YELLOW));
      textConsumer.accept(Text.translatable("tooltip.ntm.stack_rads", milliRads * this.count / 1000.0).formatted(Formatting.YELLOW));
    }
    
    if(this.getItem() instanceof ExtraInfo extraInfo){
      if(!ModKeybinds.displayExtraInfo.isPressed()){
        textConsumer.accept(extraInfo.getHelpText());
      }else {
        extraInfo.getInfo().forEach(textConsumer);
      }
    }
    if(this.getItem() instanceof DangerousDrop){
      textConsumer.accept(Text.translatable("tooltip.ntm.dangerous_drop").formatted(Formatting.RED));
    }
  }
}
