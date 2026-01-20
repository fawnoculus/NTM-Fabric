package net.fawnoculus.ntm.fluid;

import net.fawnoculus.ntm.NTM;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.material.Fluid;

public class NTMFluids {


    private static <T extends Fluid> T register(String name, T fluid) {
        return Registry.register(BuiltInRegistries.FLUID, NTM.id(name), fluid);
    }

    public static void initialize() {
    }
}
