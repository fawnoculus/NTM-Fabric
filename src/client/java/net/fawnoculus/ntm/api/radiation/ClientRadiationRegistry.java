package net.fawnoculus.ntm.api.radiation;

import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class ClientRadiationRegistry extends RadiationRegistry {
  private static final ClientRadiationRegistry INSTANCE = new ClientRadiationRegistry();

  public static ClientRadiationRegistry getInstance(){
    return INSTANCE;
  }

  private HashMap<Identifier, Double> radioactivityGetter = new HashMap<>();
  private HashMap<Identifier, Double> radioactivityOverrides = new HashMap<>();

  @Override
  public double getRadioactivity(Identifier identifier){
    Double override = radioactivityOverrides.get(identifier);
    if(override != null){
      return override;
    }
    return radioactivityGetter.getOrDefault(identifier, 0.0);
  }

  @Override
  public void register(Identifier identifier, double radioactivity) {
    throw new RuntimeException("Tried to register radioactivity in ClientRadiationRegistry");
  }

  public void updateFromPacket(@NotNull Serialized serializedRegistry){
    this.radioactivityGetter = serializedRegistry.radioactivityGetter();
    this.radioactivityOverrides = serializedRegistry.radioactivityOverrides();
  }
}
