package net.fawnoculus.ntm.client.mixin;

import net.fawnoculus.ntm.client.NTMClientConfig;
import net.minecraft.client.gui.screen.ingame.StatusEffectsDisplay;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(StatusEffectsDisplay.class)
public class StatusEffectsDisplayMixin {

    @Inject(at = @At("RETURN"), method = "getStatusEffectDescription")
    private void fixHighAmplifiers(StatusEffectInstance statusEffect, CallbackInfoReturnable<Text> cir) {
        if (NTMClientConfig.FIX_EFFECT_LEVEL.getValue()
          && statusEffect.getAmplifier() > 9
          && cir.getReturnValue() instanceof MutableText mutableText
        ) {
            mutableText.append(" " + (statusEffect.getAmplifier() - 1));
        }
    }
}
