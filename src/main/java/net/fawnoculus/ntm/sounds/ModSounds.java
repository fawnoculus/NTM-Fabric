package net.fawnoculus.ntm.sounds;

import net.fawnoculus.ntm.main.NTM;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
  public static final SoundEvent SYRINGE_INJECTS = register("item.syringe_injects");
  public static final SoundEvent RADAWAY_INJECTS = register("item.radaway_injects");
  
  
  private static SoundEvent register(String id){
    Identifier identifier = NTM.id(id);
    return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
  }
  
  public static void initialize(){}
}
