package net.fawnoculus.ntm.api.config;

import com.mojang.serialization.Codec;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PerWorldConfigOption<T> {
	private final @NotNull String NAME;
	private final @Nullable String COMMENT;
	private final @NotNull Codec<T> CODEC;
	private final @NotNull ConfigOption<T> DEFAULT;
	private @Nullable ConfigOption<T> PER_WORLD = null;

	public PerWorldConfigOption(@NotNull String name, @NotNull Codec<T> codec, @NotNull ConfigOption<T> defaultOption, @Nullable String comment) {
		this.NAME = name;
		this.COMMENT = comment;
		this.CODEC = codec;
		this.DEFAULT = defaultOption;
	}

	public void setWorldConfigFile(ConfigFile worldConfigFile) {
		this.PER_WORLD = worldConfigFile.newOption(this.NAME, this.CODEC, this.DEFAULT.getValue(), this.COMMENT);
	}

	public void unsetWorldConfigFile() {
		this.PER_WORLD = null;
	}

	public T getValue() {
		if (this.PER_WORLD != null) {
			return this.PER_WORLD.getValue();
		}
		return this.DEFAULT.getValue();
	}
}
