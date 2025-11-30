package net.fawnoculus.ntm.mixin.accessor;

import net.minecraft.world.PersistentStateManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.nio.file.Path;

@Mixin(PersistentStateManager.class)
public interface PersistentStateManagerAccessor {
    @Accessor("directory")
    Path NTM$getDirectory();
}
