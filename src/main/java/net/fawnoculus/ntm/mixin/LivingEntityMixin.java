package net.fawnoculus.ntm.mixin;

import net.fawnoculus.ntm.util.data.CustomData;
import net.fawnoculus.ntm.util.data.CustomDataHolder;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.NbtCompound;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin implements CustomDataHolder {
  @Unique
  CustomData customData = new CustomData();
  
  @Inject(at = @At("HEAD"), method = "readCustomDataFromNbt")
  protected void readCustomData(NbtCompound nbt, CallbackInfo ci){
    Optional<String> string = nbt.getString(CustomData.KEY);
    customData = string.map(CustomData::new).orElseGet(CustomData::new);
  }
  
  @Inject(at = @At("HEAD"), method = "writeCustomDataToNbt")
  protected void writeCustomData(NbtCompound nbt, CallbackInfo ci){
    nbt.putString(CustomData.KEY, customData.getDataAsString());
  }
  
  @Override
  public @NotNull CustomData NTM$getCustomData() {
    if(customData == null){
      customData = new CustomData();
    }
    return customData;
  }
  @Override
  public void NTM$setCustomData(CustomData customData) {
    this.customData = customData;
  }
}
