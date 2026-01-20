package net.fawnoculus.ntm.api.events;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.api.config.PerWorldConfigFile;
import net.fawnoculus.ntm.api.events.custom.*;
import net.fawnoculus.ntm.api.explosion.NTMExplosionSystem;
import net.fawnoculus.ntm.api.radiation.HazmatRegistry;
import net.fawnoculus.ntm.api.radiation.RadiationRegistry;
import net.fawnoculus.ntm.fluid.data.FluidDataRegistry;
import net.fawnoculus.ntm.mixin.accessor.MinecraftServerAccessor;
import net.fawnoculus.ntm.network.s2c.FluidDataRegistryPayload;
import net.fawnoculus.ntm.network.s2c.HazmatRegistryPayload;
import net.fawnoculus.ntm.network.s2c.NTMVersionPayload;
import net.fawnoculus.ntm.network.s2c.RadiationRegistryPayload;
import net.fawnoculus.ntm.util.WorldUtil;

import java.nio.file.Path;

public class NTMEvents {
    public static void initialize() {
        PlayerJoinEvent.PRE_JOIN.register((connection, player, clientData) ->
          ServerPlayNetworking.send(player, new NTMVersionPayload(NTM.MOD_VERSION))
        );

        PlayerJoinEvent.POST_JOIN.register((connection, player, clientData) ->
          ServerPlayNetworking.send(player, new RadiationRegistryPayload(RadiationRegistry.serialize()))
        );
        PlayerJoinEvent.POST_JOIN.register((connection, player, clientData) ->
          ServerPlayNetworking.send(player, new HazmatRegistryPayload(HazmatRegistry.serialize()))
        );
        PlayerJoinEvent.POST_JOIN.register((connection, player, clientData) ->
          ServerPlayNetworking.send(player, new FluidDataRegistryPayload(FluidDataRegistry.encodeAllFluidData()))
        );

        ServerStartEvent.POST_START.register(server -> {
            @SuppressWarnings("all") // Ignore the warning about LevelStorage.Session being an auto closable
            Path worldConfigDir = ((MinecraftServerAccessor) server).NTM$getStorageSource().getLevelDirectory().path().resolve("data");

            for (PerWorldConfigFile configFile : PerWorldConfigFile.getPerWorldConfigFiles()) {
                configFile.setWorldPath(worldConfigDir);
            }
        });

        ServerShutdownEvent.POST_SHUTDOWN.register(ignored -> PerWorldConfigFile.getPerWorldConfigFiles().forEach(PerWorldConfigFile::removeWorldPath));

        ServerSaveEvent.POST_SAVE.register((ignored, ignored2, ignored3, ignored4) -> WorldUtil.flushCachedRegionNBT());

        ServerTickEvent.POST_TICK.register((server, shouldKeepTicking, tickStartNanoTime) -> {
            if (!server.tickRateManager().runsNormally()) {
                return;
            }

            NTMExplosionSystem.processExplosions(tickStartNanoTime - System.nanoTime());
        });
    }
}
