package net.fawnoculus.ntm.mixin;

import net.fawnoculus.ntm.items.custom.DangerousDrop;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin extends Entity {
    @Shadow
    private int itemAge;

    public ItemEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Shadow
    public abstract ItemStack getStack();

    @Inject(method = "tick", at = @At("HEAD"))
    private void removeWorldSpecificConfig(CallbackInfo ci) {
        if (this.getStack().getItem() instanceof DangerousDrop dangerousDrop
          && this.getEntityWorld() instanceof ServerWorld serverWorld
          && this.getEntityWorld().getEntity(this.uuid) instanceof ItemEntity itemEntity
        ) {
            if (this.itemAge == 0) {
                dangerousDrop.onDropped(serverWorld, this.getEntityPos(), itemEntity);
            }
            if (this.isOnGround()) {
                dangerousDrop.onTouchBlock(serverWorld, this.getEntityPos(), itemEntity);
            }
        }
    }
}
