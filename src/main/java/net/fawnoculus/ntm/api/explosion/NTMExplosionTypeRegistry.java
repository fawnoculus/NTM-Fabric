package net.fawnoculus.ntm.api.explosion;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.NTMConfig;
import net.fawnoculus.ntm.api.explosion.types.NoneExplosionType;
import net.minecraft.util.Identifier;
import net.minecraft.util.Unit;
import org.jetbrains.annotations.ApiStatus;

import java.util.HashMap;
import java.util.Objects;
import java.util.function.Supplier;

@ApiStatus.NonExtendable
public class NTMExplosionTypeRegistry {
	private static final HashMap<Identifier, NTMExplosionType<?>> EXPLOSION_TYPES = new HashMap<>();
	private static final HashMap<NTMExplosionType<?>, Identifier> EXPLOSION_IDENTIFIERS = new HashMap<>();
	public static final Identifier NONE_ID = NTM.id("none");
	public static final NTMExplosionType<Unit> NONE = register(NONE_ID, NoneExplosionType::new);

	public static <T extends NTMExplosionType<?>> T register(Identifier identifier, Supplier<T> explosionTypeSupplier) {
		return registerExplosionType(identifier, explosionTypeSupplier.get());
	}

	public static <T extends NTMExplosionType<?>> T registerExplosionType(Identifier identifier, T type) {
		EXPLOSION_TYPES.put(identifier, type);
		EXPLOSION_IDENTIFIERS.put(type, identifier);
		return type;
	}

	public static NTMExplosionType<?> typeFromId(Identifier id){
		NTMExplosionType<?> type = EXPLOSION_TYPES.get(id);
		if(NTMConfig.DEV_MODE.getValue() && type == null) {
			NTM.LOGGER.warn("tried to get explosion type of an unknown identifier '{}', using none as backup", id.toString());
		}

		return Objects.requireNonNullElse(type, NONE);
	}

	public static Identifier idFromType(NTMExplosionType<?> type){
		Identifier identifier = EXPLOSION_IDENTIFIERS.get(type);
		if(NTMConfig.DEV_MODE.getValue() && identifier == null) {
			NTM.LOGGER.warn("tried to get Identifier of un unregistered type, using none as backup");
		}

		return Objects.requireNonNullElse(identifier, NONE_ID);
	}
}
