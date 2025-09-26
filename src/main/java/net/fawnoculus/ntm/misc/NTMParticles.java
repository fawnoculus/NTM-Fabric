package net.fawnoculus.ntm.misc;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.fawnoculus.ntm.NTM;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class NTMParticles {
  public static final SimpleParticleType TEST = register("test");

  private static SimpleParticleType register(String name) {
    return register(name, false);
  }

  private static SimpleParticleType register(String name, boolean alwaysShow) {
    SimpleParticleType particle = FabricParticleTypes.simple(alwaysShow);
    Registry.register(Registries.PARTICLE_TYPE, NTM.id(name), particle);
    return particle;
  }

  public static void initialize() {
  }
}
