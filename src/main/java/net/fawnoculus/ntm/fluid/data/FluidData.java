package net.fawnoculus.ntm.fluid.data;

import net.minecraft.fluid.Fluids;

public class FluidData {
  public static void initialize(){
    // Syntax Example for Later
    // TODO: delete this once the actual data is here
    FluidDataRegistry.getOrCreate(Fluids.WATER)
      .set(FluidDataTypes.ANTIMATTER, true)
      .set(FluidDataTypes.TEMPERATURE, 20.0);
  }
}
