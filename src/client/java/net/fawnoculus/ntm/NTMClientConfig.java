package net.fawnoculus.ntm;


import com.mojang.serialization.Codec;
import net.fawnoculus.ntm.api.config.ConfigFile;
import net.fawnoculus.ntm.api.config.ConfigOption;
import net.fawnoculus.ntm.api.config.encoder.JsonConfigEncoder;

public class NTMClientConfig {
  public static final ConfigFile CLIENT_CONFIG_FILE = new ConfigFile(JsonConfigEncoder.getInstance(),"ntm/client.json");
  public static final ConfigOption<Boolean> MODEL_AMBIENT_OCCLUSION = CLIENT_CONFIG_FILE.newOption(
    "model_ambient_occlusion", Codec.BOOL, true,
    "If the Advanced Models should use Ambient Occlusion (looks a little wonky without it)"
  );
  public static final ConfigOption<Boolean> FIX_EFFECT_LEVEL = CLIENT_CONFIG_FILE.newOption(
    "fix_effect_level", Codec.BOOL, true,
    "If Status Effects with high Amplifiers should be displayed as Arabic Numerals if the roman Numeral is not Available"
  );

  public static void initialize() {
    CLIENT_CONFIG_FILE.initialize();
  }
}
