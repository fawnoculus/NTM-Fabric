package net.fawnoculus.ntm;


import net.fawnoculus.ntm.util.config.ConfigFile;
import net.fawnoculus.ntm.util.config.filetype.JsonConfigFile;
import net.fawnoculus.ntm.util.config.options.BooleanOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NTMClientConfig {
  public static final Logger LOGGER = LoggerFactory.getLogger(NTM.MOD_NAME + "/Client/Config");

  public static final ConfigFile ClientConfig = new ConfigFile("ntm/client", new JsonConfigFile(), LOGGER);
  public static final BooleanOption FixEffectDisplay = ClientConfig.newBooleanOption("FixEffectDisplay", true,
    "If Status Effects with high Amplifiers should be displayed as Arabic Numbers if the roman Numeral is not Available"
  );


  public static void initialize() {
    ClientConfig.initialize();
  }
}
