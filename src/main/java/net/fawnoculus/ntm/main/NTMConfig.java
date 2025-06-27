package net.fawnoculus.ntm.main;

import net.fabricmc.api.EnvType;
import net.fawnoculus.ntm.util.config.ConfigFile;
import net.fawnoculus.ntm.util.config.PerWorldConfigFile;
import net.fawnoculus.ntm.util.config.filetype.JsonConfigFile;
import net.fawnoculus.ntm.util.config.options.BooleanOption;
import net.fawnoculus.ntm.util.config.options.IntegerOption;
import net.fawnoculus.ntm.util.config.options.StringListOption;

import java.util.List;

public class NTMConfig {
  
  public static final ConfigFile ClientConfig = new ConfigFile("ntm/client", new JsonConfigFile(), NTM.LOGGER);
  public static final IntegerOption Bumpscocity = ClientConfig.newIntegerOption("Bumpscocity", 1000, "Adjust the Bumpscocity that the will be used (This is definitely not a Stanley Parable Reference)", 0, 1000000);
  
  public static final ConfigFile CommonConfig = new ConfigFile("ntm/common", new JsonConfigFile(), NTM.LOGGER);
  public static final StringListOption VeinMinerAbilityExclude = CommonConfig.newStringListOption("VeinMinerAbilityExclude",
      List.of(
          "minecraft:stone",
          "minecraft:cobblestone",
          "minecraft:deepslate",
          "minecraft:cobbled_deepslate",
          "minecraft:netherrack"),
      "Blocks to exclude from the Vein Miner Ability (the ability already skips all blocks that the tool is incorrect for)");
  public static final StringListOption AoeAbilityExclude = CommonConfig.newBlockListOption("AoeAbilityExclude",
      List.of(
          "minecraft:bedrock",
          "minecraft:barrier"),
      "Blocks that will be immune to the Aoe Ability (the ability already skips all blocks that the tool is incorrect for)" );
  public static final IntegerOption RequiredCommandPermission = CommonConfig.newIntegerOption("RequiredCommandPermission", 2 , "The required Permission-Level for Operator NTM Commands");
  public static final IntegerOption MaxNodeScanDepth = CommonConfig.newIntegerOption("MaxNodeScanDepth", 100000 , "The max Amount of Blocks a node-network will scan through when nodes are added/removed. Set to 0 to disable limit");
  
  public static final ConfigFile WorldConfig = new PerWorldConfigFile("ntm/world_default", "ntm/world_config", new JsonConfigFile(), NTM.LOGGER);
  public static final BooleanOption WorldTestOption = WorldConfig.newBooleanOption("test", true, "this is a test");
  
  
  public static void initialize(){
    if(NTM.ENVIRONMENT == EnvType.CLIENT) {
      ClientConfig.initialize();
    }
    CommonConfig.initialize();
    WorldConfig.initialize();
  }
}
