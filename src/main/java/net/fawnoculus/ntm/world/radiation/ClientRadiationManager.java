package net.fawnoculus.ntm.world.radiation;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fawnoculus.ntm.network.custom.RadiationInformationS2CPayload;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Range;

import java.util.function.Function;

/**
 * The Client Radiation Manager is mosty responsible for getting Information like:
 * <br>- Current Chunk Radiation
 * <br>- Total Environmental Radiation
 * <br>- Player Radiation Exposure
 * <br>- etc.
 * <br>So that Items like the Geiger Counter can display them to the Player
 * <br>It is not responsible for Handling anything Else, Everything else is done in the {@link ServerRadiationManager ServerRadiationManager}
 * <br>The Server Radiation Manager will only send Radiation Info to the Client Radiation Manager if one of the {@link ServerRadiationManager#addPacketReason(Identifier, Function)  Added Packed Reasons} returns true or the {@link net.fawnoculus.ntm.main.NTMConfig#AlwaysSendRadiationPacket Option for it} is enabled
 */
@Environment(EnvType.CLIENT)
public class ClientRadiationManager {
  private static ClientRadiationManager INSTANCE;
  
  public static void initialize(){
    ClientRadiationManager.INSTANCE = new ClientRadiationManager();
  }
  
  public static ClientRadiationManager getInstance(){
    return ClientRadiationManager.INSTANCE;
  }
  
  public boolean displayGeigerCounter = true;
  public @Range(from = 0, to = 1000000) double radiationExposure = 0;
  public double inventoryRadiation = 0;
  public double activeChunkRadiation = 0;
  public double passiveChunkRadiation = 0;
  public double totalChunkRadiation = 0;
  public double totalRadiation = 0;
  
  public void handlePacked(RadiationInformationS2CPayload payload){
    RadiationInformationS2CPayload.RadiationInfo info = payload.info();
    this.radiationExposure = info.radiationExposure();
    this.inventoryRadiation = info.inventoryRadiation();
    this.activeChunkRadiation = info.activeChunkRadiation();
    this.passiveChunkRadiation = info.passiveChunkRadiation();
    this.totalChunkRadiation = this.activeChunkRadiation + this.passiveChunkRadiation;
    this.totalRadiation = this.inventoryRadiation + this.totalChunkRadiation;
  }
  
}
