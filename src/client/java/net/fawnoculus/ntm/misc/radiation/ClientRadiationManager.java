package net.fawnoculus.ntm.misc.radiation;

import net.fawnoculus.ntm.NTMConfig;
import net.fawnoculus.ntm.network.s2c.RadiationInformationPayload;
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
 * <br>It is not responsible for Handling anything Else, Everything else is done in the {@link RadiationManager RadiationManager}
 * <br>The Server Radiation Manager will only send Radiation Info to the Client Radiation Manager if one of the {@link RadiationManager#addPacketReason(Identifier, Function)  Added Packed Reasons} returns true or the {@link NTMConfig#AlwaysSendRadiationPacket Option for it} is enabled
 */
public class ClientRadiationManager {
  private static final ClientRadiationManager INSTANCE = new ClientRadiationManager();

  public static ClientRadiationManager getInstance(){
    return ClientRadiationManager.INSTANCE;
  }

  public @Range(from = 0, to = 1000000) double radiationExposure = 0;
  public double inventoryRadiation = 0;
  public double activeChunkRadiation = 0;
  public double passiveChunkRadiation = 0;
  public double totalChunkRadiation = 0;
  public double totalRadiation = 0;

  public void handlePacked(RadiationInformationPayload payload){
    RadiationInformationPayload.RadiationInfo info = payload.info();
    this.radiationExposure = info.radiationExposure();
    this.inventoryRadiation = info.inventoryRadiation();
    this.activeChunkRadiation = info.activeChunkRadiation();
    this.passiveChunkRadiation = info.passiveChunkRadiation();
    this.totalChunkRadiation = this.activeChunkRadiation + this.passiveChunkRadiation;
    this.totalRadiation = this.inventoryRadiation + this.totalChunkRadiation;
  }

}
