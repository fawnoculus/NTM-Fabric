package net.fawnoculus.ntm.misc.tags;

import net.fawnoculus.ntm.NTM;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class NTMFluidTags {

    private static TagKey<Fluid> of(String name) {
        return of(NTM.id(name));
    }

    private static TagKey<Fluid> of(Identifier identifier) {
        return TagKey.of(RegistryKeys.FLUID, identifier);
    }
}
