package net.fawnoculus.ntm.util.config;


import net.fawnoculus.ntm.util.config.options.Option;
import org.slf4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ConfigFileType {
  
  String getFileExtension();
  
  Boolean isValidOption(Option<?> option);
  Boolean isValidValue(Object value);
  
  List<Option<?>> readFile(File configFile, Logger LOGGER, List<Option<?>> expectedOptions) throws FileNotFoundException;
  void writeFile(File configFile, Logger LOGGER, List<Option<?>> options) throws IOException;
}
