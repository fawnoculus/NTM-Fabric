package net.fawnoculus.ntm.main;

import net.fawnoculus.ntm.util.config.ConfigFile;
import net.fawnoculus.ntm.util.config.filetype.JsonConfigFile;
import net.fawnoculus.ntm.util.config.filetype.PropertiesConfigFile;
import net.fawnoculus.ntm.util.config.options.IntegerOption;
import net.fawnoculus.ntm.util.config.options.StringListOption;
import net.fawnoculus.ntm.util.config.options.StringOption;

import java.util.ArrayList;
import java.util.List;

public class NTMConfig {
  public static final ConfigFile ClientConfig = new ConfigFile("config/ntm/client.json", new JsonConfigFile(), NTM.LOGGER);
  public static final IntegerOption testInt = ClientConfig.newIntegerOption("testInt", 1000, "the testing of Int is important", 0, 1000000);
  
  public static final ConfigFile CommonConfig = new ConfigFile("config/ntm/common", new PropertiesConfigFile(), NTM.LOGGER);
  public static final StringListOption testList = CommonConfig.newStringListOption("testList", new ArrayList<>(List.of("ABC","cba","EfG")), "this is a List");
  public static final StringOption test = CommonConfig.newStringOption("test", "yes!", null);
  
  public static void initialize(){
    ClientConfig.initialize();
    CommonConfig.initialize();
  }
}
