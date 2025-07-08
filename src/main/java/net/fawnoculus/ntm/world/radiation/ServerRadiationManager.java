package net.fawnoculus.ntm.world.radiation;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fawnoculus.ntm.items.ModItems;
import net.fawnoculus.ntm.main.NTM;
import net.fawnoculus.ntm.main.NTMConfig;
import net.fawnoculus.ntm.network.custom.RadiationInformationS2CPayload;
import net.fawnoculus.ntm.util.PlayerUtil;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;

import java.util.Collection;
import java.util.HashMap;
import java.util.function.Function;

/**
 * The Server Radiation Manager is run on the Logical Server (So it also Runs on Singleplayer Worlds).
 * <br>It Handles the active Radiation in All Loaded Chunks, Giving Players the effects for Radiation Exposure &
 * Send Update Packets to the Players that should Receive Radiation Information so that the {@link ClientRadiationManager ClientRadiationManager} can give it to the Player
 */
public class ServerRadiationManager {
  private static ServerRadiationManager INSTANCE;
  
  public static void initialize(){
    INSTANCE = new ServerRadiationManager();
    INSTANCE.addPacketReason(NTM.id("has_geiger_counter"), player -> PlayerUtil.hasItem(player, ModItems.GEIGER_COUNTER));
  }
  
  public static ServerRadiationManager getInstance(){
    return INSTANCE;
  }
  
  private final HashMap<Identifier,Function<ServerPlayerEntity, Boolean>> packetReasons = new HashMap<>();
  
  public void addPacketReason(Identifier identifier, Function<ServerPlayerEntity, Boolean> reason){
    this.packetReasons.put(identifier, reason);
  }
  public void removePacketReason(Identifier identifier){
    this.packetReasons.remove(identifier);
  }
  
  public void sendPacket(ServerPlayerEntity player){
    // TODO: this
    ServerPlayNetworking.send(player, new RadiationInformationS2CPayload(new RadiationInformationS2CPayload.RadiationInfo(
        1, 1, 1, 1
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
  
  public void tick(ServerWorld world){
    this.sendPacketIfNeeded(world.getPlayers());
    // TODO: this
  }
}
