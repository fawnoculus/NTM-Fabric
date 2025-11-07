package net.fawnoculus.ntm.api.explosion;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.api.explosion.types.SimpleExplosionType;

import java.util.function.Supplier;

public class NTMExplosionTypes {
	public static final SimpleExplosionType SIMPLE = register("simple", SimpleExplosionType::new);

	private static <T extends NTMExplosionType<?>> T register(String name, Supplier<T> explosionTypeSupplier) {
		return NTMExplosionTypeRegistry.register(NTM.id(name), explosionTypeSupplier);
	}

	public static void initialize(){
	}
}
