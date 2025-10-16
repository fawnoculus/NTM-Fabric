package net.fawnoculus.ntm.items.custom.tools;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.api.radiation.RadiationManager;
import net.fawnoculus.ntm.entity.NTMStatusEffects;
import net.fawnoculus.ntm.items.NTMItems;
import net.fawnoculus.ntm.misc.NTMSounds;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Range;

public abstract class Modifiers {
  /**
   * Makes every killed entity drop its head-item (if it has one)
   */
  public static final ItemModifier Decapitator = new ItemModifier(NTM.id("decapitator")) {
    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker, int level) {
      // TODO: this
    }
  };

  /**
   * Gives Mobs a chance to drop Bobbleheads
   */
  public static final ItemModifier LuckOfTheCollector = new ItemModifier(NTM.id("luck_of_the_collector")) {
    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker, int level) {
        // TODO: this
    }
  };

  /**
   * Inflicts a high slowness effect
   * <p>
   * The Level represents the Stun time in seconds
   */
  public static final ItemModifier Stunning = new ItemModifier(NTM.id("stunning")) {
    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker, int level) {
      target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, level * 20, 20, false, false), attacker);
    }
  };

  /**
   * Sets target on fire
   * <p>
   * The Level represents the Burn time in seconds
   */
  public static final ItemModifier Flaming = new ItemModifier(NTM.id("flaming")) {
    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker, int level) {
      if (target.getFireTicks() < level * 20) {
        target.setFireTicks(level * 20);
      }
    }
  };

  /**
   * Sets the Target on fire but with Phosphorus Flames, which cant be extinguished before the time runs out
   * <p>
   * The Level represents the Phosphorus Burn time in seconds
   */
  public static final ItemModifier PhosphorusTip = new ItemModifier(NTM.id("phosphorus_tip")) {
    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker, int level) {
      target.addStatusEffect(new StatusEffectInstance(NTMStatusEffects.PHOSPHORUS_BURNS, level * 20, 0, false, false, true));
    }
  };

  /**
   * I'm assuming this will heal you based on the damage you did to the entity
   * <p>
   * TODO: I have no idea what the level of this ability represents, i'll need to figure that out
   */
  public static final ItemModifier Vampire = new ItemModifier(NTM.id("vampire")) {
    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker, int level) {
      // TODO: this
    }
  };

  /**
   * Gives the attacked mob a certain amount of radiation
   */
  public static final ItemModifier RadioactiveBlade = new ItemModifier(NTM.id("radioactive_blade")) {
    @Override
    public MutableText getLevelText(int level) {
      return Text.literal("(" + level + ".0)");
    }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker, int level) {
      RadiationManager.increaseRadiationExposure(target, level);
    }
  };

  /**
   * Makes mobs drop Nitra which can be used to craft stimpacks or multiply ammunition
   */
  public static ItemModifier PainSaw = new ItemModifier(NTM.id("pain_saw")) {

    @Override
    public MutableText getLevelText(@Range(from = 0, to = 10) int level) {
      return Text.literal("(1:" + level + ")");
    }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker, int level) {
      if(!(target.getWorld() instanceof ServerWorld serverWorld)) return;

      if (target.getHealth() <= 0.0F) {
        int count = Math.min((int) Math.ceil(target.getMaxHealth() / level), 250);

        for (int i = 0; i < count; i++) {
          target.dropItem(serverWorld, NTMItems.FOOD_ITEM);
          serverWorld.spawnEntity(new ExperienceOrbEntity(serverWorld, target.getPos(), Vec3d.ZERO, 1));
        }

        // TODO: Blood Particles

        target.playSound(NTMSounds.PAIN_SAW);
      }
      if (target.getWorld() instanceof ServerWorld world) {
        int count = world.getRandom().nextBetween(1, level);
        target.dropStack(world, new ItemStack(NTMItems.NITRA));
      }
    }
  };
}
