package net.fawnoculus.ntm.client.api.explosion;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fawnoculus.ntm.api.explosion.NTMExplosionType;
import net.minecraft.util.math.BlockPos;

public abstract class NTMExplosionHandler<T> {
	public final NTMExplosionType<T> TYPE;

	public NTMExplosionHandler(NTMExplosionType<T> type) {
		this.TYPE = type;
	}

 	public abstract void onExplosion(ClientPlayNetworking.Context context, BlockPos pos, T extraData);
}
