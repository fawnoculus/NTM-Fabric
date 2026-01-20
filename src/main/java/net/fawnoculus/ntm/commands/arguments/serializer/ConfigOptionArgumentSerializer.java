package net.fawnoculus.ntm.commands.arguments.serializer;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.fawnoculus.ntm.api.config.ConfigFile;
import net.fawnoculus.ntm.commands.arguments.ConfigOptionArgumentType;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.synchronization.ArgumentTypeInfo;
import net.minecraft.network.FriendlyByteBuf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class ConfigOptionArgumentSerializer implements ArgumentTypeInfo<ConfigOptionArgumentType, ConfigOptionArgumentSerializer.ConfigOptionArgumentProperties> {
    private static final String ENDING = "THIS IS THE FUCKING END";

    @Override
    public void serializeToNetwork(ConfigOptionArgumentProperties properties, FriendlyByteBuf buf) {
        buf.writeUtf(properties.CONFIG_SUB_PATH);
        for (String optionName : properties.OPTION_NAMES) {
            buf.writeUtf(optionName);
        }
        buf.writeUtf(ENDING);
    }

    @Override
    public ConfigOptionArgumentProperties deserializeFromNetwork(FriendlyByteBuf buf) {
        String configFileSubPath = buf.readUtf();
        List<String> optionNames = new ArrayList<>();
        String optionName = buf.readUtf();
        while (!optionName.equals(ENDING)) {
            optionNames.add(optionName);
            optionName = buf.readUtf();
        }

        return new ConfigOptionArgumentProperties(configFileSubPath, optionNames);
    }

    @Override
    public void serializeToJson(ConfigOptionArgumentProperties properties, JsonObject json) {
        json.addProperty("sub_path", properties.CONFIG_SUB_PATH);
        JsonArray optionNames = new JsonArray();
        for (String optionName : properties.OPTION_NAMES) {
            optionNames.add(optionName);
        }
        json.add("option_names", optionNames);
    }

    @Override
    public ConfigOptionArgumentProperties unpack(ConfigOptionArgumentType argumentType) {
        return new ConfigOptionArgumentProperties(argumentType.configFile().get());
    }

    public final class ConfigOptionArgumentProperties implements ArgumentTypeInfo.Template<ConfigOptionArgumentType> {
        private final String CONFIG_SUB_PATH;
        private final List<String> OPTION_NAMES;

        public ConfigOptionArgumentProperties(ConfigFile file) {
            this(file.getSubPath(), file.getOptionsNames());
        }

        public ConfigOptionArgumentProperties(String subPath, Collection<String> optionNames) {
            this.CONFIG_SUB_PATH = subPath;
            this.OPTION_NAMES = List.copyOf(optionNames);
        }

        @Override
        public ConfigOptionArgumentType instantiate(CommandBuildContext commandRegistryAccess) {
            HashSet<String> optionNames = new HashSet<>(this.OPTION_NAMES);

            return new ConfigOptionArgumentType(() -> ConfigFile.getFile(this.CONFIG_SUB_PATH), () -> optionNames);
        }

        @Override
        public ArgumentTypeInfo<ConfigOptionArgumentType, ?> type() {
            return ConfigOptionArgumentSerializer.this;
        }
    }
}
