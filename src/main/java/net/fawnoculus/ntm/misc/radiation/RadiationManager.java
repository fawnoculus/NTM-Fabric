package net.fawnoculus.ntm.misc.radiation;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fawnoculus.ntm.entity.NTMDamageTypes;
import net.fawnoculus.ntm.entity.NTMStatusEffects;
import net.fawnoculus.ntm.items.NTMItems;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.NTMConfig;
import net.fawnoculus.ntm.misc.radiation.processor.SimpleRadiationProcessor;
import net.fawnoculus.ntm.network.s2c.RadiationInformationPayload;
import net.fawnoculus.ntm.util.EntityUtil;
import net.fawnoculus.ntm.util.PlayerUtil;
import net.fawnoculus.ntm.util.WorldUtil;
import net.fawnoculus.ntm.misc.data.CustomDataHolder;
import net.fawnoculus.ntm.misc.radiation.processor.EmptyRadiationProcessor;
import net.fawnoculus.ntm.misc.radiation.processor.RadiationProcessorMultiHolder;
import net.fawnoculus.ntm.misc.radiation.processor.RadiationProcessor;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.EntityList;

import java.util.Collection;
import java.util.HashMap;
import java.util.function.Function;

/**
 * The Server Radiation Manager is run on the Logical Server (So it also Runs on Singleplayer Worlds).
 * <br>It Handles the active Radiation in All Loaded Chunks, Giving Players the effects for Radiation Exposure &
 * Send Update Packets to the Players that should Receive Radiation Information so that the ClientRadiationManager can give it to the Player
 */
public class RadiationManager {
  private static final RadiationManager INSTANCE = new RadiationManager();

  public static RadiationManager getInstance(){
    return INSTANCE;
  }

