package net.fawnoculus.ntm;


import net.fawnoculus.ntm.util.config.ConfigFile;
import net.fawnoculus.ntm.util.config.filetype.JsonConfigFile;
import net.fawnoculus.ntm.util.config.options.IntegerOption;

public class NTMClientConfig {
  public static final ConfigFile ClientConfig = new ConfigFile("ntm/client", new JsonConfigFile(), NTM.LOGGER);
  public static final IntegerOption Bumpscocity = ClientConfig.newIntegerOption("Bumpscocity", 1000,
      "Adjust the Bumpscocity that the will be used (This is definitely not a Stanley Parable Reference)",
      0, 1000000);
  
  
  public static void initialize() {
    ClientConfig.initialize();
  }
}
