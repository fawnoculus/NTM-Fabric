package net.fawnoculus.ntm.util.config;


import net.fawnoculus.ntm.util.config.options.Option;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Scanner;

public class ConfigFile {
  private List<Option<?>> options;
  
  public final ConfigFileType CONFIG_FILE_TYPE;
  
  private final File CONFIG_FILE;
  private final Scanner CONFIG_READER;
  private final Writer CONFIG_WRITER;
  private final Logger LOGGER;
  
  ConfigFile(String path, ConfigFileType configFileType, @Nullable Logger logger){
    this.CONFIG_FILE_TYPE = configFileType;
    this.LOGGER = logger != null ? logger : LoggerFactory.getLogger("FawnConfigUtil");
    
    if(path.endsWith(configFileType.getFileExtention())){
      this.CONFIG_FILE = new File(path);
    }else {
      this.CONFIG_FILE = new File(path + configFileType.getFileExtention());
    }
    
    
    // Get Writer
    Writer configWriter = null;
    try {
      configWriter = new FileWriter(CONFIG_FILE);
      if(!CONFIG_FILE.exists()){
        CONFIG_FILE.mkdirs();
        CONFIG_FILE.createNewFile();
        writeFile();
      }
    } catch(Exception exception){
      LOGGER.error("Failed to write Config File: {} \n Exception: {}", CONFIG_FILE.getPath(), exception);
    }
    this.CONFIG_WRITER = configWriter;
    
    // Get Reader
    Scanner configScanner = null;
    try {
      configScanner = new Scanner(CONFIG_FILE);
      if(CONFIG_FILE.exists()){
        readFile();
      }
    } catch(Exception exception){
      LOGGER.error("Failed to open Config File: {} \n Exception: {}", CONFIG_FILE.getPath(), exception);
    }
    this.CONFIG_READER = configScanner;
  }
  
  public void readFile(){
    List<Option<?>> readOptions = this.options;
    
    try {
      readOptions = CONFIG_FILE_TYPE.readFile(CONFIG_READER ,this.options);
    } catch(Exception exception) {
      LOGGER.error("Failed to read from Config File: {} \n Exception: {}", CONFIG_FILE.getPath(), exception);
    }
    
    this.options = readOptions;
  }
  
  public void writeFile(){
    try {
      boolean delete = CONFIG_FILE.delete();
      if(!delete){
        LOGGER.warn("Failed to delete old Config File");
        throw new IOException("Failed to delete old Config File");
      }
      
      CONFIG_FILE_TYPE.writeFile(CONFIG_WRITER, this.options);
    } catch(Exception exception) {
      LOGGER.error("Failed to write to Config File: {} \n Exception: {}", CONFIG_FILE.getPath(), exception);
    }
  }
}
