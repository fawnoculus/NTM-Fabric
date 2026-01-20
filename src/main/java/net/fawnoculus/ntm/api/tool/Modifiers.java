package net.fawnoculus.ntm.api.tool;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.api.radiation.RadiationManager;
import net.fawnoculus.ntm.entity.NTMStatusEffects;
import net.fawnoculus.ntm.items.NTMItems;
import net.fawnoculus.ntm.misc.NTMSounds;
import net.fawnoculus.ntm.util.EntityUtil;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ResolvableProfile;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Range;

public abstract class Modifiers {
    /**
     * Makes every killed entity drop its head-item (if it has one)
     */
    public static final ItemModifier DECAPITATOR = new ItemModifier(NTM.id("decapitator")) {
        @Override
        public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker, int level) {
            if (target.getHealth() > 0 || !(target.level() instanceof ServerLevel serverWorld)) {
                return;
            }

            if (target.getType() == EntityType.ZOMBIE) {
                target.spawnAtLocation(serverWorld, new ItemStack(Items.ZOMBIE_HEAD));
            } else if (target.getType() == EntityType.SKELETON) {
                target.spawnAtLocation(serverWorld, new ItemStack(Items.SKELETON_SKULL));
            } else if (target.getType() == EntityType.CREEPER) {
                target.spawnAtLocation(serverWorld, new ItemStack(Items.CREEPER_HEAD));
            } else if (target.getType() == EntityType.MAGMA_CUBE) {
                target.spawnAtLocation(serverWorld, new ItemStack(Items.MAGMA_CREAM, 3));
            } else if (target.getType() == EntityType.SLIME) {
                target.spawnAtLocation(serverWorld, new ItemStack(Items.SLIME_BALL, 3));
            } else if (target.getType() == EntityType.WITHER_SKELETON) {
                if (target.getRandom().nextInt(20) == 0) {
                    target.spawnAtLocation(serverWorld, new ItemStack(Items.WITHER_SKELETON_SKULL));
                } else {
                    target.spawnAtLocation(serverWorld, new ItemStack(Items.COAL, 3));
                }
            } else if (target instanceof Player targetPlayer) {
                ItemStack head = new ItemStack(Items.PLAYER_HEAD);
                head.set(DataComponents.PROFILE, ResolvableProfile.createUnresolved(targetPlayer.getGameProfile().id()));
                target.spawnAtLocation(serverWorld, head);
            } else {
                target.spawnAtLocation(serverWorld, new ItemStack(Items.ROTTEN_FLESH, 3));
                target.spawnAtLocation(serverWorld, new ItemStack(Items.BONE, 2));
            }
        }
    };

    /**
     * Gives Mobs a chance to drop Bobbleheads
     */
    public static final ItemModifier LUCK_OF_THE_COLLECTOR = new ItemModifier(NTM.id("luck_of_the_collector")) {
        @Override
        public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker, int level) {
            if (target.getHealth() > 0) {
                return;
            }

            int chance = 1000;

            if (target.getMaxHealth() > 20) {
                chance = 750;
            }

            if (target.getRandom().nextInt(chance) == 0) {
                // TODO: this, one we have Bobbleheads
                //target.dropStack(serverWorld, new ItemStack(NTMBlocks.BOBBLEHEAD, 1, target.getRandom().nextInt(BobbleType.values().length - 1) + 1));
            }
        }
    };

    /**
     * Inflicts a slowness & weakness effect
     * <p>
     * The Level represents the Stun time in seconds
     */
    public static final ItemModifier STUNNING = new ItemModifier(NTM.id("stunning")) {
        @Override
        public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker, int level) {
            target.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, level * 20, 4, false, false), attacker);
            target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, level * 20, 4, false, false), attacker);
        }
    };

    /**
     * Sets target on fire
     * <p>
     * The Level represents the Burn time in seconds
     */
    public static final ItemModifier FLAMING = new ItemModifier(NTM.id("flaming")) {
        @Override
        public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker, int level) {
            if (target.getRemainingFireTicks() < level * 20) {
                target.setRemainingFireTicks(level * 20);
            }
        }
    };

    /**
     * Sets the Target on fire but with Phosphorus Flames, which cant be extinguished before the time runs out
     * <p>
     * The Level represents the Phosphorus Burn time in seconds
     */
    public static final ItemModifier PHOSPHORUS_TIP = new ItemModifier(NTM.id("phosphorus_tip")) {
        @Override
        public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker, int level) {
            target.addEffect(new MobEffectInstance(NTMStatusEffects.PHOSPHORUS_BURNS, level * 20, 0, false, false, true));
        }
    };

    /**
     * Does extra damage to the attacked entity & gives health to the attacker, health amounts are based on the level
     */
    public static final ItemModifier VAMPIRE = new ItemModifier(NTM.id("vampire")) {
        @Override
        public MutableComponent getLevelText(int level) {
            return Component.literal("(" + level + ".0)");
        }

        @Override
        public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker, int level) {
            target.setHealth(target.getHealth() - level);
            if (target.getHealth() <= 0) {
                target.die(EntityUtil.newDamageSource(target.level(), DamageTypes.MAGIC));
            }
            attacker.heal(level);
        }
    };

    /**
     * Gives the attacked mob a certain amount of radiation
     */
    public static final ItemModifier RADIOACTIVE_BLADE = new ItemModifier(NTM.id("radioactive_blade")) {
        @Override
        public MutableComponent getLevelText(int level) {
            return Component.literal("(" + level + ".0)");
        }

        @Override
        public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker, int level) {
            RadiationManager.increaseRadiationExposure(target, level);
        }
    };

    /**
     * Makes mobs drop Nitra which can be used to craft stimpacks or multiply ammunition
     */
    public static ItemModifier PAIN_SAW = new ItemModifier(NTM.id("pain_saw")) {

        @Override
        public MutableComponent getLevelText(@Range(from = 0, to = 10) int level) {
            return Component.literal("(1:" + level + ")");
        }

        @Override
        public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker, int level) {
            if (!(target.level() instanceof ServerLevel serverWorld)) return;

            if (target.getHealth() <= 0.0F) {
                int count = Math.min((int) Math.ceil(target.getMaxHealth() / level), 250);

                for (int i = 0; i < count; i++) {
                    target.spawnAtLocation(serverWorld, NTMItems.FOOD_ITEM);
                    serverWorld.addFreshEntity(new ExperienceOrb(serverWorld, target.position(), Vec3.ZERO, 1));
                }

                // TODO: Blood Particles

                target.makeSound(NTMSounds.PAIN_SAW);
            }
            if (target.level() instanceof ServerLevel world) {
                int count = world.getRandom().nextIntBetweenInclusive(1, level);
                target.spawnAtLocation(world, new ItemStack(NTMItems.NITRA, count));
            }
        }
    };
}
