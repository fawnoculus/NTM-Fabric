package net.fawnoculus.ntm.fluid;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fawnoculus.ntm.NTMConfig;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

public enum FluidUnit {
    BUCKET(FluidConstants.BUCKET),
    MILLI_BUCKET(FluidConstants.BUCKET / 1000),
    BOTTLE(FluidConstants.BOTTLE),
    BOWL(FluidConstants.BOWL),
    BLOCK(FluidConstants.BLOCK),
    INGOT(FluidConstants.INGOT),
    NUGGET(FluidConstants.NUGGET),
    DROPLET(FluidConstants.DROPLET);

    public final long DROPLETS;

    FluidUnit(long droplets) {
        this.DROPLETS = droplets;
    }

    public static long convert(long amount, FluidUnit from, FluidUnit to) {
        // Could get Inaccurate with huge amounts
        // Am to lazy to do smth about it tho
        return amount * from.DROPLETS / to.DROPLETS;
    }

    public static long dropletsToMB(long droplets) {
        return droplets / MILLI_BUCKET.DROPLETS;
    }

    public static double dropletsToMB(double droplets) {
        return droplets / MILLI_BUCKET.DROPLETS;
    }

    public static long mbToDroplets(long droplets) {
        return droplets / MILLI_BUCKET.DROPLETS;
    }

    public static double mbToDroplets(double droplets) {
        return droplets / MILLI_BUCKET.DROPLETS;
    }

    public static MutableText text(long droplets) {
        if (NTMConfig.FLUID_UNIT.getValue() == NTMConfig.FluidUnit.Droplets) {
            return textDroplets(droplets);
        }
        return textMB(droplets);
    }

    public static MutableText textMB(long droplets) {
        return Text.translatable("generic.ntm.fluid.mb", String.format("%,d", droplets));
    }

    public static MutableText textDroplets(long droplets) {
        return Text.translatable("generic.ntm.fluid.droplets", String.format("%,d", droplets));
    }
}
