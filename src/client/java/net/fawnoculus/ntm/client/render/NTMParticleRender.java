package net.fawnoculus.ntm.client.render;

import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fawnoculus.ntm.misc.NTMParticles;
import net.minecraft.client.particle.EndRodParticle;

public class NTMParticleRender {
    public static void initialize() {
        ParticleFactoryRegistry.getInstance().register(NTMParticles.TEST, EndRodParticle.Factory::new);
    }
}
