package net.fawnoculus.ntm;

import com.mojang.serialization.Codec;
import net.fabricmc.loader.api.FabricLoader;
import net.fawnoculus.ntm.api.config.ConfigFile;
import net.fawnoculus.ntm.api.config.ConfigOption;
import net.fawnoculus.ntm.api.config.PerWorldConfigFile;
import net.fawnoculus.ntm.api.config.PerWorldConfigOption;
import net.fawnoculus.ntm.api.config.encoder.JsonConfigEncoder;
import net.fawnoculus.ntm.misc.data.NTMCodecs;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

import java.util.List;
import java.util.function.Function;

public class NTMConfig {
  public static final ConfigFile COMMON_CONFIG_FILE = new ConfigFile(
    JsonConfigEncoder.getInstance(),
    "ntm/common.json"
  );
  public static final ConfigOption<List<Block>> VEIN_MINER_ABILITY_EXCLUDE = COMMON_CONFIG_FILE.newOption(
    "vein_miner_ability_exclude",
    NTMCodecs.BLOCK_CODEC.listOf(),
    List.of(
      Blocks.STONE,
      Blocks.COBBLESTONE,
      Blocks.DEEPSLATE,
      Blocks.COBBLED_DEEPSLATE,
      Blocks.NETHERRACK
    ),
    "Blocks that will be excluded from the Vein Miner Tool Ability, it already excludes all blocks that the tool can not mine"
  );
  public static final ConfigOption<List<Block>> AOE_ABILITY_EXCLUDE = COMMON_CONFIG_FILE.newOption(
    "aoe_ability_exclude",
    NTMCodecs.BLOCK_CODEC.listOf(),
    List.of(
      Blocks.BARRIER,
      Blocks.BEDROCK
    ),
    "Blocks that will be excluded from the Aoe and Flat Aoe Tool Ability, it already excludes all blocks that the tool can not mine"
  );
  public static final ConfigOption<Integer> REQUIRED_COMMAND_PERMISSION = COMMON_CONFIG_FILE.newOption(
    "required_command_permission", Codec.INT, 2, "Permission Level required to execute Operator NTM Commands [Requires Restart]"
  );
  public static final ConfigOption<FluidUnit> FLUID_UNIT = COMMON_CONFIG_FILE.newOption(
    "fluid_unit", FluidUnit.CODEC, FluidUnit.MilliBuckets, "Fluid Unit to be displayed [MilliBuckets, Droplets]"
  );
  public static final ConfigOption<TempUnit> TEMP_UNIT = COMMON_CONFIG_FILE.newOption(
    "temp_unit", TempUnit.CODEC, TempUnit.Celsius, "Temperature Unit to be displayed [Celsius, Fahrenheit, Kelvin]"
  );

  public static final ConfigFile DEV_CONFIG_FILE = new ConfigFile(
    JsonConfigEncoder.getInstance(),
    "ntm/dev.json"
  );
  public static final ConfigOption<Boolean> DEV_MODE = DEV_CONFIG_FILE.newOption(
    "dev_mode",  Codec.BOOL, FabricLoader.getInstance().isDevelopmentEnvironment()
  );
  public static final ConfigOption<Boolean> PRINT_STACKTRACE = DEV_CONFIG_FILE.newOption(
    "print_stacktrace", Codec.BOOL, FabricLoader.getInstance().isDevelopmentEnvironment()
  );
  public static final ConfigOption<Integer> MAX_REGION_DATA_CACHE = DEV_CONFIG_FILE.newOption(
    "max_region_data_cache", Codec.INT, 512
  );
  public static final ConfigOption<Integer> MAX_NODE_SCAN_DEPTH = DEV_CONFIG_FILE.newOption(
    "max_node_scan_depth", Codec.INT, 100000
  );

  public static final PerWorldConfigFile WORLD_CONFIG = new PerWorldConfigFile(
    JsonConfigEncoder.getInstance(),
    "ntm/world_default.json",
    "ntm/world_config.json"
  );
  public static final PerWorldConfigOption<Boolean> DISABLE_ENTITY_RADIATION = WORLD_CONFIG.newOption(
    "disable_entity_radiation", Codec.BOOL, false,
    "Stops Entities from being able to receive Radiation, does not remove already existent Radiation Poisoning"
  );
  public static final PerWorldConfigOption<Boolean> DISABLE_CHUNK_RADIATION = WORLD_CONFIG.newOption(
    "disable_chunk_radiation", Codec.BOOL, false,
    "Disables Chunks having Radioactivity"
  );

  public static void initialize() {
    COMMON_CONFIG_FILE.initialize();
    DEV_CONFIG_FILE.initialize();
    WORLD_CONFIG.initialize();
  }

  public enum TempUnit {
    Celsius(celsius -> Text.literal(String.format("%,.1f", celsius)).append(Text.translatable("generic.ntm.temp.c"))),
    Fahrenheit(celsius -> Text.literal(String.format("%,.1f", (celsius * 9 / 5) + 32)).append(Text.translatable("generic.ntm.temp.f"))),
    Kelvin(celsius -> Text.literal(String.format("%,.1f", celsius - 273.15)).append(Text.translatable("generic.ntm.temp.k")));

    public static final Codec<TempUnit> CODEC = NTMCodecs.getEnumCodec(TempUnit.class);
    public final Function<Double, MutableText> CELSIUS_TO_TEXT;


    TempUnit(Function<Double, MutableText> celsiusToText) {
      this.CELSIUS_TO_TEXT = celsiusToText;
    }
  }

  public enum FluidUnit {
    MilliBuckets,
    Droplets;

    public static final Codec<FluidUnit> CODEC = NTMCodecs.getEnumCodec(FluidUnit.class);
  }
}
