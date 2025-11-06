package net.fawnoculus.ntm.api.radiation;

import com.google.gson.JsonObject;
import io.netty.buffer.ByteBuf;
import net.fabricmc.loader.api.FabricLoader;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.util.ExceptionUtil;
import net.fawnoculus.ntm.util.JsonUtil;
import net.minecraft.block.Block;
import net.minecraft.entity.EquipmentHolder;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class HazmatRegistry {
	public static void initialize() {
		loadOverrides();
	}

	private static final HashMap<Identifier, Double> hazmatGetter = new HashMap<>();
	private static final HashMap<Identifier, Double> hazmatOverrides = new HashMap<>();


	private static void loadOverrides() {
		File file = FabricLoader.getInstance().getConfigDir().resolve("ntm/overrides/hazmat.json").toFile();
		if (!file.exists()) {
			try {
				boolean ignored = file.getParentFile().mkdirs();
				boolean newFile = file.createNewFile();
				if (newFile) {
					NTM.LOGGER.info("Created Hazmat Overrides File");
					try (FileWriter fileWriter = new FileWriter(file)) {
						fileWriter.write("{\n");
						fileWriter.write("\t\"mod_id:id_of_equipable_item\": 0,\n");
						fileWriter.write("\t\"example:now_gives_radiation_resistance\": 0.5,\n");
						fileWriter.write("\t\"example:no_longer_radiation_resistance_giving\": 0\n");
						fileWriter.write("}");
					} catch (Exception e) {
						NTM.LOGGER.error("An Exception occurred while trying write Examples to Hazmat Overrides File\nException:{}", ExceptionUtil.makePretty(e));
					}
				} else {
					NTM.LOGGER.warn("Failed to crate Hazmat Overrides File");
				}
			} catch (Exception e) {
				NTM.LOGGER.error("An Exception occurred while trying to crate Hazmat Overrides File\nException:{}", ExceptionUtil.makePretty(e));
			}
			return;
		}
		JsonObject overrides = new JsonObject();
		try {
			FileReader fileReader = new FileReader(file);
			overrides = JsonUtil.jsonFromReader(fileReader);
		} catch (Exception e) {
			NTM.LOGGER.error("An Exception occurred while trying read Hazmat Overrides File\nException:{}", ExceptionUtil.makePretty(e));
		}

		for (String key : overrides.keySet()) {
			try {
				Identifier identifier = Identifier.of(key);
				Double value = overrides.get(key).getAsDouble();
				hazmatOverrides.put(identifier, value);
			} catch (Exception e) {
				NTM.LOGGER.error("An Exception occurred while trying parse Hazmat Overrides for {}\nException:{}", key, ExceptionUtil.makePretty(e));
			}
		}

		NTM.LOGGER.info("Successfully loaded Hazmat Overrides for {} identifier(s)", hazmatOverrides.size());
	}

	public static double getResistance(LivingEntity entity) {
		double resistance = 0;
		if (entity instanceof EquipmentHolder equipmentHolder) {
			try {
				resistance += getResistance(equipmentHolder.getEquippedStack(EquipmentSlot.HEAD));
			} catch (Throwable ignored) {
			}
			try {
				resistance += getResistance(equipmentHolder.getEquippedStack(EquipmentSlot.CHEST));
			} catch (Throwable ignored) {
			}
			try {
				resistance += getResistance(equipmentHolder.getEquippedStack(EquipmentSlot.LEGS));
			} catch (Throwable ignored) {
			}
			try {
				resistance += getResistance(equipmentHolder.getEquippedStack(EquipmentSlot.FEET));
			} catch (Throwable ignored) {
			}
			try {
				resistance += getResistance(equipmentHolder.getEquippedStack(EquipmentSlot.BODY));
			} catch (Throwable ignored) {
			}
			try {
				resistance += getResistance(equipmentHolder.getEquippedStack(EquipmentSlot.SADDLE));
			} catch (Throwable ignored) {
			}
		}
		return resistance;
	}

	public static double getResistance(ItemStack stack) {
		return getResistance(stack.getItem()) * stack.getCount();
	}

	public static double getResistance(Item item) {
		return getResistance(Registries.ITEM.getId(item));
	}

	public static double getResistance(Identifier identifier) {
		Double override = hazmatOverrides.get(identifier);
		if (override != null) {
			return override;
		}
		return hazmatGetter.getOrDefault(identifier, 0.0);
	}

	public static void register(Block block, double resistance) {
		register(Registries.BLOCK.getId(block), resistance);
	}

	public static void register(Item item, double resistance) {
		register(Registries.ITEM.getId(item), resistance);
	}

	public static void register(Identifier identifier, double resistance) {
		if (resistance <= 0) {
			hazmatGetter.remove(identifier);
		} else {
			hazmatGetter.put(identifier, resistance);
		}
	}

	public static HazmatRegistry.Serialized serialize() {
		return new HazmatRegistry.Serialized(hazmatGetter, hazmatOverrides);
	}

	public record Serialized(HashMap<Identifier, Double> hazmatGetter, HashMap<Identifier, Double> hazmatOverrides) {
		public static final PacketCodec<ByteBuf, Serialized> PACKET_CODEC = new PacketCodec<>() {
			@Override
			public Serialized decode(ByteBuf byteBuf) {
				NbtCompound nbt = PacketByteBuf.readNbt(byteBuf);
				if (nbt == null) nbt = new NbtCompound();
				return Serialized.decode(nbt);
			}

			@Override
			public void encode(ByteBuf byteBuf, Serialized registry) {
				PacketByteBuf.writeNbt(byteBuf, Serialized.encode(registry));
			}
		};

		public static NbtCompound encode(HazmatRegistry.Serialized registry) {
			NbtCompound hazmatGetter = new NbtCompound();
			for (Identifier key : registry.hazmatGetter().keySet()) {
				Double value = registry.hazmatGetter().get(key);
				hazmatGetter.putDouble(key.toString(), value);
			}

			NbtCompound radioactivityOverrides = new NbtCompound();
			for (Identifier key : registry.hazmatOverrides().keySet()) {
				Double value = registry.hazmatOverrides().get(key);
				radioactivityOverrides.putDouble(key.toString(), value);
			}

			NbtCompound nbt = new NbtCompound();
			nbt.put("hazmatGetter", hazmatGetter);
			nbt.put("hazmatOverrides", radioactivityOverrides);
			return nbt;
		}

		public static HazmatRegistry.Serialized decode(NbtCompound json) {
			NbtCompound jsonHazmatGetter = json.getCompoundOrEmpty("hazmatGetter");
			NbtCompound jsonHazmatOverrides = json.getCompoundOrEmpty("hazmatOverrides");

			HashMap<Identifier, Double> hazmatGetter = new HashMap<>();
			for (String key : jsonHazmatGetter.getKeys()) {
				Identifier identifier = Identifier.of(key);
				double value = jsonHazmatGetter.getDouble(key, 0);
				if (value == 0) continue;
				hazmatGetter.put(identifier, value);
			}

			HashMap<Identifier, Double> hazmatOverrides = new HashMap<>();
			for (String key : jsonHazmatOverrides.getKeys()) {
				Identifier identifier = Identifier.of(key);
				double value = jsonHazmatOverrides.getDouble(key, 0);
				hazmatOverrides.put(identifier, value);
			}

			return new HazmatRegistry.Serialized(hazmatGetter, hazmatOverrides);
		}
	}
}
