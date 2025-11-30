package net.fawnoculus.ntm.api.explosion.types;

import com.mojang.serialization.Codec;
import net.fawnoculus.ntm.api.explosion.NTMExplosionType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Unit;
import net.minecraft.util.math.BlockPos;

import java.util.Collection;
import java.util.List;

public class NoneExplosionType implements NTMExplosionType<Unit> {

    @Override
    public Codec<Unit> getExtraDataCodec() {
        return Unit.CODEC;
    }

    @Override
    public void onExplode(ServerWorld world, BlockPos pos, Unit extraData) {
    }

    @Override
    public Collection<ServerPlayerEntity> getAffectedPlayers(ServerWorld world, BlockPos pos, Unit extraData) {
        return List.of();
    }
}
