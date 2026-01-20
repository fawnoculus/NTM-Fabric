package net.fawnoculus.ntm.misc;

import net.fawnoculus.ntm.NTM;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;

public class NTMSounds {
    public static final SoundEvent SYRINGE_INJECTS = register("item.syringe_injects");
    public static final SoundEvent IV_BAG_INJECTS = register("item.iv_bag_injects");
    public static final SoundEvent PAIN_SAW = register("item.pain_saw");
    public static final SoundEvent TECH_BOOP = register("item.tech_boop");
    public static final SoundEvent TECH_BEEP = register("item.tech_bleep");


    private static SoundEvent register(String id) {
        Identifier identifier = NTM.id(id);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, identifier, SoundEvent.createVariableRangeEvent(identifier));
    }

    public static void initialize() {
    }
}