  public static void initialize(){
    INSTANCE.addPacketReason(NTM.id("has_geiger_counter"), player -> PlayerUtil.hasItem(player, NTMItems.GEIGER_COUNTER));
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
    ServerPlayNetworking.send(player, new RadiationInformationPayload(new RadiationInformationPayload.RadiationInfo(
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
    NbtCompound entityData = CustomDataHolder.from(entity).NTM$getCustomData();
    return entityData.getDouble("radiation_exposure", 0.0);
  }
  public void setRadiationExposure(LivingEntity entity, double radiation){
    NbtCompound entityData = CustomDataHolder.from(entity).NTM$getCustomData();
    entityData.putDouble("radiation_exposure", radiation);
  }

  public double getRadiationResistance(LivingEntity entity){
    double resistance = hazmatRegistry.getResistance(entity);
    if(entity.hasStatusEffect(NTMStatusEffects.RAD_X)){
      resistance += 0.2;
    }
    if(entity.hasStatusEffect(NTMStatusEffects.TAINTED_HEART)){
      // Gives 100% resistance to all radiation
      resistance += 1000;
    }
    return resistance;
  }
  public double getRadiationResistancePercentage(LivingEntity entity){
    return 100 - (getRadiationModifier(entity) * 100);
  }
  public double getRadiationModifier(LivingEntity entity){
    return Math.pow(10.0, -getRadiationResistance(entity));
  }

  // All Radiation values are in RAD/s not RAD/t so don't forget to divide by 20 when applying radiation per tick!
  public double getInventoryRadiation(LivingEntity entity){
    if(entity instanceof InventoryOwner inventoryOwner){
      return radiationRegistry.getRadioactivity(inventoryOwner.getInventory());
    }
    if(entity instanceof PlayerEntity player){
      return radiationRegistry.getRadioactivity(player.getInventory());
    }
    return 0;
  }
  public double getActiveChunkRadiation(ServerWorld world, Vec3d pos){
    if(world == null || pos == null) return 0;
    return getRadiationProcessor(world, pos).getActiveRadiation(pos);
  }
  public double getPassiveChunkRadiation(ServerWorld world, Vec3d pos){
    if(world == null || pos == null) return 0;
    return getRadiationProcessor(world, pos).getPassiveRadiation(pos);
  }
  public double getChunkRadiation(ServerWorld world, Vec3d pos){
    if(world == null || pos == null) return 0;
    return getActiveChunkRadiation(world, pos) + getPassiveChunkRadiation(world, pos);
  }
  public double getTotalRadiation(LivingEntity entity){
    if(entity == null || entity.getWorld() == null || entity.getPos() == null) return 0;
    if(entity.getWorld() instanceof ServerWorld serverWorld){
      return this.getChunkRadiation(serverWorld, entity.getPos()) + getInventoryRadiation(entity);
    }
    return 0;
  }

  public RadiationProcessor getRadiationProcessor(ServerWorld world, Vec3d pos){
    return getRadiationProcessor(world, WorldUtil.getChunkPos(pos));
  }
  public RadiationProcessor getRadiationProcessor(ServerWorld world, Vec3i pos){
    return getRadiationProcessor(world, WorldUtil.getChunkPos(pos));
  }
  public RadiationProcessor getRadiationProcessor(ServerWorld world, ChunkPos pos){
    RadiationProcessor radiationProcessor = RadiationProcessorMultiHolder.from(world).NTM$getRadiationProcessor(pos);
    if(radiationProcessor == null){
      radiationProcessor = new EmptyRadiationProcessor();
    }
    return radiationProcessor;
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
      EntityUtil.applyDamage(entity, serverWorld, NTMDamageTypes.RADIATION, Float.MAX_VALUE);
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
    if(!(entity.getWorld() instanceof ServerWorld serverWorld)) return;
    increaseRadiationExposure(entity, getTotalRadiation(entity) * getRadiationModifier(entity) / 20.0);

    Random random = serverWorld.getRandom();
    double radiationExposure = getRadiationExposure(entity);

    // Special Entity events
    switch (entity){
      case CowEntity cow -> {
        if(radiationExposure >= 50){
          EntityType.MOOSHROOM.spawn(serverWorld, cow.getBlockPos(), SpawnReason.EVENT);
          cow.setRemoved(Entity.RemovalReason.KILLED);
        }
      }
      case CreeperEntity creeper -> {
        if(radiationExposure >= 200){
          /* TODO: Nuclear Creeper
           if(random.nextInt(3) == 0){
             ModEntityType.NUCLEAR_CREEPER.spawn(serverWorld, creeper.getBlockPos(), SpawnReason.EVENT);
           }
          */
          creeper.setRemoved(Entity.RemovalReason.KILLED);
        }
      }
      /* TODO: duck & Quackos
      case DuckEntity duck -> {
        if(radiationExposure >= 200){
          ModEntityType.QUACKOS.spawn(serverWorld, duck.getBlockPos(), SpawnReason.EVENT);
          duck.setRemoved(Entity.RemovalReason.KILLED);
        }
      }
       */
      case VillagerEntity villager -> {
        if(radiationExposure >= 500){
          EntityType.ZOMBIE.spawn(serverWorld, villager.getBlockPos(), SpawnReason.EVENT);
          villager.setRemoved(Entity.RemovalReason.KILLED);
        }
      }
      default -> {}
    }

    // Regular Radiation Effects
    if(radiationExposure >= 1_000_000){
      EntityUtil.applyDamage(entity, serverWorld, NTMDamageTypes.RADIATION, Float.MAX_VALUE);
      setRadiationExposure(entity, 0);
      return;
    }
    if(radiationExposure >= 800_000){
      if(random.nextInt(1000) == 0){
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20 * 5, 0, false, false ,true));
      }
      if(random.nextInt(1000) == 0) {
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 20 * 5, 2, false, false, true));
      }
      if(random.nextInt(1000) == 0) {
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 5, 2, false, false, true));
      }
      if(random.nextInt(2500) == 0) {
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 20 * 5, 2, false, false, true));
      }
      if(random.nextInt(5000) == 0) {
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 20 * 5, 1, false, false, true));
      }
      return;
    }
    if(radiationExposure >= 600_000){
      if(random.nextInt(1000) == 0){
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20 * 5, 0, false, false ,true));
      }
      if(random.nextInt(1000) == 0) {
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 20 * 5, 2, false, false, true));
      }
      if(random.nextInt(1000) == 0) {
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 5, 2, false, false, true));
      }
      if(random.nextInt(15000) == 0) {
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 20 * 5, 1, false, false, true));
      }
      return;
    }
    if(radiationExposure >= 400_000){
      if(random.nextInt(1000) == 0){
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20 * 5, 0, false, false ,true));
      }
      if(random.nextInt(1000) == 0) {
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 20 * 5, 1, false, false, true));
      }
      if(random.nextInt(1000) == 0) {
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 5, 1, false, false, true));
      }
      return;
    }
    if(radiationExposure >= 200_000){
      if(random.nextInt(1000) == 0){
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20 * 5, 0, false, false ,true));
      }
      if(random.nextInt(1000) == 0) {
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 20 * 5, 0, false, false, true));
      }
    }
  }

  public RadiationProcessor makeNewRadiationProcessor(ServerWorld world, ChunkPos pos){
    if(NTMConfig.DisableChunkRadiation.getValue()){
      return new EmptyRadiationProcessor();
    }
    return new SimpleRadiationProcessor(world, pos);
  }
}
