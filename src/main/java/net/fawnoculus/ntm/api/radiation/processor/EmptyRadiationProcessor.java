package net.fawnoculus.ntm.api.radiation.processor;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

/**
 * A Radiation Processor that does absolutely nothing.
 */
public class EmptyRadiationProcessor implements RadiationProcessor {
	@Override
	public void tick() {
	}

	@Override
	public double getPassiveRadiation(Vec3d pos) {
		return 0;
	}

	@Override
	public double getActiveRadiation(Vec3d pos) {
		return 0;
	}

	@Override
	public void onChangeBlock(BlockState newState, BlockState previousState, BlockPos pos) {
	}

	@Override
	public void writeData(NbtCompound data) {
	}

	@Override
	public void readData(NbtCompound data) {
	}
}
