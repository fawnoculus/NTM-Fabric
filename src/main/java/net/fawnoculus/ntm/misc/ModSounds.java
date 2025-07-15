package net.fawnoculus.ntm.misc;

import net.fawnoculus.ntm.NTM;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
  public static final SoundEvent SYRINGE_INJECTS = register("item.syringe_injects");
  public static final SoundEvent IV_BAG_INJECTS = register("item.iv_bag_injects");
  
  
  private static SoundEvent register(String id){
    Identifier identifier = NTM.id(id);
    return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
  }
  
  public static void initialize(){}
}
