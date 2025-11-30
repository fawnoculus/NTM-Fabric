package net.fawnoculus.ntm.items.custom.consumable;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.BiConsumer;

public class InjectionItem extends Item {
    private final @Nullable SoundEvent SOUND;
    private final List<Item> RETURN_ITEMS;
    private final BiConsumer<ServerWorld, LivingEntity> SERVER_USE;
    public InjectionItem(Settings settings, @Nullable SoundEvent sound, @Nullable Item returnItem, BiConsumer<ServerWorld, LivingEntity> serverUse) {
        this(settings, sound, returnItem != null ? List.of(returnItem) : List.of(), serverUse);
    }
    public InjectionItem(Settings settings, @Nullable SoundEvent sound, List<Item> returnItems, BiConsumer<ServerWorld, LivingEntity> serverUse) {
        super(settings);

        this.SOUND = sound;
        this.RETURN_ITEMS = returnItems;
        this.SERVER_USE = serverUse;
    }

    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand) {
        if (world.isClient()) {
            return ActionResult.SUCCESS;
        }
        if (!player.isCreative()) {
            ItemStack stack = player.getStackInHand(hand);
            stack.decrement(1);
        }
        if (this.SOUND != null) {
            world.playSound(null, BlockPos.ofFloored(player.getPos()).up(), this.SOUND, SoundCategory.PLAYERS);
        }
        for (Item returnItem : RETURN_ITEMS) {
            player.getInventory().offerOrDrop(new ItemStack(returnItem));
        }

        this.SERVER_USE.accept((ServerWorld) world, player);

        return ActionResult.SUCCESS_SERVER;
    }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target.getWorld().isClient() || !(attacker instanceof PlayerEntity player)) {
            return;
        }
        ServerWorld world = (ServerWorld) target.getWorld();
        if (!player.isCreative()) {
            stack.decrement(1);
        }
        if (this.SOUND != null) {
            world.playSound(null, BlockPos.ofFloored(player.getPos()).up(), this.SOUND, SoundCategory.PLAYERS);
        }
        for (Item returnItem : RETURN_ITEMS) {
            player.getInventory().offerOrDrop(new ItemStack(returnItem));
        }

        this.SERVER_USE.accept(world, target);
    }
}
