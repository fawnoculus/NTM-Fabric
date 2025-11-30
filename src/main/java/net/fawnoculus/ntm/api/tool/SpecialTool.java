package net.fawnoculus.ntm.api.tool;


import net.fawnoculus.ntm.NTM;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface SpecialTool {
    Identifier ADVANCED_MESSAGE_ID = NTM.id("tool_ability");

    AbilityHandler abilityHandler();

    ModifierHandler modifierHandler();

    boolean canBreakDepthRock();

    default void preMine(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner) {
        this.abilityHandler().preBreak(stack, world, state, pos, miner);
    }
}
