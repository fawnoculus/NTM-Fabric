package net.fawnoculus.ntm.misc.radiation;

import net.minecraft.util.Identifier;

import java.util.HashMap;

public class ClientHazmatRegistry extends HazmatRegistry {
  private static final ClientHazmatRegistry INSTANCE = new ClientHazmatRegistry();
  
  public static ClientHazmatRegistry getInstance(){
    return INSTANCE;
  }
  
  private HashMap<Identifier, Double> hazmatGetter = new HashMap<>();
  private HashMap<Identifier, Double> hazmatOverrides = new HashMap<>();
  
  @Override
  public double getResistance(Identifier identifier) {
    Double override = hazmatOverrides.get(identifier);
    if(override != null){
      return override;
    }
    return hazmatGetter.getOrDefault(identifier, 0.0);
  }
  
  @Override
  public void register(Identifier identifier, double milliRads) {
    throw new IllegalArgumentException("Tried to register radiation resistance in ClientHazmatRegistry");
  }
  
  public void updateFromPacket(HazmatRegistry.Serialized serializedRegistry){
    this.hazmatGetter = serializedRegistry.hazmatGetter();
    this.hazmatOverrides = serializedRegistry.hazmatOverrides();
  }
}
