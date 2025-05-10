package net.fawnoculus.ntm.items.custom.tools;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;

public class Modifiers {
  // All Weapon Modifiers reside here
  
  /**
   * Makes every killed entity drop its head-item (if it has one)
   */
  public static class Decapitator implements ItemModifier{
    @Override
    public String getTranslationKey() {return "tooltip.ntm.modifier.decapitator";}
    @Override
    public String getValue() {return null;}
    
    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
    
    }
  }
  /**
   * Gives Mobs a chance to drop Bobbleheads
   */
  public static class LuckOfTheCollector implements ItemModifier{
    @Override
    public String getTranslationKey() {return "tooltip.ntm.modifier.luckofthecollector";}
    @Override
    public String getValue() {return null;}
    
    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
    
    }
  }
  /**
   * Inflicts a high slowness effect
   * <p>
   * Time is given in seconds
   */
  public static class Stunning implements ItemModifier{
    public Stunning(int seconds){
      this.seconds = seconds;
    }
    public final Integer seconds;
    @Override
    public String getTranslationKey() {return "tooltip.ntm.modifier.stunning";}
    @Override
    public String getValue() {return this.seconds.toString();}
    
    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
      target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, seconds, 20, false, false), attacker);
    }
  }
  /**
   * Sets target on fire
   * <p>
   * Time is given in seconds
   */
  public static class Flaming implements ItemModifier{
    public Flaming(int seconds){
      this.seconds = seconds;
    }
    public final Integer seconds;
    @Override
    public String getTranslationKey() {return "tooltip.ntm.modifier.flaming";}
    @Override
    public String getValue() {return this.seconds.toString();}
    
    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
      if(target.getFireTicks() < seconds){
        target.setFireTicks(seconds);
      }
    }
  }
  /**
   * Sets the Target on fire but with Phosphorus Flames, which cant be extinguished before the time runs out
   * <p>
   * Time is given in seconds
   */
  public static class PhosphorusTip implements ItemModifier{
    public PhosphorusTip(int seconds){
      this.seconds = seconds;
    }
    public final Integer seconds;
    @Override
    public String getTranslationKey() {return "tooltip.ntm.modifier.phosphorustip";}
    @Override
    public String getValue() {return this.seconds.toString();}
    
    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
      // Phosphorus Fire is not jet implemented
      // TODO: do this when you have Phosphorus Fire
    }
  }
  /**
   * I'm assuming this will heal you based on the damage you did to the entity
   * <p>
   * The assumption i have is that the float represents a percentage of the damage you did (but i really don't know)
   */
  public static class Vampire implements ItemModifier{
    public Vampire(float percentage){
      this.percentage = percentage;
    }
    public final Float percentage;
    @Override
    public String getTranslationKey() {return "tooltip.ntm.modifier.vampire";}
    @Override
    public String getValue() {return this.percentage.toString();}
    
    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
    
    }
  }
  /**
   * Gives the attacked mob a certain amount of radiation
   */
  public static class RadioactiveBlade implements ItemModifier{
    public RadioactiveBlade(float radiation){
      this.radiation = radiation;
    }
    public final Float radiation;
    @Override
    public String getTranslationKey() {return "tooltip.ntm.modifier.radioactiveblade";}
    @Override
    public String getValue() {return radiation.toString();}
    
    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
      // Radiation is not jet implemented
      // TODO: do this when you have radiation
    }
  }
  /**
   * Makes mobs drop Nitra which can be used to craft stimpacks or multiply ammunition
   * <p>
   * I have no ide what the value of it is supposed to do ¯\_('-')_/¯
   * <p>
   * Neither do u know if it is actually a time value or supposed to represent min:max or smth.
   */
  public static class PainSaw implements ItemModifier{
    public PainSaw(int seconds){
      this.seconds = seconds;
    }
    public final Integer seconds;
    @Override
    public String getTranslationKey() {return "tooltip.ntm.modifier.painsaw";}
    @Override
    public String getValue() {
      if (this.seconds%60 < 10){
        return String.format("%d:0%d", this.seconds/60, this.seconds%60);
      }else {
        return String.format("%d:%d", this.seconds/60, this.seconds%60);
      }}
    
    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
    
    }
  }
}
