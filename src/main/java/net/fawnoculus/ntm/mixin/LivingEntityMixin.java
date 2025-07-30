package net.fawnoculus.ntm.mixin;

import net.fawnoculus.ntm.misc.data.CustomDataHolder;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin implements CustomDataHolder {
  @Unique
  NbtCompound NTM$customData = new NbtCompound();
  
  @Inject(at = @At("HEAD"), method = "readCustomDataFromNbt")
  protected void readCustomData(NbtCompound nbt, CallbackInfo ci){
    NbtElement data = nbt.get(CustomDataHolder.KEY);
    if(data instanceof NbtCompound nbtCompound){
      NTM$customData = nbtCompound;
    }
  }
  
  @Inject(at = @At("HEAD"), method = "writeCustomDataToNbt")
  protected void writeCustomData(NbtCompound nbt, CallbackInfo ci){
    nbt.put(CustomDataHolder.KEY, NTM$customData);
  }
  
  @Override
  public @NotNull NbtCompound NTM$getCustomData() {
    if(NTM$customData == null){
      NTM$customData = new NbtCompound();
    }
    return NTM$customData;
  }
  @Override
  public void NTM$setCustomData(NbtCompound customData) {
    this.NTM$customData = customData;
  }
}
