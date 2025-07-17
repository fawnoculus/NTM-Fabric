package net.fawnoculus.ntm.misc.radiation.processor;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.misc.data.CustomData;
import net.fawnoculus.ntm.misc.radiation.RadiationManager;
import net.fawnoculus.ntm.misc.radiation.RadiationRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

/**
 * Simple Chunk Based Radiation Processor
 */
public class SimpleRadiationProcessor implements RadiationProcessor {
  public static final RadiationManager radiationManager = RadiationManager.getInstance();
  public static final RadiationRegistry radiationRegistry = RadiationRegistry.getInstance();
  
  public SimpleRadiationProcessor(ServerWorld world, ChunkPos pos) {
    this.WORLD = world;
    this.POS = pos;
    this.passiveRadiation = radiationRegistry.getRadioactivity(WORLD);
    this.activeRadiation = 0;
  }
  
  private final ServerWorld WORLD;
  private final ChunkPos POS;
  private double passiveRadiation;
  private double activeRadiation;
  
  @Override
  public void tick() {
    double toBeSpreadRadiation = (this.activeRadiation + this.passiveRadiation) / 3; // one third of total radiation is to be spread
    
    this.activeRadiation = (this.activeRadiation / 3) * 2; // remove one third of active radiation
    if(this.activeRadiation < 1){
      this.activeRadiation = 0; // remove all active radiation of there is less than 1 milliRAD/s
    }
    
    double spreadRadiationPerChunk = toBeSpreadRadiation / 5; // one fifth of the to be spread radiation is lost
    
    if(radiationManager.getRadiationProcessor(this.WORLD, new ChunkPos(this.POS.x - 1, this.POS.z)) instanceof SimpleRadiationProcessor processor){
      processor.activeRadiation += spreadRadiationPerChunk;
    }
    if(radiationManager.getRadiationProcessor(this.WORLD, new ChunkPos(this.POS.x + 1, this.POS.z)) instanceof SimpleRadiationProcessor processor){
      processor.activeRadiation += spreadRadiationPerChunk;
    }
    if(radiationManager.getRadiationProcessor(this.WORLD, new ChunkPos(this.POS.x, this.POS.z - 1)) instanceof SimpleRadiationProcessor processor){
      processor.activeRadiation += spreadRadiationPerChunk;
    }
    if(radiationManager.getRadiationProcessor(this.WORLD, new ChunkPos(this.POS.x, this.POS.z + 1)) instanceof SimpleRadiationProcessor processor){
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
        this.passiveRadiation - radiationRegistry.getRadioactivity(previousState) + radiationRegistry.getRadioactivity(newState),
        0, Double.MAX_VALUE
    );
  }
  
  @Override
  public void writeData(CustomData data) {
    data.set(NTM.id("radiation_processor_type"), "simple");
    data.set(NTM.id("active_radiation"), this.activeRadiation);
    data.set(NTM.id("passive_radiation"), this.passiveRadiation);
  }
  
  @Override
  public void readData(CustomData data) {
    String type = data.getOrDefaultString(NTM.id("radiation_processor_type"), "no_processor");
    if(type.equals("simple")){
      this.activeRadiation = data.getOrDefaultDouble(NTM.id("active_radiation"), 0.0);
      this.passiveRadiation = data.getOrDefaultDouble(NTM.id("passive_radiation"), 0.0);
    }
  }
}
