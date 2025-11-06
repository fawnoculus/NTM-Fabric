package net.fawnoculus.ntm.api.config;

import com.mojang.serialization.Codec;
import net.fabricmc.loader.api.FabricLoader;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.util.ExceptionUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ConfigFile {
	private static final HashMap<String, ConfigFile> CONFIG_FILES = new HashMap<>();
	private final List<ConfigOption<?>> OPTIONS = new ArrayList<>();
	private final HashMap<String, ConfigOption<?>> OPTIONS_FROM_NAME = new HashMap<>();
	private final String SUB_PATH;
	private final ConfigEncoding ENCODING;
	private final Path PATH;


	public ConfigFile(ConfigEncoding encoding, String subPath) {
		this.ENCODING = encoding;
		this.SUB_PATH = subPath;
		this.PATH = FabricLoader.getInstance().getConfigDir().resolve(subPath);

		CONFIG_FILES.put(subPath, this);
	}

	public ConfigFile(ConfigEncoding encoding, Path path, String subPath) {
		this.ENCODING = encoding;
		this.SUB_PATH = subPath;
		this.PATH = path;

		CONFIG_FILES.put(subPath, this);
	}

	public static ConfigFile getFile(String subPath) {
		return CONFIG_FILES.get(subPath);
	}

	public void initialize() {
		if (this.PATH.toFile().exists()) {
			this.readFile();
		}
		this.writeFile();
	}

	public void readFile() {
		try {
			this.ENCODING.readPath(this.PATH, this);
		} catch (Exception e) {
			NTM.LOGGER.warn("Failed to read config file '{}'\nException: {}", this.PATH, ExceptionUtil.makePretty(e));
		}
	}

	public void writeFile() {
		try {
			if (this.PATH.toFile().exists()) {
				boolean ignored = this.PATH.toFile().delete();
			} else {
				boolean ignored = this.PATH.getParent().toFile().mkdirs();
			}
			this.ENCODING.writePath(this.PATH, this);
		} catch (Exception e) {
			NTM.LOGGER.warn("Failed to write config file '{}'\nException: {}", this.PATH, ExceptionUtil.makePretty(e));
		}
	}

	public List<ConfigOption<?>> getOptions() {
		return this.OPTIONS;
	}

	public Set<String> getOptionsNames() {
		return this.OPTIONS_FROM_NAME.keySet();
	}

	public ConfigOption<?> getOption(String name) {
		return this.OPTIONS_FROM_NAME.get(name);
	}

	public String getSubPath() {
		return this.SUB_PATH;
	}

	public void addOption(ConfigOption<?> option) {
		this.OPTIONS.add(option);
		this.OPTIONS_FROM_NAME.put(option.getName(), option);
	}

	public <T> ConfigOption<T> newOption(@NotNull String name, @NotNull Codec<T> codec, @NotNull T defaultValue) {
		return this.newOption(name, codec, defaultValue, null);
	}

	public <T> ConfigOption<T> newOption(@NotNull String name, @NotNull Codec<T> codec, @NotNull T defaultValue, @Nullable String comment) {
		ConfigOption<T> option = new ConfigOption<>(name, codec, defaultValue, comment);
		this.addOption(option);
		return option;
	}
}
