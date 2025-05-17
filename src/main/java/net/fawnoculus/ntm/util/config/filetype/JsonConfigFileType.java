package net.fawnoculus.ntm.util.config.filetype;

import net.fawnoculus.ntm.util.config.ConfigFileType;
import net.fawnoculus.ntm.util.config.Option;
import org.slf4j.Logger;

import java.io.Writer;
import java.util.List;
import java.util.Scanner;

public class JsonConfigFileType implements ConfigFileType {
  @Override
  public String getFileExtention() {
    return ".json";
  }
  
  @Override
  public List<Option<?>> readFile(Scanner reader, Logger LOGGER, List<Option<?>> expectedOptions) {
    return List.of();
  }
  
  @Override
  public void writeFile(Writer writer, Logger LOGGER, List<Option<?>> options) {
  
  }
}
