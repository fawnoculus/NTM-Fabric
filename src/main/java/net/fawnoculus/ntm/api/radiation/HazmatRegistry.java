package net.fawnoculus.ntm.api.radiation;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
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
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class HazmatRegistry {
  private static final HazmatRegistry INSTANCE = new HazmatRegistry();

  public static HazmatRegistry getInstance(){
    return INSTANCE;
  }

  public static void initialize() {
    INSTANCE.loadOverrides();
  }

  private final HashMap<Identifier, Double> hazmatGetter = new HashMap<>();
  private final HashMap<Identifier, Double> hazmatOverrides = new HashMap<>();


  private void loadOverrides() {
    File file = FabricLoader.getInstance().getConfigDir().resolve("ntm/overrides/hazmat.json").toFile();
    if(!file.exists()){
      try{
        boolean ignored = file.getParentFile().mkdirs();
        boolean newFile = file.createNewFile();
        if(newFile){
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
        }else {
          NTM.LOGGER.warn("Failed to crate Hazmat Overrides File");
        }
      }catch (Exception e){
        NTM.LOGGER.error("An Exception occurred while trying to crate Hazmat Overrides File\nException:{}", ExceptionUtil.makePretty(e));
      }
      return;
    }
    JsonObject overrides = new JsonObject();
    try{
      FileReader fileReader = new FileReader(file);
      overrides = JsonUtil.jsonFromReader(fileReader);
    }catch (Exception e){
      NTM.LOGGER.error("An Exception occurred while trying read Hazmat Overrides File\nException:{}", ExceptionUtil.makePretty(e));
    }

    for(String key : overrides.keySet()){
      try{
        Identifier identifier = Identifier.of(key);
        Double value = overrides.get(key).getAsDouble();
        hazmatOverrides.put(identifier, value);
      }catch (Exception e){
        NTM.LOGGER.error("An Exception occurred while trying parse Hazmat Overrides for {}\nException:{}", key, ExceptionUtil.makePretty(e));
      }
    }

    NTM.LOGGER.info("Successfully loaded Hazmat Overrides for {} identifier(s)", hazmatOverrides.size());
  }

  public double getResistance(LivingEntity entity){
    double resistance = 0;
    if(entity instanceof EquipmentHolder equipmentHolder){
      try{
        resistance += getResistance(equipmentHolder.getEquippedStack(EquipmentSlot.HEAD));
      }catch (Throwable ignored){}
      try{
        resistance += getResistance(equipmentHolder.getEquippedStack(EquipmentSlot.CHEST));
      }catch (Throwable ignored){}
      try{
        resistance += getResistance(equipmentHolder.getEquippedStack(EquipmentSlot.LEGS));
      }catch (Throwable ignored){}
      try{
        resistance += getResistance(equipmentHolder.getEquippedStack(EquipmentSlot.FEET));
      }catch (Throwable ignored){}
      try{
        resistance += getResistance(equipmentHolder.getEquippedStack(EquipmentSlot.BODY));
      }catch (Throwable ignored){}
      try{
        resistance += getResistance(equipmentHolder.getEquippedStack(EquipmentSlot.SADDLE));
      }catch (Throwable ignored){}
    }
    return resistance;
  }

  public double getResistance(ItemStack stack) {
    return getResistance(stack.getItem()) * stack.getCount();
  }
  public double getResistance(Item item) {
    return getResistance(Registries.ITEM.getId(item));
  }
  public double getResistance(Identifier identifier) {
    Double override = hazmatOverrides.get(identifier);
    if (override != null) {
      return override;
    }
    return hazmatGetter.getOrDefault(identifier, 0.0);
  }

  public void register(Block block, double milliRads) {
    this.register(Registries.BLOCK.getId(block), milliRads);
  }
  public void register(Item item, double milliRads) {
    this.register(Registries.ITEM.getId(item), milliRads);
  }
  public void register(Identifier identifier, double milliRads) {
    this.hazmatGetter.put(identifier, milliRads);
  }

  public HazmatRegistry.Serialized serialize() {
    return new HazmatRegistry.Serialized(this.hazmatGetter, this.hazmatOverrides);
  }

  public record Serialized(HashMap<Identifier, Double> hazmatGetter,
                           HashMap<Identifier, Double> hazmatOverrides) {
    public static final PacketCodec<ByteBuf, HazmatRegistry.Serialized> PACKET_CODEC = new PacketCodec<>() {
      @Override
      public HazmatRegistry.Serialized decode(ByteBuf byteBuf) {
        String string = new String(PacketByteBuf.readByteArray(byteBuf), StandardCharsets.UTF_8);
        return HazmatRegistry.Serialized.decode(JsonUtil.jsonFromString(string));
      }

      @Override
      public void encode(ByteBuf byteBuf, HazmatRegistry.Serialized registry) {
        JsonObject json = HazmatRegistry.Serialized.encode(registry);
        PacketByteBuf.writeByteArray(byteBuf, json.toString().getBytes(StandardCharsets.UTF_8));
      }
    };

    public static JsonObject encode(HazmatRegistry.Serialized registry) {
      JsonObject hazmatGetter = new JsonObject();
      for(Identifier key : registry.hazmatGetter().keySet()){
        Double value = registry.hazmatGetter().get(key);
        hazmatGetter.add(key.toString(), new JsonPrimitive(value));
      }
      JsonObject radioactivityOverrides = new JsonObject();
      for(Identifier key : registry.hazmatOverrides().keySet()){
        Double value = registry.hazmatOverrides().get(key);
        radioactivityOverrides.add(key.toString(), new JsonPrimitive(value));
      }
      JsonObject json = new JsonObject();
      json.add("hazmatGetter", hazmatGetter);
      json.add("hazmatOverrides", radioactivityOverrides);
      return json;
    }

    public static HazmatRegistry.Serialized decode(JsonObject json) {
      JsonObject jsonHazmatGetter = json.get("hazmatGetter").getAsJsonObject();
      JsonObject jsonHazmatOverrides = json.get("hazmatOverrides").getAsJsonObject();
      HashMap<Identifier, Double> hazmatGetter = new HashMap<>();
      for(String key : jsonHazmatGetter.keySet()){
        Identifier identifier = Identifier.of(key);
        Double value = jsonHazmatGetter.get(key).getAsDouble();
        hazmatGetter.put(identifier, value);
      }
      HashMap<Identifier, Double> hazmatOverrides = new HashMap<>();
      for(String key : jsonHazmatOverrides.keySet()){
        Identifier identifier = Identifier.of(key);
        Double value = jsonHazmatOverrides.get(key).getAsDouble();
        hazmatOverrides.put(identifier, value);
      }

      return new HazmatRegistry.Serialized(hazmatGetter, hazmatOverrides);
    }
  }
}
