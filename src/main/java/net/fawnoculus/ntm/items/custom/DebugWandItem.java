package net.fawnoculus.ntm.items.custom;

import net.fawnoculus.ntm.api.explosion.NTMExplosionTypes;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

import java.util.function.Consumer;

public class DebugWandItem extends Item {
	public DebugWandItem(Settings settings) {
		super(settings);
	}

	@Override
	public ActionResult use(World world, PlayerEntity user, Hand hand) {
		if (world.isClient()) {
			return ActionResult.SUCCESS;
		}

		BlockHitResult hitResult = (BlockHitResult) user.raycast(256, 0, false);
		if (hitResult.getType() == HitResult.Type.BLOCK) {
			NTMExplosionTypes.SIMPLE.explode((ServerWorld) world, hitResult.getBlockPos(), 10f);
		}

		return ActionResult.SUCCESS_SERVER;
	}

	@Override
	@SuppressWarnings("deprecation")
	public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> tooltip, TooltipType type) {
		tooltip.accept(Text.translatable("tooltip.ntm.creative_only").formatted(Formatting.GRAY));
		tooltip.accept(Text.translatable("tooltip.ntm.debug_wand").formatted(Formatting.GRAY));
	}
}
