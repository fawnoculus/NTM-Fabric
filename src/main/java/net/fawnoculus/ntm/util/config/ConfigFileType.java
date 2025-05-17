package net.fawnoculus.ntm.util.config;


import org.slf4j.Logger;

import java.io.Writer;
import java.util.List;
import java.util.Scanner;

public interface ConfigFileType {
  
  String getFileExtention();
  
  List<Option<?>> readFile(Scanner reader, Logger LOGGER, List<Option<?>> expectedOptions);
  void writeFile(Writer writer, Logger LOGGER, List<Option<?>> options);
}
