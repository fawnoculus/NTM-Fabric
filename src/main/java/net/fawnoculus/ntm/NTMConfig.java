package net.fawnoculus.ntm;

import net.fawnoculus.ntm.util.config.ConfigFile;
import net.fawnoculus.ntm.util.config.PerWorldConfigFile;
import net.fawnoculus.ntm.util.config.filetype.JsonConfigFile;
import net.fawnoculus.ntm.util.config.options.BooleanOption;
import net.fawnoculus.ntm.util.config.options.IntegerOption;
import net.fawnoculus.ntm.util.config.options.StringListOption;
import net.fawnoculus.ntm.util.config.options.StringOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class NTMConfig {
  public static final Logger LOGGER = LoggerFactory.getLogger(NTM.MOD_NAME + "/Config");

  public static final ConfigFile CommonConfig = new ConfigFile("ntm/common", new JsonConfigFile(), LOGGER);
  public static final StringListOption VeinMinerAbilityExclude = CommonConfig.newStringListOption(
      "VeinMinerAbilityExclude",
      List.of(
          "minecraft:stone",
          "minecraft:cobblestone",
          "minecraft:deepslate",
          "minecraft:cobbled_deepslate",
          "minecraft:netherrack"
      ),
      "Blocks to exclude from the Vein Miner Ability (the ability already skips all blocks that the tool is incorrect for)"
  );
  public static final StringListOption AoeAbilityExclude = CommonConfig.newBlockListOption(
      "AoeAbilityExclude",
      List.of(
          "minecraft:bedrock",
          "minecraft:barrier"
      ),
      "Blocks that will be immune to the Aoe Ability (the ability already skips all blocks that the tool is incorrect for)"
  );
  public static final IntegerOption RequiredCommandPermission = CommonConfig.newIntegerOption(
      "RequiredCommandPermission", 2,
      "The required Permission-Level for Operator NTM Commands"
  );
  public static final StringOption FluidUnit = CommonConfig.newStringOption(
    "FluidUnit", "MilliBuckets",
    "What fluid unit should be used",
    "MilliBuckets", "Droplets"
  );
  public static final IntegerOption MaxNodeScanDepth = CommonConfig.newIntegerOption(
      "MaxNodeScanDepth", 100000,
      "The max Amount of Blocks a node-network will scan through when nodes are added/removed. Set to 0 to disable limit"
  );
  public static final BooleanOption AlwaysSendRadiationPacket = CommonConfig.newBooleanOption(
      "AlwaysSendRadiationPacket", false,
      "If the Server should always send the Radiation Packet to player, enabling this may increase performance with high player or addon counts"
  );
  public static final BooleanOption PrintStackTrace = CommonConfig.newBooleanOption(
      "PrintStackTrace", false,
      "This is really only usefully for debugging"
  );

  public static final PerWorldConfigFile WorldConfig = new PerWorldConfigFile("ntm/world_default", "ntm/world_config", new JsonConfigFile(), LOGGER);
  public static final BooleanOption DisableEntityRadiation = WorldConfig.newBooleanOption(
      "DisableEntityRadiation", false,
      "Stops Entities from being able to receive Radiation, does not remove already existent Radiation Poisoning"
  );
  public static final BooleanOption DisableChunkRadiation = WorldConfig.newBooleanOption(
      "DisableChunkRadiation", false,
      "Disables Chunks having Radioactivity"
  );


  public static void initialize() {
    CommonConfig.initialize();
    WorldConfig.initialize();
  }
}
