package net.fawnoculus.ntm.api.radiation.processor;

import net.fawnoculus.ntm.api.radiation.RadiationManager;
import net.fawnoculus.ntm.api.radiation.RadiationRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;

/**
 * Simple Chunk Based Radiation Processor
 */
public class SimpleRadiationProcessor implements RadiationProcessor {
  public SimpleRadiationProcessor(ServerWorld world, ChunkPos pos) {
    this.WORLD = world;
    this.POS = pos;
    this.passiveRadiation = RadiationRegistry.getRadioactivity(WORLD);
    this.activeRadiation = 0;
  }

  private final ServerWorld WORLD;
  private final ChunkPos POS;
  private double passiveRadiation;
  private double activeRadiation;

  @Override
  public void tick() {
    double toBeSpreadRadiation = (this.activeRadiation + this.passiveRadiation) / 5; // one fifth of total radiation is to be spread

    this.activeRadiation = (this.activeRadiation / 5) * 4; // remove one third of active radiation
    if (this.activeRadiation < 1) {
      this.activeRadiation = 0; // remove all active radiation of there is less than 1 milliRAD/s
    }

    double spreadRadiationPerChunk = toBeSpreadRadiation / 4; // one fifth of the to be spread radiation is lost

    if (RadiationManager.getRadiationProcessor(this.WORLD, new ChunkPos(this.POS.x - 1, this.POS.z)) instanceof SimpleRadiationProcessor processor) {
      processor.activeRadiation += spreadRadiationPerChunk;
    }
    if (RadiationManager.getRadiationProcessor(this.WORLD, new ChunkPos(this.POS.x + 1, this.POS.z)) instanceof SimpleRadiationProcessor processor) {
      processor.activeRadiation += spreadRadiationPerChunk;
    }
    if (RadiationManager.getRadiationProcessor(this.WORLD, new ChunkPos(this.POS.x, this.POS.z - 1)) instanceof SimpleRadiationProcessor processor) {
      processor.activeRadiation += spreadRadiationPerChunk;
    }
    if (RadiationManager.getRadiationProcessor(this.WORLD, new ChunkPos(this.POS.x, this.POS.z + 1)) instanceof SimpleRadiationProcessor processor) {
      processor.activeRadiation += spreadRadiationPerChunk;
    }
    // if a chunk is not loaded the radiation going into it is also lost
  }

  @Override
  public double getPassiveRadiation(Vec3d pos) {
    return this.passiveRadiation;
  }

  @Override
  public double getActiveRadiation(Vec3d pos) {
    return this.activeRadiation;
  }

  @Override
  public void onChangeBlock(BlockState newState, BlockState previousState, BlockPos pos) {
    this.passiveRadiation = Math.clamp(
      this.passiveRadiation - RadiationRegistry.getRadioactivity(previousState) + RadiationRegistry.getRadioactivity(newState),
      0, Double.MAX_VALUE
    );
  }

  @Override
  public void writeData(NbtCompound data) {
    data.putString("radiation_processor_type", "simple");
    data.putDouble("active_radiation", this.activeRadiation);
    data.putDouble("passive_radiation", this.passiveRadiation);
  }

  @Override
  public void readData(NbtCompound data) {
    String type = data.getString("radiation_processor_type", "no_processor");
    if (type.equals("simple")) {
      this.activeRadiation = data.getDouble("active_radiation", 0.0);
      this.passiveRadiation = data.getDouble("passive_radiation", 0.0);
    }
  }
}
