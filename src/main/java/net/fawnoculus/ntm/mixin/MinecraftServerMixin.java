package net.fawnoculus.ntm.mixin;

import net.fawnoculus.ntm.api.config.PerWorldConfigFile;
import net.fawnoculus.ntm.util.WorldUtil;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.storage.LevelStorage;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.nio.file.Path;
import java.util.List;

@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMixin {
	@Shadow
	@Final
	protected LevelStorage.Session session;

	@Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/storage/LevelStorage$Session;createSaveHandler()Lnet/minecraft/world/PlayerSaveHandler;"))
	private void createWorldSpecificConfig(CallbackInfo ci) {
		List<PerWorldConfigFile> perWorldConfigFiles = PerWorldConfigFile.getPerWorldConfigFiles();
		Path worldConfigDir = this.session.getDirectory().path().resolve("data");

		for (PerWorldConfigFile configFile : perWorldConfigFiles) {
			configFile.setWorldPath(worldConfigDir);
		}
	}

	@Inject(at = @At("TAIL"), method = "shutdown")
	private void removeWorldSpecificConfig(CallbackInfo ci) {
		List<PerWorldConfigFile> perWorldConfigFiles = PerWorldConfigFile.getPerWorldConfigFiles();

		for (PerWorldConfigFile configFile : perWorldConfigFiles) {
			configFile.removeWorldPath();
		}
	}

	@Inject(at = @At("TAIL"), method = "save")
	private void saveCustomRegionNBT(boolean suppressLogs, boolean flush, boolean force, CallbackInfoReturnable<Boolean> cir) {
		WorldUtil.flushCachedRegionNBT();
	}
}
