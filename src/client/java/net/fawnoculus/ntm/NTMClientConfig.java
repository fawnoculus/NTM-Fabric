package net.fawnoculus.ntm;


import net.fawnoculus.ntm.util.config.ConfigFile;
import net.fawnoculus.ntm.util.config.filetype.JsonConfigFile;
import net.fawnoculus.ntm.util.config.options.IntegerOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NTMClientConfig {
  public static final Logger LOGGER = LoggerFactory.getLogger(NTM.MOD_NAME + "/Client/Config");
  
  public static final ConfigFile ClientConfig = new ConfigFile("ntm/client", new JsonConfigFile(), LOGGER);
  public static final IntegerOption Bumpscocity = ClientConfig.newIntegerOption("Bumpscocity", 1000,
      "Adjust the Bumpscocity that the will be used (This is definitely not a Stanley Parable Reference)",
      0, 1000000);
  
  
  public static void initialize() {
    ClientConfig.initialize();
  }
}
