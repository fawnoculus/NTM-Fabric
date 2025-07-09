package net.fawnoculus.ntm.world.radiation;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fawnoculus.ntm.entity.ModDamageTypes;
import net.fawnoculus.ntm.entity.ModStatusEffects;
import net.fawnoculus.ntm.items.ModItems;
import net.fawnoculus.ntm.main.NTM;
import net.fawnoculus.ntm.main.NTMConfig;
import net.fawnoculus.ntm.network.custom.RadiationInformationS2CPayload;
import net.fawnoculus.ntm.util.EntityUtil;
import net.fawnoculus.ntm.util.PlayerUtil;
import net.fawnoculus.ntm.util.WorldUtil;
import net.fawnoculus.ntm.util.data.CustomData;
import net.fawnoculus.ntm.util.data.CustomDataHolder;
import net.fawnoculus.ntm.world.radiation.client.ClientRadiationManager;
import net.fawnoculus.ntm.world.radiation.processor.EmptyRadiationProcessor;
import net.fawnoculus.ntm.world.radiation.processor.RadiationProcessorMultiHolder;
import net.fawnoculus.ntm.world.radiation.processor.RadiationProcessor;
import net.minecraft.entity.InventoryOwner;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.EntityList;
import org.jetbrains.annotations.Range;

import java.util.Collection;
import java.util.HashMap;
import java.util.function.Function;

/**
 * The Server Radiation Manager is run on the Logical Server (So it also Runs on Singleplayer Worlds).
 * <br>It Handles the active Radiation in All Loaded Chunks, Giving Players the effects for Radiation Exposure &
 * Send Update Packets to the Players that should Receive Radiation Information so that the {@link ClientRadiationManager ClientRadiationManager} can give it to the Player
 */
public class RadiationManager {
  private static final RadiationManager INSTANCE = new RadiationManager();
  
  public static RadiationManager getInstance(){
    return INSTANCE;
  }
  
  public static void initialize(){
    INSTANCE.addPacketReason(NTM.id("has_geiger_counter"), player -> PlayerUtil.hasItem(player, ModItems.GEIGER_COUNTER));
  }
  
  private final HashMap<Identifier, Function<ServerPlayerEntity, Boolean>> packetReasons = new HashMap<>();
  private final RadiationRegistry radiationRegistry = RadiationRegistry.getInstance();
  private final HazmatRegistry hazmatRegistry = HazmatRegistry.getInstance();
  
  // Packets
  public void addPacketReason(Identifier identifier, Function<ServerPlayerEntity, Boolean> reason){
    this.packetReasons.put(identifier, reason);
  }
  public void removePacketReason(Identifier identifier){
    this.packetReasons.remove(identifier);
  }
  
  public void sendPacket(ServerPlayerEntity player){
    ServerPlayNetworking.send(player, new RadiationInformationS2CPayload(new RadiationInformationS2CPayload.RadiationInfo(
        getRadiationExposure(player),
        getInventoryRadiation(player),
        getPassiveChunkRadiation(player.getServerWorld(), player.getPos()),
        getActiveChunkRadiation(player.getServerWorld(), player.getPos())
    )));
  }
  
  public void sendPacketIfNeeded(Collection<ServerPlayerEntity> players){
    for (ServerPlayerEntity player : players){
      if(shouldSendPacket(player)){
        this.sendPacket(player);
      }
    }
  }
  
  public boolean shouldSendPacket(ServerPlayerEntity player){
    if(NTMConfig.AlwaysSendRadiationPacket.getValue()){
      return true;
    }
    for(Function<ServerPlayerEntity, Boolean> reason : packetReasons.values()){
      if(reason.apply(player)) return true;
    }
    return false;
  }
  
  // Radiation Helpers
  public double getRadiationExposure(LivingEntity entity){
    CustomData entityData = CustomDataHolder.from(entity).NTM$getCustomData();
    return entityData.getOrDefaultDouble(NTM.id("radiation_exposure"), 0.0);
  }
  public void setRadiationExposure(LivingEntity entity, double radiation){
    CustomData entityData = CustomDataHolder.from(entity).NTM$getCustomData();
    entityData.set(NTM.id("radiation_exposure"), radiation);
  }
  
