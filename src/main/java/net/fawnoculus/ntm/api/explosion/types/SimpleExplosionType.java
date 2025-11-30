package net.fawnoculus.ntm.api.explosion.types;

import com.mojang.serialization.Codec;
import net.fawnoculus.ntm.api.explosion.NTMExplosionType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SimpleExplosionType implements NTMExplosionType<Float> {
    @Override
    public Codec<Float> getExtraDataCodec() {
        return Codec.FLOAT;
    }

    @Override
    public void onExplode(ServerWorld world, BlockPos pos, Float extraData) {
        world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), extraData, World.ExplosionSourceType.NONE);
    }
}
