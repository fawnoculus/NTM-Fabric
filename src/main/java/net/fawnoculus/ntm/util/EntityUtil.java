package net.fawnoculus.ntm.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public class EntityUtil {
	@Contract("_, _ -> new")
	public static @NotNull DamageSource newDamageSource(World world, RegistryKey<DamageType> damageTypeKey) {
		return newDamageSource(world, damageTypeKey, null, null);
	}

	@Contract("_, _, _, _ -> new")
	public static @NotNull DamageSource newDamageSource(@NotNull World world, RegistryKey<DamageType> damageTypeKey, @Nullable Entity source, @Nullable Entity attacker) {
		DamageType damageType = world.getRegistryManager()
		  .getOrThrow(RegistryKeys.DAMAGE_TYPE)
		  .get(damageTypeKey);
		if (damageType == null) {
			damageType = world.getRegistryManager()
			  .getOrThrow(RegistryKeys.DAMAGE_TYPE)
			  .get(DamageTypes.GENERIC);
		}
		RegistryEntry<DamageType> damageTypeEntry = world.getRegistryManager()
		  .getOrThrow(RegistryKeys.DAMAGE_TYPE)
		  .getEntry(damageType);
		return new DamageSource(damageTypeEntry, source, attacker);
	}

	public static void applyDamage(@NotNull Entity entity, ServerWorld serverWorld, RegistryKey<DamageType> damageTypeKey, float amount) {
		entity.damage(serverWorld, newDamageSource(serverWorld, damageTypeKey), amount);
	}

	public static void removeNegativeEffects(@NotNull LivingEntity entity) {
		Collection<StatusEffectInstance> effectInstances = entity.getStatusEffects();
		for (StatusEffectInstance effectInstance : effectInstances) {
			if (!effectInstance.getEffectType().value().isBeneficial()) {
				entity.removeStatusEffect(effectInstance.getEffectType());
			}
		}
	}

	public static void addEffectDuration(@NotNull LivingEntity entity, RegistryEntry<StatusEffect> effect, int ticksToAdd) {
		Collection<StatusEffectInstance> effectInstances = entity.getStatusEffects();
		boolean hasEffect = false;
		for (StatusEffectInstance effectInstance : effectInstances) {
			if (effectInstance.getEffectType() == effect) {
				entity.removeStatusEffect(effectInstance.getEffectType());
				entity.addStatusEffect(new StatusEffectInstance(
				  effect,
				  effectInstance.getDuration() + ticksToAdd,
				  effectInstance.getAmplifier(),
				  effectInstance.isAmbient(),
				  effectInstance.shouldShowParticles(),
				  effectInstance.shouldShowIcon())
				);
				hasEffect = true;
			}
		}

		if (!hasEffect) {
			entity.addStatusEffect(new StatusEffectInstance(effect, ticksToAdd, 0, false, false, true));
		}
	}
}
