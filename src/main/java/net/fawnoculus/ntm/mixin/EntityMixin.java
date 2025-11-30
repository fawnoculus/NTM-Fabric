package net.fawnoculus.ntm.mixin;

import net.fawnoculus.ntm.misc.data.CustomDataHolder;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class EntityMixin implements CustomDataHolder {
    @Unique
    NbtCompound NTM$customData = new NbtCompound();

    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;readCustomData(Lnet/minecraft/storage/ReadView;)V"), method = "readData")
    protected void readCustomData(ReadView view, CallbackInfo ci) {
        NbtElement data = view.read(CustomDataHolder.KEY, NbtCompound.CODEC).orElse(new NbtCompound());
        if (data instanceof NbtCompound nbtCompound) {
            NTM$customData = nbtCompound;
        }
    }

    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;writeCustomData(Lnet/minecraft/storage/WriteView;)V"), method = "writeData")
    protected void writeCustomData(WriteView view, CallbackInfo ci) {
        view.put(CustomDataHolder.KEY, NbtCompound.CODEC, NTM$customData);
    }

    @Override
    public @NotNull NbtCompound NTM$getCustomData() {
        return NTM$customData;
    }

    @Override
    public void NTM$setCustomData(NbtCompound customData) {
        NTM$customData = customData;
    }
}
