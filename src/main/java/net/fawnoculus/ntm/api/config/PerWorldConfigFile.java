package net.fawnoculus.ntm.api.config;

import com.mojang.serialization.Codec;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PerWorldConfigFile {
    private static final List<PerWorldConfigFile> PER_WORLD_CONFIG_FILES = new ArrayList<>();
    private final List<PerWorldConfigOption<?>> OPTIONS = new ArrayList<>();
    private final ConfigEncoding ENCODING;
    private final String WORLD_SUB_PATH;
    private final ConfigFile DEFAULT_CONFIG;
    private @Nullable ConfigFile WORLD_CONFIG;

    public PerWorldConfigFile(ConfigEncoding encoding, String defaultSubPath, String worldSubPath) {
        this.ENCODING = encoding;
        this.WORLD_SUB_PATH = worldSubPath;
        this.DEFAULT_CONFIG = new ConfigFile(encoding, defaultSubPath);

        PER_WORLD_CONFIG_FILES.add(this);
    }

    public static List<PerWorldConfigFile> getPerWorldConfigFiles() {
        return PER_WORLD_CONFIG_FILES;
    }

    public void setWorldPath(@NotNull Path worldSavePath) {
        this.WORLD_CONFIG = new ConfigFile(this.ENCODING, worldSavePath.resolve(this.WORLD_SUB_PATH), WORLD_SUB_PATH);
        for (PerWorldConfigOption<?> option : this.OPTIONS) {
            option.setWorldConfigFile(this.WORLD_CONFIG);
        }
        this.WORLD_CONFIG.initialize();
    }

    public void removeWorldPath() {
        if (this.WORLD_CONFIG != null) {
            this.WORLD_CONFIG.writeFile();
        }
        for (PerWorldConfigOption<?> option : this.OPTIONS) {
            option.unsetWorldConfigFile();
        }
        this.WORLD_CONFIG = null;
    }

    public void initialize() {
        this.DEFAULT_CONFIG.initialize();
    }

    public ConfigFile defaultConfig() {
        return this.DEFAULT_CONFIG;
    }

    public ConfigFile worldConfig() {
        return this.WORLD_CONFIG;
    }

    public <T> PerWorldConfigOption<T> newOption(String name, Codec<T> codec, T defaultValue) {
        return this.newOption(name, codec, defaultValue, null);
    }

    public <T> PerWorldConfigOption<T> newOption(String name, Codec<T> codec, T defaultValue, String comment) {
        PerWorldConfigOption<T> option = new PerWorldConfigOption<>(name, codec, this.DEFAULT_CONFIG.newOption(name, codec, defaultValue, comment), comment);
        this.OPTIONS.add(option);
        return option;
    }
}
