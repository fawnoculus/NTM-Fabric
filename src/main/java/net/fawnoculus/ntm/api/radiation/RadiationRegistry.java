package net.fawnoculus.ntm.api.radiation;

import com.google.gson.JsonObject;
import io.netty.buffer.ByteBuf;
import net.fabricmc.loader.api.FabricLoader;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.items.NTMItems;
import net.fawnoculus.ntm.util.ExceptionUtil;
import net.fawnoculus.ntm.util.JsonUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ContainerComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class RadiationRegistry {
  public static void initialize() {
    loadOverrides();
  }

  private static final HashMap<Identifier, Double> radioactivityGetter = new HashMap<>();
  private static final HashMap<Identifier, Double> radioactivityOverrides = new HashMap<>();

  public static void loadOverrides() {
    File file = FabricLoader.getInstance().getConfigDir().resolve("ntm/overrides/radiation.json").toFile();
    if (!file.exists()) {
      try {
        boolean ignored = file.getParentFile().mkdirs();
        boolean newFile = file.createNewFile();
        if (newFile) {
          NTM.LOGGER.info("Created Radiation Overrides File");
          try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write("{\n");
            fileWriter.write("\t\"mod_id:item_or_block_id\": 0,\n");
            fileWriter.write("\t\"example:not_radioactive_before\": 5,\n");
            fileWriter.write("\t\"example:no_longer_radioactive\": 0,\n");
            fileWriter.write("\t\"example:values_are_in_milli_rads\": 0,\n");
            fileWriter.write("\t\"example:this_is_one_rad_per_second\": 1000,\n");
            fileWriter.write("\t\"example:decimals_are_also_allowed\": 0.75,\n");
            fileWriter.write("\t\"example:these_overrides_are_for_items_blocks_and_dimensions\": 0\n");
            fileWriter.write("}");
          } catch (Exception e) {
            NTM.LOGGER.error("An Exception occurred while trying write Examples to Radiation Overrides File\nException:{}", ExceptionUtil.makePretty(e));
          }
        } else {
          NTM.LOGGER.warn("Failed to crate Radiation Overrides File");
        }
      } catch (Exception e) {
        NTM.LOGGER.error("An Exception occurred while trying to crate Radiation Overrides File\nException:{}", ExceptionUtil.makePretty(e));
      }
      return;
    }
    JsonObject overrides = new JsonObject();
    try {
      FileReader fileReader = new FileReader(file);
      overrides = JsonUtil.jsonFromReader(fileReader);
    } catch (Exception e) {
      NTM.LOGGER.error("An Exception occurred while trying read Radiation Overrides File\nException:{}", ExceptionUtil.makePretty(e));
    }

    for (String key : overrides.keySet()) {
      try {
        Identifier identifier = Identifier.of(key);
        Double value = overrides.get(key).getAsDouble();
        radioactivityOverrides.put(identifier, value);
      } catch (Exception e) {
        NTM.LOGGER.error("An Exception occurred while trying parse Radiation Overrides for {}\nException:{}", key, ExceptionUtil.makePretty(e));
      }
    }

    NTM.LOGGER.info("Successfully loaded Radioactivity Overrides for {} identifier(s)", radioactivityOverrides.size());
  }

  public static double getRadioactivity(Iterable<ItemStack> stacks) {
    double radioactivity = 0;
    boolean hasTungstenReacher = false;
    for (ItemStack stack : stacks) {
      radioactivity += getRadioactivity(stack);
      if (stack.getItem() == NTMItems.TUNGSTEN_REACHER) {
        hasTungstenReacher = true;
      }
      if (stack.contains(DataComponentTypes.CONTAINER)) {
        radioactivity += getRadioactivity(
          stack.getOrDefault(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT).stream().toList()
        );
      }
    }
    if (hasTungstenReacher) {
      radioactivity = Math.sqrt(radioactivity);
    }
    return radioactivity;
  }

  public static double getRadioactivity(World world) {
    try {
      return getRadioactivity(world.getRegistryManager().getOrThrow(RegistryKeys.DIMENSION_TYPE).getId(world.getDimension()));
    } catch (Throwable throwable) {
      return 0;
    }
  }

  public static double getRadioactivity(BlockState state) {
    return getRadioactivity(state.getBlock());
  }

  public static double getRadioactivity(Block block) {
    return getRadioactivity(Registries.BLOCK.getId(block));
  }

  public static double getRadioactivity(ItemStack stack) {
    return getRadioactivity(stack.getItem()) * stack.getCount();
  }

  public static double getRadioactivity(Item item) {
    return getRadioactivity(Registries.ITEM.getId(item));
  }

  public static double getRadioactivity(Identifier identifier) {
    Double override = radioactivityOverrides.get(identifier);
    if (override != null) {
      return override;
    }
    return radioactivityGetter.getOrDefault(identifier, 0.0);
  }

  public static void register(Block block, double milliRads) {
    register(Registries.BLOCK.getId(block), milliRads);
  }

  public static void register(Item item, double milliRads) {
    register(Registries.ITEM.getId(item), milliRads);
  }

  public static void register(Identifier identifier, double milliRads) {
    if(milliRads <= 0){
      radioactivityGetter.remove(identifier);
    }else {
      radioactivityGetter.put(identifier, milliRads);
    }
  }

  public static RadiationRegistry.Serialized serialize() {
    return new RadiationRegistry.Serialized(radioactivityGetter, radioactivityOverrides);
  }

  public record Serialized(HashMap<Identifier, Double> radioactivityGetter, HashMap<Identifier, Double> radioactivityOverrides) {
    public static final PacketCodec<ByteBuf, Serialized> PACKET_CODEC = new PacketCodec<>() {
      @Override
      public Serialized decode(ByteBuf byteBuf) {
        NbtCompound nbt = PacketByteBuf.readNbt(byteBuf);
        if(nbt == null) nbt = new NbtCompound();
        return Serialized.decode(nbt);
      }

      @Override
      public void encode(ByteBuf byteBuf, Serialized registry) {
        PacketByteBuf.writeNbt(byteBuf, Serialized.encode(registry));
      }
    };

    public static NbtCompound encode(Serialized registry) {
      NbtCompound radioactivityGetter = new NbtCompound();
      for (Identifier key : registry.radioactivityGetter().keySet()) {
        radioactivityGetter.putDouble(key.toString(), registry.radioactivityGetter().get(key));
      }

      NbtCompound radioactivityOverrides = new NbtCompound();
      for (Identifier key : registry.radioactivityOverrides().keySet()) {
        radioactivityOverrides.putDouble(key.toString(), registry.radioactivityOverrides().get(key));
      }

      NbtCompound nbt = new NbtCompound();
      nbt.put("radioactivityGetter", radioactivityGetter);
      nbt.put("radioactivityOverrides", radioactivityOverrides);
      return nbt;
    }

    public static Serialized decode(NbtCompound nbt) {
      NbtCompound jsonRadioactivityGetter = nbt.getCompoundOrEmpty("radioactivityGetter");
      NbtCompound jsonRadioactivityOverrides = nbt.getCompoundOrEmpty("radioactivityOverrides");

      HashMap<Identifier, Double> radioactivityGetter = new HashMap<>();
      for (String key : jsonRadioactivityGetter.getKeys()) {
        Identifier identifier = Identifier.of(key);
        double value = jsonRadioactivityGetter.getDouble(key, 0);
        if(value == 0) continue;
        radioactivityGetter.put(identifier, value);
      }

      HashMap<Identifier, Double> radioactivityOverrides = new HashMap<>();
      for (String key : jsonRadioactivityOverrides.getKeys()) {
        Identifier identifier = Identifier.of(key);
        double value = jsonRadioactivityOverrides.getDouble(key, 0);
        radioactivityOverrides.put(identifier, value);
      }

      return new Serialized(radioactivityGetter, radioactivityOverrides);
    }
  }
}
