package net.fawnoculus.ntm.main;

import net.fabricmc.api.EnvType;
import net.fawnoculus.ntm.util.config.ConfigFile;
import net.fawnoculus.ntm.util.config.filetype.JsonConfigFile;
import net.fawnoculus.ntm.util.config.options.IntegerOption;
import net.fawnoculus.ntm.util.config.options.StringListOption;

import java.util.List;

public class NTMConfig {
  
  public static final ConfigFile ClientConfig = new ConfigFile(configPath("ntm/client.json"), new JsonConfigFile(), NTM.LOGGER);
  public static final IntegerOption Bumpscocity = ClientConfig.newIntegerOption("Bumpscocity", 1000, "Adjust the Bumpscocity that the will be used (This is definitely not a Stanley Parable Reference)", 0, 1000000);
  
  public static final ConfigFile CommonConfig = new ConfigFile(configPath("ntm/common"), new JsonConfigFile(), NTM.LOGGER);
  public static final StringListOption VeinMinerAbilityExclude = CommonConfig.newStringListOption("VeinMinerAbilityExclude",
      List.of(
          "minecraft:stone",
          "minecraft:cobblestone",
          "minecraft:deepslate",
          "minecraft:cobbled_deepslate",
          "minecraft:netherrack"),
      "Blocks to exclude from the Vein Miner Ability (the ability already skips all blocks that the tool is incorrect for)", StringListOption.Type.BLOCK);
  public static final StringListOption AoeAbilityExclude = CommonConfig.newStringListOption("AoeAbilityExclude",
      List.of(
          "minecraft:bedrock",
          "minecraft:barrier"),
      "Blocks that will be immune to the Aoe Ability (the ability already skips all blocks that the tool is incorrect for)" , StringListOption.Type.BLOCK);
  
  public static final ConfigFile WorldDefaultConfig = new ConfigFile(configPath("/ntm/world_default"), new JsonConfigFile(), NTM.LOGGER);
  
  
  public static ConfigFile WorldConfig = WorldDefaultConfig; // this is manually overwritten on World Startup
  
  public static void initialize(){
    if(NTM.ENVIRONMENT == EnvType.CLIENT) ClientConfig.initialize();
    CommonConfig.initialize();
    WorldDefaultConfig.initialize();
  }
  
  private static String configPath(String name){
    return NTM.CONFIG_DIR.toString() + "/" + name;
  }
}
