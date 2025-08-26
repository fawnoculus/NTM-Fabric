package net.fawnoculus.ntm.fluid;

import net.fawnoculus.ntm.fluid.data.FireDiamond;
import net.fawnoculus.ntm.fluid.data.FireDiamond.SpecialNotice;
import net.fawnoculus.ntm.fluid.data.FluidDataRegistry;
import net.fawnoculus.ntm.fluid.data.FluidDataTypes;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import org.jetbrains.annotations.Range;

public class FluidData {
  public static void initialize() {
    // Syntax Example for Later
    // TODO: delete this once the actual data is here
    fireDiamond(Fluids.WATER, 0, 0, 0)
      .set(FluidDataTypes.ANTIMATTER, true)
      .set(FluidDataTypes.TEMPERATURE, 20.0);

    fireDiamond(Fluids.LAVA, 0, 0, 0)
      .set(FluidDataTypes.BREATHABLE, true)
      .set(FluidDataTypes.DELICIOUS, true)
      .set(FluidDataTypes.GASEOUS_AT_ROOM_TEMPERATURE, false);

    FluidDataRegistry.getOrCreate(Fluids.EMPTY)
      .set(FluidDataTypes.TEMPERATURE, 0.0);
  }

  private static FluidDataRegistry.FluidDataContainer fireDiamond(Fluid fluid, @Range(from = 0, to = 4) Integer red, @Range(from = 0, to = 4) Integer blue, @Range(from = 0, to = 4) Integer yellow) {
    return fireDiamond(fluid, red, blue, yellow, SpecialNotice.NONE);
  }

  private static FluidDataRegistry.FluidDataContainer fireDiamond(Fluid fluid, @Range(from = 0, to = 4) Integer red, @Range(from = 0, to = 4) Integer blue, @Range(from = 0, to = 4) Integer yellow, SpecialNotice white) {
    return FluidDataRegistry.getOrCreate(fluid)
      .set(FireDiamond.RED, red)
      .set(FireDiamond.BLUE, blue)
      .set(FireDiamond.YELLOW, yellow)
      .set(FireDiamond.WHITE, white);
  }
}
