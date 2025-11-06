package net.fawnoculus.ntm.util;

import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

public class TextUtil {
	public static MutableText unit(long val) {
		if (val >= 1_000_000_000_000_000_000L) {
			return Text.translatable("generic.ntm.unit.e", String.format("%.1f", val / 1_000_000_000_000_000_000.0));
		}
		if (val >= 1_000_000_000_000_000L) {
			return Text.translatable("generic.ntm.unit.p", String.format("%.1f", val / 1_000_000_000_000_000.0));
		}
		if (val >= 1_000_000_000_000L) {
			return Text.translatable("generic.ntm.unit.t", String.format("%.1f", val / 1_000_000_000_000.0));
		}
		if (val >= 1_000_000_000L) {
			return Text.translatable("generic.ntm.unit.g", String.format("%.1f", val / 1_000_000_000.0));
		}
		if (val >= 1_000_000L) {
			return Text.translatable("generic.ntm.unit.m", String.format("%.1f", val / 1_000_000.0));
		}
		if (val >= 1_000L) {
			return Text.translatable("generic.ntm.unit.k", String.format("%.1f", val / 1_000.0));
		}
		if (val >= -1_000L) {
			return Text.literal(String.valueOf(val));
		}
		if (val >= -1_000_000L) {
			return Text.translatable("generic.ntm.unit.k", String.format("%.1f", val / 1_000.0));
		}
		if (val >= -1_000_000_000L) {
			return Text.translatable("generic.ntm.unit.m", String.format("%.1f", val / 1_000_000.0));
		}
		if (val >= -1_000_000_000_000L) {
			return Text.translatable("generic.ntm.unit.g", String.format("%.1f", val / 1_000_000_000.0));
		}
		if (val >= -1_000_000_000_000_000L) {
			return Text.translatable("generic.ntm.unit.t", String.format("%.1f", val / 1_000_000_000_000.0));
		}
		return Text.translatable("generic.ntm.unit.p", String.format("%.1f", val / 1_000_000_000_000_000.0));
	}

	public static MutableText unit(long val, String suffixKey) {
		return unit(val).append(Text.translatable(suffixKey));
	}

	public static MutableText unit(double val) {
		if (val >= 1_000_000_000_000_000_000L) {
			return Text.translatable("generic.ntm.unit.e", String.format("%.1f", val / 1_000_000_000_000_000_000.0));
		}
		if (val >= 1_000_000_000_000_000L) {
			return Text.translatable("generic.ntm.unit.p", String.format("%.1f", val / 1_000_000_000_000_000.0));
		}
		if (val >= 1_000_000_000_000L) {
			return Text.translatable("generic.ntm.unit.t", String.format("%.1f", val / 1_000_000_000_000.0));
		}
		if (val >= 1_000_000_000L) {
			return Text.translatable("generic.ntm.unit.g", String.format("%.1f", val / 1_000_000_000.0));
		}
		if (val >= 1_000_000L) {
			return Text.translatable("generic.ntm.unit.m", String.format("%.1f", val / 1_000_000.0));
		}
		if (val >= 1_000L) {
			return Text.translatable("generic.ntm.unit.k", String.format("%.1f", val / 1_000.0));
		}
		if (val >= -1_000L) {
			return Text.literal(String.valueOf(val));
		}
		if (val >= -1_000_000L) {
			return Text.translatable("generic.ntm.unit.k", String.format("%.1f", val / 1_000.0));
		}
		if (val >= -1_000_000_000L) {
			return Text.translatable("generic.ntm.unit.m", String.format("%.1f", val / 1_000_000.0));
		}
		if (val >= -1_000_000_000_000L) {
			return Text.translatable("generic.ntm.unit.g", String.format("%.1f", val / 1_000_000_000.0));
		}
		if (val >= -1_000_000_000_000_000L) {
			return Text.translatable("generic.ntm.unit.t", String.format("%.1f", val / 1_000_000_000_000.0));
		}
		return Text.translatable("generic.ntm.unit.p", String.format("%.1f", val / 1_000_000_000_000_000.0));
	}

	public static MutableText unit(double val, String suffixKey) {
		return unit(val).append(Text.translatable(suffixKey));
	}
}
