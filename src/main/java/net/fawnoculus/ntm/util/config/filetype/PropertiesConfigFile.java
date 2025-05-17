package net.fawnoculus.ntm.util.config.filetype;

import net.fawnoculus.ntm.util.config.ConfigFileType;
import net.fawnoculus.ntm.util.config.Option;
import net.fawnoculus.ntm.util.config.options.StringListOption;
import org.slf4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class PropertiesConfigFile implements ConfigFileType {
  @Override
  public String getFileExtension() {
    return ".properties";
  }
  
  @Override
  public Boolean isValidOption(Option<?> option) {
    return !isStringInvalid(option.NAME);
  }
  
  @Override
  public Boolean isValidValue(Object value) {
    switch (value){
      case String string ->{
        return !isStringInvalid(string);
      }
      case String[] strings ->{
        for(String string: strings){
          if(isStringInvalid(string)) return false;
        }
        return true;
      }
      default -> {
        return true;
      }
    }
  }
  
  private boolean isStringInvalid(String string){
    return string.contains("\n")
        || string.contains("=")
        || string.contains("#");
  }
  
  @Override
  public List<Option<?>> readFile(File configFile, Logger LOGGER, List<Option<?>> expectedOptions) {
    return List.of();
  }
  
  @Override
  public void writeFile(File configFile, Logger LOGGER, List<Option<?>> options) throws IOException {
    FileWriter writer = new FileWriter(configFile);
    
    for(Option<?> option : options){
      switch (option){
        case StringListOption stringListOption ->{
          writer.write(String.format("%s=[%s", option.NAME, stringListOption.getValue().getFirst()));
          
          for(String string : stringListOption.getValue()){
            writer.write(String.format(",%s", string));
          }
        }
        default -> writer.write(String.format("%s=%s", option.NAME, option.getValue()));
      }
    }
  }
}
