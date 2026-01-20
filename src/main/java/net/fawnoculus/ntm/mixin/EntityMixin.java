package net.fawnoculus.ntm.mixin;

import net.fawnoculus.ntm.misc.data.CustomDataHolder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class EntityMixin implements CustomDataHolder {
    @Unique
    CompoundTag NTM$customData = new CompoundTag();

    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;readAdditionalSaveData(Lnet/minecraft/world/level/storage/ValueInput;)V"), method = "load")
    protected void readCustomData(ValueInput view, CallbackInfo ci) {
        Tag data = view.read(CustomDataHolder.KEY, CompoundTag.CODEC).orElse(new CompoundTag());
        if (data instanceof CompoundTag nbtCompound) {
            NTM$customData = nbtCompound;
        }
    }

    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;addAdditionalSaveData(Lnet/minecraft/world/level/storage/ValueOutput;)V"), method = "saveWithoutId")
    protected void writeCustomData(ValueOutput view, CallbackInfo ci) {
        view.store(CustomDataHolder.KEY, CompoundTag.CODEC, NTM$customData);
    }

    @Override
    public @NotNull CompoundTag NTM$getCustomData() {
        return NTM$customData;
    }

    @Override
    public void NTM$setCustomData(CompoundTag customData) {
        NTM$customData = customData;
    }
}
