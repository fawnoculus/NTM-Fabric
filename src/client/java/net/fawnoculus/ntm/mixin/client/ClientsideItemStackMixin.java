package net.fawnoculus.ntm.mixin.client;

import net.fawnoculus.ntm.items.custom.DangerousDrop;
import net.fawnoculus.ntm.items.custom.ExtraInfo;
import net.fawnoculus.ntm.misc.ModKeybinds;
import net.fawnoculus.ntm.misc.radiation.ClientHazmatRegistry;
import net.fawnoculus.ntm.misc.radiation.ClientRadiationRegistry;
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
  @Unique
  private static final ClientHazmatRegistry clientHazmatRegistry = ClientHazmatRegistry.getInstance();
  
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
      Item.TooltipContext context, TooltipDisplayComponent displayComponent, @Nullable PlayerEntity player, TooltipType type, Consumer<Text> tooltip, CallbackInfo ci
  ) {
    double milliRads = clientRadiationRegistry.getRadioactivity(this.getItem());
    if(milliRads > 0){
      tooltip.accept(Text.translatable("tooltip.ntm.radioactive").formatted(Formatting.GREEN));
      tooltip.accept(Text.translatable("generic.ntm.radiation.rads", milliRads / 1000.0).formatted(Formatting.YELLOW));
      if(this.count > 1){
        tooltip.accept(Text.translatable("tooltip.ntm.stack_rads", milliRads * this.count / 1000.0).formatted(Formatting.YELLOW));
      }
    }
    double radiationResistance = clientHazmatRegistry.getResistance(this.getItem());
    if(radiationResistance > 0){
      tooltip.accept(Text.translatable("tooltip.ntm.radiation_resistance", radiationResistance).formatted(Formatting.YELLOW));
    }
    
    if(this.getItem() instanceof ExtraInfo extraInfo){
      if(!ModKeybinds.displayExtraInfo.isPressed()){
        tooltip.accept(extraInfo.getHelpText());
      }else {
        extraInfo.getInfo().forEach(tooltip);
      }
    }
    if(this.getItem() instanceof DangerousDrop){
      tooltip.accept(Text.translatable("tooltip.ntm.dangerous_drop").formatted(Formatting.RED));
    }
  }
}
