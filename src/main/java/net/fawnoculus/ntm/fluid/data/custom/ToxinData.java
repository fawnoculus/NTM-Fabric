package net.fawnoculus.ntm.fluid.data.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

public record ToxinData(@NotNull Boolean isToxic, ToxinType type, float damagePerSec, @NotNull Optional<Identifier> damageID, @NotNull List<StatusEffectInstance> effects) {
  public static final ToxinData DEFAULT = new ToxinData(false, ToxinType.CHEMICAL_GAS, 0, Optional.empty(), List.of());
  public static final Codec<ToxinData> CODEC = RecordCodecBuilder.create(
    instance -> instance.group(
      Codec.BOOL.fieldOf("is_toxic").forGetter(ToxinData::isToxic),
      ToxinType.CODEC.fieldOf("type").forGetter(ToxinData::type),
      Codec.FLOAT.fieldOf("dps").forGetter(ToxinData::damagePerSec),
      Codec.optionalField("damageID", Identifier.CODEC, false).forGetter(ToxinData::damageID),
      Codec.list(StatusEffectInstance.CODEC).fieldOf("effects").forGetter(ToxinData::effects)
    ).apply(instance, ToxinData::new)
  );

  public ToxinData(@NotNull Boolean isToxic, ToxinType type, float damagePerSec, Identifier damageID, @NotNull List<StatusEffectInstance> effects) {
    this(isToxic, type, damagePerSec, Optional.ofNullable(damageID), effects);
  }

  public RegistryKey<DamageType> getDamageType() {
    return RegistryKey.of(RegistryKeys.DAMAGE_TYPE, this.damageID().orElse(DamageTypes.GENERIC.getValue()));
  }
}
