package net.fawnoculus.ntm.fluid.data.custom;

import com.mojang.serialization.Codec;
import net.fawnoculus.ntm.misc.data.NTMCodecs;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public enum StateOfMatter {
    SOLID(Text.translatable("fluid_tooltip.ntm.state.solid").formatted(Formatting.BLUE)),
    LIQUID(Text.translatable("fluid_tooltip.ntm.state.liquid").formatted(Formatting.BLUE)),
    GASEOUS(Text.translatable("fluid_tooltip.ntm.state.gaseous").formatted(Formatting.BLUE)),
    PLASMA(Text.translatable("fluid_tooltip.ntm.state.plasma").formatted(Formatting.LIGHT_PURPLE));

    public static final Codec<StateOfMatter> CODEC = NTMCodecs.getEnumCodec(StateOfMatter.class);
    public final Text TOOLTIP;

    StateOfMatter(Text tooltip) {
        this.TOOLTIP = tooltip;
    }
}
