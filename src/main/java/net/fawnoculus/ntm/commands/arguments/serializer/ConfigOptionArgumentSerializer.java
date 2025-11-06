package net.fawnoculus.ntm.commands.arguments.serializer;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.fawnoculus.ntm.api.config.ConfigFile;
import net.fawnoculus.ntm.commands.arguments.ConfigOptionArgumentType;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.command.argument.serialize.ArgumentSerializer;
import net.minecraft.network.PacketByteBuf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class ConfigOptionArgumentSerializer implements ArgumentSerializer<ConfigOptionArgumentType, ConfigOptionArgumentSerializer.ConfigOptionArgumentProperties> {
	private static final String ENDING = "THIS IS THE FUCKING END";

	@Override
	public void writePacket(ConfigOptionArgumentProperties properties, PacketByteBuf buf) {
		buf.writeString(properties.CONFIG_SUB_PATH);
		for (String optionName : properties.OPTION_NAMES) {
			buf.writeString(optionName);
		}
		buf.writeString(ENDING);
	}

	@Override
	public ConfigOptionArgumentProperties fromPacket(PacketByteBuf buf) {
		String configFileSubPath = buf.readString();
		List<String> optionNames = new ArrayList<>();
		String optionName = buf.readString();
		while (!optionName.equals(ENDING)) {
			optionNames.add(optionName);
			optionName = buf.readString();
		}

		return new ConfigOptionArgumentProperties(configFileSubPath, optionNames);
	}

	@Override
	public void writeJson(ConfigOptionArgumentProperties properties, JsonObject json) {
		json.addProperty("sub_path", properties.CONFIG_SUB_PATH);
		JsonArray optionNames = new JsonArray();
		for (String optionName : properties.OPTION_NAMES) {
			optionNames.add(optionName);
		}
		json.add("option_names", optionNames);
	}

	@Override
	public ConfigOptionArgumentProperties getArgumentTypeProperties(ConfigOptionArgumentType argumentType) {
		return new ConfigOptionArgumentProperties(argumentType.configFile().get());
	}

	public final class ConfigOptionArgumentProperties implements ArgumentSerializer.ArgumentTypeProperties<ConfigOptionArgumentType> {
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
		public ConfigOptionArgumentType createType(CommandRegistryAccess commandRegistryAccess) {
			HashSet<String> optionNames = new HashSet<>(this.OPTION_NAMES);

			return new ConfigOptionArgumentType(() -> ConfigFile.getFile(this.CONFIG_SUB_PATH), () -> optionNames);
		}

		@Override
		public ArgumentSerializer<ConfigOptionArgumentType, ?> getSerializer() {
			return ConfigOptionArgumentSerializer.this;
		}
	}
}
