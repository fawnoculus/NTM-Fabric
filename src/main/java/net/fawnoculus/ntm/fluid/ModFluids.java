package net.fawnoculus.ntm.fluid;

import net.fawnoculus.ntm.main.NTM;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModFluids {
  
  
  private static FlowableFluid register(String name, FlowableFluid fluid){
    return Registry.register(Registries.FLUID, NTM.id(name), fluid);
  }
  
  public static void initialize(){}
}
