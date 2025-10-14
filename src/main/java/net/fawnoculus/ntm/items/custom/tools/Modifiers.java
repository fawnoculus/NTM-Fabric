package net.fawnoculus.ntm.items.custom.tools;

import net.fawnoculus.ntm.api.radiation.RadiationManager;
import net.fawnoculus.ntm.entity.NTMStatusEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class Modifiers {
  /**
   * Makes every killed entity drop its head-item (if it has one)
   */
  public static class Decapitator implements ItemModifier {
    @Override
    public String getTranslationKey() {
      return "tooltip.ntm.modifier.decapitator";
    }

    @Override
    public @Nullable String getValue() {
      return null;
    }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

    }
  }
  /**
   * Gives Mobs a chance to drop Bobbleheads
   */
  public static class LuckOfTheCollector implements ItemModifier {
    @Override
    public String getTranslationKey() {
      return "tooltip.ntm.modifier.luckofthecollector";
    }

    @Override
    public @Nullable String getValue() {
      return null;
    }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
      // TODO: this
    }
  }

  /**
     * Inflicts a high slowness effect
     * <p>
     * Time is given in ticks
     */
    public record Stunning(Integer seconds) implements ItemModifier {
    @Override
    public String getTranslationKey() {
      return "tooltip.ntm.modifier.stunning";
    }

    @Override
    public @NotNull String getValue() {
      return this.seconds.toString();
    }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
      target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, seconds, 20, false, false), attacker);
    }
  }

  /**
     * Sets target on fire
     * <p>
     * Time is given in ticks
     */
    public record Flaming(Integer ticks) implements ItemModifier {
    @Override
    public String getTranslationKey() {
      return "tooltip.ntm.modifier.flaming";
    }

    @Override
    public @NotNull String getValue() {
      return this.ticks.toString();
    }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
      if (target.getFireTicks() < ticks) {
        target.setFireTicks(ticks);
      }
    }
  }

  /**
     * Sets the Target on fire but with Phosphorus Flames, which cant be extinguished before the time runs out
     * <p>
     * Time is given in ticks
     */
    public record PhosphorusTip(Integer seconds) implements ItemModifier {
    @Override
    public String getTranslationKey() {
      return "tooltip.ntm.modifier.phosphorustip";
    }

    @Override
    public @NotNull String getValue() {
      return this.seconds.toString();
    }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
      target.addStatusEffect(new StatusEffectInstance(NTMStatusEffects.PHOSPHORUS_BURNS, this.seconds * 2, 0, false, false, true));
    }
  }

  /**
     * I'm assuming this will heal you based on the damage you did to the entity
     * <p>
     * The assumption I have is that the float represents a percentage of the damage you did (but I really don't know)
     */
    public record Vampire(Float percentage) implements ItemModifier {
      @Override
      public String getTranslationKey() {
        return "tooltip.ntm.modifier.vampire";
      }

      @Override
      public @NotNull String getValue() {
        return this.percentage.toString();
      }

      @Override
      public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

      }
    }

  /**
     * Gives the attacked mob a certain amount of radiation
     */
    public record RadioactiveBlade(double radiation) implements ItemModifier {
    @Override
    public String getTranslationKey() {
      return "tooltip.ntm.modifier.radioactiveblade";
    }

    @Override
    public @NotNull String getValue() {
      return Double.toString(radiation);
    }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
      RadiationManager.increaseRadiationExposure(target, radiation);
    }
  }

  /**
     * Makes mobs drop Nitra which can be used to craft stimpacks or multiply ammunition
     * <p>
     * I have no ide what the value of it is supposed to do ¯\_('-')_/¯
     * <p>
     * Neither do u know if it is actually a time value or supposed to represent min:max or smth.
     */
    public record PainSaw(Integer seconds) implements ItemModifier {
    @Override
    public String getTranslationKey() {
      return "tooltip.ntm.modifier.painsaw";
    }

    @Override
    public @NotNull String getValue() {
      if (this.seconds % 60 < 10) {
        return String.format("%d:0%d", this.seconds / 60, this.seconds % 60);
      } else {
        return String.format("%d:%d", this.seconds / 60, this.seconds % 60);
      }
    }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

    }
  }
}
