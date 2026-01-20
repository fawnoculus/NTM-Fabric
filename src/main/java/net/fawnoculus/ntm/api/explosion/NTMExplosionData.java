package net.fawnoculus.ntm.api.explosion;

import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;

/**
 * Generic Data to be handed to the {@linkplain NTMExplosionType Explosion Type} for explosion processing (Serverside only)
 *
 * @param server The Minecraft Server on which the explosion is happening
 * @param world  The World in which the explosion is happening
 * @param pos    The position at which the explosion is taking place
 */
public record NTMExplosionData(MinecraftServer server, ServerLevel world, BlockPos pos) {
}
