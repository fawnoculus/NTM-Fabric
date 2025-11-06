package net.fawnoculus.ntm.fluid;

import net.fawnoculus.ntm.NTM;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class NTMFluids {


	private static <T extends Fluid> T register(String name, T fluid) {
		return Registry.register(Registries.FLUID, NTM.id(name), fluid);
	}

	public static void initialize() {
	}
}