  public double getRadiationResistance(LivingEntity entity){
    double resistance = 0;
    if(entity.hasStatusEffect(ModStatusEffects.RAD_X)){
      resistance += 0.2;
    }
    resistance += hazmatRegistry.getResistance(entity);
    return resistance;
  }
  @Range(from = 0, to = 100)
  public double getRadiationResistancePercentage(LivingEntity entity){
    return 100 - (getRadiationModifier(entity) * 100);
  }
  @Range(from = 0, to = 1)
  public double getRadiationModifier(LivingEntity entity){
    return Math.pow(10.0, -getRadiationResistance(entity));
  }
  
  public double getInventoryRadiation(LivingEntity entity){
    if(entity instanceof InventoryOwner inventoryOwner){
      double radioactivity = 0;
      for(ItemStack stack : inventoryOwner.getInventory()){
        radioactivity += radiationRegistry.getRadioactivity(stack);
      }
      return radioactivity;
    }
    if(entity instanceof PlayerEntity player){
      double radioactivity = 0;
      for(ItemStack stack : player.getInventory()){
        radioactivity += radiationRegistry.getRadioactivity(stack);
      }
      return radioactivity;
    }
    return 0;
  }
  public double getActiveChunkRadiation(ServerWorld world, Vec3d pos){
    return RadiationProcessorMultiHolder.from(world).NTM$getRadiationProcessor(WorldUtil.getChunkPos(pos)).getActiveRadiation(pos);
  }
  public double getPassiveChunkRadiation(ServerWorld world, Vec3d pos){
    return RadiationProcessorMultiHolder.from(world).NTM$getRadiationProcessor(WorldUtil.getChunkPos(pos)).getPassiveRadiation(pos);
  }
  public double getChunkRadiation(ServerWorld world, Vec3d pos){
    return getActiveChunkRadiation(world, pos) + getPassiveChunkRadiation(world, pos);
  }
  public double getTotalRadiation(LivingEntity entity){
    if(entity.getWorld() instanceof ServerWorld serverWorld){
      return this.getChunkRadiation(serverWorld, entity.getPos()) + getInventoryRadiation(entity);
    }
    return 0;
  }
  
  // Radiation Modifiers
  public void decreaseRadiationExposure(LivingEntity entity, double amount){
    double radiationExposure = getRadiationExposure(entity);
    setRadiationExposure(entity, Math.clamp(radiationExposure - amount, 0, 1_000_000));
  }
  public void increaseRadiationExposure(LivingEntity entity, double amount){
    if(!(entity.getWorld() instanceof ServerWorld serverWorld)) return;
    
    double radiationExposure = getRadiationExposure(entity);
    radiationExposure += amount;
    
    if(radiationExposure >= 1_000_000){
      EntityUtil.applyDamage(entity, serverWorld, ModDamageTypes.RADIATION, Float.MAX_VALUE);
      setRadiationExposure(entity, 0);
    }else {
      setRadiationExposure(entity, radiationExposure);
    }
  }
  
  // Radiation Ticking
  public void tick(ServerWorld world, EntityList entityList){
    for(RadiationProcessor processor : RadiationProcessorMultiHolder.from(world).NTM$getRadiationProcessors()){
      processor.tick();
    }
    
    entityList.forEach(entity -> {
      if(entity instanceof LivingEntity livingEntity){
        this.processEntityRadiation(livingEntity);
      }
    });
    
    this.sendPacketIfNeeded(world.getPlayers());
  }
  
  public void processEntityRadiation(LivingEntity entity){
    if(NTMConfig.DisableEntityRadiation.getValue()) return;
    if(entity.isInvulnerable() || entity.isInCreativeMode()) return;
    increaseRadiationExposure(entity, getTotalRadiation(entity) * getRadiationModifier(entity) / 20.0);
  }
  
  public RadiationProcessor makeNewRadiationProcessor(ChunkPos pos){
    if(NTMConfig.DisableChunkRadiation.getValue()){
      return new EmptyRadiationProcessor();
    }
    // TODO: other Radiation Processors
    return new EmptyRadiationProcessor();
  }
}
