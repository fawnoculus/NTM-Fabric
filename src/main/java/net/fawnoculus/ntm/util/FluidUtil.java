package net.fawnoculus.ntm.util;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;

public class FluidUtil {
  public static long convert(long amount, Unit from, Unit to){
    // Could get Inaccurate with huge amounts
    // Am to lazy to do smth about it tho
    return amount * from.DROPLETS / to.DROPLETS;
  }
  
  public enum Unit{
    BUCKET(FluidConstants.BUCKET),
    MILLI_BUCKET(FluidConstants.BUCKET / 1000),
    BOTTLE(FluidConstants.BOTTLE),
    BOWL(FluidConstants.BOWL),
    BLOCK(FluidConstants.BLOCK),
    INGOT(FluidConstants.INGOT),
    NUGGET(FluidConstants.NUGGET),
    DROPLET(FluidConstants.DROPLET);
    
    public final long DROPLETS;
    
    Unit(long droplets){
      this.DROPLETS = droplets;
    }
  }
  
  public static class FluidAmount{
    public FluidAmount(){
      this(0);
    }
    public FluidAmount(long droplets){
      this.droplets = droplets;
    }
    
    public long droplets;
    
    public void add(long amount, Unit unit){
      this.droplets += amount * unit.DROPLETS;
    }
    
    public void remove(long amount, Unit unit){
      this.droplets -= amount * unit.DROPLETS;
    }
    
    public double getAs(Unit unit){
      return (double) this.droplets * (double) unit.DROPLETS;
    }
  }
}
