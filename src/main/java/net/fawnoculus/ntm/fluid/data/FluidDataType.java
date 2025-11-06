package net.fawnoculus.ntm.fluid.data;

import com.mojang.serialization.Codec;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public record FluidDataType<T>(
  @NotNull Identifier identifier,
  @NotNull Codec<T> codec,
  @Nullable T defaultValue,
  @Nullable TooltipProvider<T> tooltip,
  boolean hasExtraInfo
) {
	public void encode(@NotNull NbtCompound nbt, @Nullable T value) {
		if (value != null) {
			nbt.put(this.identifier.toString(), this.codec, value);
		}
	}

	public T decode(@NotNull NbtCompound nbt) {
		return nbt.get(this.identifier.toString(), this.codec).orElse(this.defaultValue);
	}

	public void appendTooltip(T value, boolean showExtraInfo, Consumer<Text> tooltip) {
		if (this.tooltip != null) {
			this.tooltip.appendTooltip(value, showExtraInfo, tooltip);
		}
	}

	public FluidDataType<T> register() {
		FluidDataRegistry.registerDataType(this);
		return this;
	}

	@FunctionalInterface
	public interface TooltipProvider<T> {
		void appendTooltip(T value, boolean showExtraInfo, Consumer<Text> tooltip);
	}
}
