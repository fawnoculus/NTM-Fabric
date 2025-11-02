package net.fawnoculus.ntm;


import com.mojang.serialization.Codec;
import net.fawnoculus.ntm.api.config.ConfigFile;
import net.fawnoculus.ntm.api.config.ConfigOption;
import net.fawnoculus.ntm.api.config.encoder.JsonConfigEncoder;

public class NTMClientConfig {
  public static final ConfigFile CLIENT_CONFIG_FILE = new ConfigFile(JsonConfigEncoder.getInstance(),"ntm/client.json");
  public static final ConfigOption<Boolean> BLOCK_MODEL_AMBIENT_OCCLUSION = CLIENT_CONFIG_FILE.newOption(
    "block_model_ambient_occlusion", Codec.BOOL, false,
    "makes the models lock a little better, sometimes looks a little wonky tho"
  );
  public static final ConfigOption<Boolean> FIX_EFFECT_LEVEL = CLIENT_CONFIG_FILE.newOption(
    "fix_effect_level", Codec.BOOL, true,
    "If Status Effects with high Amplifiers should be displayed as Arabic Numerals if the roman Numeral is not Available"
  );

  public static void initialize() {
    CLIENT_CONFIG_FILE.initialize();
  }
}
