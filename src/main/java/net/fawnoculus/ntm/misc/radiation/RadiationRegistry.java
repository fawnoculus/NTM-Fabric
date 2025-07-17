package net.fawnoculus.ntm.misc.radiation;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import io.netty.buffer.ByteBuf;
import net.fabricmc.loader.api.FabricLoader;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.util.ExceptionUtil;
import net.fawnoculus.ntm.util.JsonUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class RadiationRegistry {
  private static final RadiationRegistry INSTANCE = new RadiationRegistry();
  
  public static RadiationRegistry getInstance() {
    return INSTANCE;
  }
  
  public static void initialize() {
    INSTANCE.loadOverrides();
  }
  
  private final HashMap<Identifier, Double> radioactivityGetter = new HashMap<>();
  private final HashMap<Identifier, Double> radioactivityOverrides = new HashMap<>();
  
  public void loadOverrides() {
    File file = FabricLoader.getInstance().getConfigDir().resolve("ntm/overrides/radiation.json").toFile();
    if(!file.exists()){
      try{
        boolean ignored = file.getParentFile().mkdirs();
        boolean newFile = file.createNewFile();
        if(newFile){
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
        }else {
          NTM.LOGGER.warn("Failed to crate Radiation Overrides File");
        }
      }catch (Exception e){
        NTM.LOGGER.error("An Exception occurred while trying to crate Radiation Overrides File\nException:{}", ExceptionUtil.makePretty(e));
      }
      return;
    }
    JsonObject overrides = new JsonObject();
    try{
      FileReader fileReader = new FileReader(file);
      overrides = JsonUtil.jsonFromReader(fileReader);
    }catch (Exception e){
      NTM.LOGGER.error("An Exception occurred while trying read Radiation Overrides File\nException:{}", ExceptionUtil.makePretty(e));
    }
    
    for(String key : overrides.keySet()){
      try{
        Identifier identifier = Identifier.of(key);
        Double value = overrides.get(key).getAsDouble();
        radioactivityOverrides.put(identifier, value);
      }catch (Exception e){
        NTM.LOGGER.error("An Exception occurred while trying parse Radiation Overrides for {}\nException:{}", key, ExceptionUtil.makePretty(e));
      }
    }
    
    NTM.LOGGER.info("Successfully loaded Radioactivity Overrides for {} identifier(s)", radioactivityOverrides.size());
  }
  
  public double getRadioactivity(World world) {
    try{
      return getRadioactivity(world.getRegistryManager().getOrThrow(RegistryKeys.DIMENSION_TYPE).getId(world.getDimension()));
    }catch (Throwable throwable){
      return 0;
    }
  }
  public double getRadioactivity(BlockState state) {
    return getRadioactivity(state.getBlock());
  }
  public double getRadioactivity(Block block) {
    return getRadioactivity(Registries.BLOCK.getId(block));
  }
  public double getRadioactivity(ItemStack stack) {
    return getRadioactivity(stack.getItem()) * stack.getCount();
  }
  public double getRadioactivity(Item item) {
    return getRadioactivity(Registries.ITEM.getId(item));
  }
  public double getRadioactivity(Identifier identifier) {
    Double override = radioactivityOverrides.get(identifier);
    if (override != null) {
      return override;
    }
    return radioactivityGetter.getOrDefault(identifier, 0.0);
  }
  
  public void register(Block block, double milliRads) {
    this.register(Registries.BLOCK.getId(block), milliRads);
  }
  public void register(Item item, double milliRads) {
   this.register(Registries.ITEM.getId(item), milliRads);
  }
  public void register(Identifier identifier, double milliRads) {
    this.radioactivityGetter.put(identifier, milliRads);
  }
  
  public RadiationRegistry.Serialized serialize() {
    return new RadiationRegistry.Serialized(this.radioactivityGetter, this.radioactivityOverrides);
  }
  
  public record Serialized(HashMap<Identifier, Double> radioactivityGetter,
                           HashMap<Identifier, Double> radioactivityOverrides) {
    public static final PacketCodec<ByteBuf, Serialized> PACKET_CODEC = new PacketCodec<>() {
      @Override
      public Serialized decode(ByteBuf byteBuf) {
        String string = new String(PacketByteBuf.readByteArray(byteBuf), StandardCharsets.UTF_8);
        return Serialized.decode(JsonUtil.jsonFromString(string));
      }
      
      @Override
      public void encode(ByteBuf byteBuf, Serialized registry) {
        JsonObject json = Serialized.encode(registry);
        PacketByteBuf.writeByteArray(byteBuf, json.toString().getBytes(StandardCharsets.UTF_8));
      }
    };
    
    public static JsonObject encode(Serialized registry) {
      JsonObject radioactivityGetter = new JsonObject();
      for(Identifier key : registry.radioactivityGetter().keySet()){
        Double value = registry.radioactivityGetter().get(key);
        radioactivityGetter.add(key.toString(), new JsonPrimitive(value));
      }
      JsonObject radioactivityOverrides = new JsonObject();
      for(Identifier key : registry.radioactivityOverrides().keySet()){
        Double value = registry.radioactivityOverrides().get(key);
        radioactivityOverrides.add(key.toString(), new JsonPrimitive(value));
      }
      JsonObject json = new JsonObject();
      json.add("radioactivityGetter", radioactivityGetter);
      json.add("radioactivityOverrides", radioactivityOverrides);
      return json;
    }
    
    public static Serialized decode(JsonObject json) {
      JsonObject jsonRadioactivityGetter = json.get("radioactivityGetter").getAsJsonObject();
      JsonObject jsonRadioactivityOverrides = json.get("radioactivityOverrides").getAsJsonObject();
      HashMap<Identifier, Double> radioactivityGetter = new HashMap<>();
      for(String key : jsonRadioactivityGetter.keySet()){
        Identifier identifier = Identifier.of(key);
        Double value = jsonRadioactivityGetter.get(key).getAsDouble();
        radioactivityGetter.put(identifier, value);
      }
      HashMap<Identifier, Double> radioactivityOverrides = new HashMap<>();
      for(String key : jsonRadioactivityOverrides.keySet()){
        Identifier identifier = Identifier.of(key);
        Double value = jsonRadioactivityOverrides.get(key).getAsDouble();
        radioactivityOverrides.put(identifier, value);
      }
      
      return new Serialized(radioactivityGetter, radioactivityOverrides);
    }
  }
}
