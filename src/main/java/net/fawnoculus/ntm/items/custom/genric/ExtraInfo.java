package net.fawnoculus.ntm.items.custom.genric;

import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.fawnoculus.ntm.NTM;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.Collection;

public interface ExtraInfo {
  Collection<Text> getInfo();
  
  default Text getHelpText(){
    if(FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT){
      return Text.translatable("tooltip.ntm.hold_for_info").formatted(Formatting.DARK_GRAY);
    }else {
      NTM.LOGGER.warn("Tired to call 'ExtraInfo.getHelperTet()' on the Server");
      return Text.literal("Please do not call 'ExtraInfo.getHelperTet()' on the Server").formatted(Formatting.RED);
    }
  }
}
