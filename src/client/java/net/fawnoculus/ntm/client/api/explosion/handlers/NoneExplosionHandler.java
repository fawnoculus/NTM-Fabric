package net.fawnoculus.ntm.client.api.explosion.handlers;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fawnoculus.ntm.api.explosion.NTMExplosionType;
import net.fawnoculus.ntm.client.api.explosion.NTMExplosionHandler;
import net.minecraft.util.Unit;
import net.minecraft.util.math.BlockPos;

public class NoneExplosionHandler extends NTMExplosionHandler<Unit> {
	public NoneExplosionHandler(NTMExplosionType<Unit> type) {
		super(type);
	}

	@Override
	public void onExplosion(ClientPlayNetworking.Context context, BlockPos pos, Unit extraData) {

	}
}
