package net.fawnoculus.ntm.render;

import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fawnoculus.ntm.misc.ModParticles;
import net.minecraft.client.particle.EndRodParticle;

public class ModParticleRender {
  public static void initialize(){
    ParticleFactoryRegistry.getInstance().register(ModParticles.TEST, EndRodParticle.Factory::new);
  }
}
