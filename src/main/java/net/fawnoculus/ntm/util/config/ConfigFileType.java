package net.fawnoculus.ntm.util.config;


import net.fawnoculus.ntm.util.config.options.Option;

import java.io.Writer;
import java.util.List;
import java.util.Scanner;

public interface ConfigFileType {
  
  String getFileExtention();
  
  List<Option<?>> readFile(Scanner reader, List<Option<?>> expectedOptions);
  void writeFile(Writer writer, List<Option<?>> options);
}
