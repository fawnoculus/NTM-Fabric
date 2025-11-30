package net.fawnoculus.ntm.client.api.explosion.handlers;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fawnoculus.ntm.api.explosion.NTMExplosionType;
import net.fawnoculus.ntm.client.api.explosion.NTMExplosionHandler;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class SimpleExplosionHandler extends NTMExplosionHandler<Float> {
    public SimpleExplosionHandler(NTMExplosionType<Float> type) {
        super(type);
    }

    @Override
    public void onExplosion(ClientPlayNetworking.Context context, BlockPos pos, Float extraData) {
        context.client().world.addParticleClient(ParticleTypes.SMOKE, pos.getX(), pos.getY(), pos.getZ(), 0, 0, 0);
        context.player().sendMessage(Text.literal(pos.toShortString()), false);
    }
}
