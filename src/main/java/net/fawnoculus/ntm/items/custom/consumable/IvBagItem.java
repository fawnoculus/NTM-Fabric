package net.fawnoculus.ntm.items.custom.consumable;

import net.fawnoculus.ntm.entity.NTMDamageTypes;
import net.fawnoculus.ntm.items.NTMItems;
import net.fawnoculus.ntm.misc.NTMSounds;
import net.fawnoculus.ntm.util.EntityUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class IvBagItem extends Item {
	public IvBagItem(Settings settings) {
		super(settings);
	}


	@Override
	public ActionResult use(World world, PlayerEntity player, Hand hand) {
		if (world.isClient()) {
			return ActionResult.SUCCESS;
		}
		if (!player.isCreative()) {
			EntityUtil.applyDamage(player, (ServerWorld) world, NTMDamageTypes.BLOOD_LOSS, 5F);
			ItemStack stack = player.getStackInHand(hand);
			stack.decrement(1);
		}
		world.playSound(null, BlockPos.ofFloored(player.getPos()).up(), NTMSounds.IV_BAG_INJECTS, SoundCategory.PLAYERS);
		player.getInventory().offerOrDrop(new ItemStack(NTMItems.BLOOD_BAG));

		return ActionResult.SUCCESS_SERVER;
	}

	@Override
	public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		if (!(target.getWorld() instanceof ServerWorld world) || !(attacker instanceof PlayerEntity player)) {
			return;
		}
		if (!player.isCreative()) {
			EntityUtil.applyDamage(target, world, NTMDamageTypes.BLOOD_LOSS, 5F);
			stack.decrement(1);
		}
		world.playSound(null, BlockPos.ofFloored(target.getPos()).up(), NTMSounds.IV_BAG_INJECTS, SoundCategory.PLAYERS);
		player.getInventory().offerOrDrop(new ItemStack(NTMItems.BLOOD_BAG));
	}
}
