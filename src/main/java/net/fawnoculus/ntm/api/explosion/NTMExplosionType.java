package net.fawnoculus.ntm.api.explosion;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fawnoculus.ntm.network.s2c.NTMExplosionPayload;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;

/**
 * A type of Explosion
 * @param <T> ExtraData used by this type (like explosion radius)
 */
public interface NTMExplosionType<T> {
	Codec<NTMExplosionType<?>> CODEC = Identifier.CODEC.xmap(NTMExplosionTypeRegistry::typeFromId, NTMExplosionTypeRegistry::idFromType);
	PacketCodec<ByteBuf, NTMExplosionType<?>> PACKET_CODEC = Identifier.PACKET_CODEC.xmap(NTMExplosionTypeRegistry::typeFromId, NTMExplosionTypeRegistry::idFromType);

	/**
	 * Makes on explosion of this type in a given word
	 * @param world the World in which the explosion is taking place
	 * @param pos the position at which the explosion is taking place
	 * @param extraData extra Data for this Explosion
	 */
	default void explode(ServerWorld world, BlockPos pos, T extraData) {
		NTMExplosionPayload<T> payload = new NTMExplosionPayload<>(this, pos, extraData);

		for (ServerPlayerEntity player : this.getAffectedPlayers(world, pos, extraData)) {
			ServerPlayNetworking.send(player, payload);
		}

		this.onExplode(world, pos, extraData);
	}

	/**
	 * Get Players who will be sent a Packet so that the ClientExplosionHandler can do stuff like spawn particles
	 * @param world the World in which the explosion is taking place
	 * @param pos the position at which the explosion is taking place
	 * @param extraData extra Data for this Explosion
	 * @return A collection of all players that will be sent an Explosion Packet
	 */
	default Iterable<ServerPlayerEntity> getAffectedPlayers(ServerWorld world, BlockPos pos, T extraData) {
		ArrayList<ServerPlayerEntity> players = new ArrayList<>();

		for (ServerPlayerEntity player : world.getPlayers()) {
			if (player.getBlockPos().isWithinDistance(pos,  world.getServer().getPlayerManager().getViewDistance() * 16)) {
				players.add(player);
			}
		}

		return players;
	}

	/**
	 * Handle the explosion (break blocks and shit) does not send packets to the players, to do that use {@link NTMExplosionType#explode(ServerWorld, BlockPos, T)}
	 * @param world the World in which the explosion is taking place
	 * @param pos the position at which the explosion is taking place
	 * @param extraData extra Data for this Explosion
	 */
	void onExplode(ServerWorld world, BlockPos pos, T extraData);

	Codec<T> getExtraDataCodec();
}
