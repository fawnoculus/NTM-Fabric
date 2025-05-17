package net.fawnoculus.ntm.util.config;


import net.fawnoculus.ntm.util.config.options.*;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class ConfigFile {
  private List<Option<?>> options;
  private Boolean initialized = false;
  
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
    
    // Get Reader
    Scanner configScanner = null;
    try {
      configScanner = new Scanner(CONFIG_FILE);
    } catch(Exception exception){
      LOGGER.error("Failed to get Config File Reader: {} \n Exception: {}", CONFIG_FILE.getPath(), exception);
    }
    this.CONFIG_READER = configScanner;
    
    // Get Writer
    Writer configWriter = null;
    try {
      configWriter = new FileWriter(CONFIG_FILE);
    } catch(Exception exception){
      LOGGER.error("Failed to get Config File Writer: {} \n Exception: {}", CONFIG_FILE.getPath(), exception);
    }
    this.CONFIG_WRITER = configWriter;
  }
  
  public void readFile(){
    List<Option<?>> readOptions = this.options;
    
    try {
      readOptions = this.CONFIG_FILE_TYPE.readFile(CONFIG_READER, this.LOGGER, this.options);
    } catch(Exception exception) {
      LOGGER.error("Failed to read from Config File: {} \n Exception: {}", CONFIG_FILE.getPath(), exception);
    }
    
    this.options = readOptions;
  }
  
  public void writeFile(){
    try {
      if(!CONFIG_FILE.exists()) {
        boolean ignored = CONFIG_FILE.getParentFile().mkdirs();
        boolean newFile = CONFIG_FILE.createNewFile();
        if(newFile) {
          LOGGER.info("Created new Config File: {}", CONFIG_FILE.getPath());
        }else {
          LOGGER.info("Failed to create Config File: {}", CONFIG_FILE.getPath());
        }
      }else {
        boolean delete = CONFIG_FILE.delete();
        if (!delete) {
          LOGGER.warn("Failed to delete old Config File: {}", CONFIG_FILE.getPath());
        }
      }
      
      this.CONFIG_FILE_TYPE.writeFile(CONFIG_WRITER, this.LOGGER, this.options);
    } catch(Exception exception) {
      LOGGER.error("Failed to write to Config File: {} \n Exception: {}", CONFIG_FILE.getPath(), exception);
    }
  }
  
  public void initialize(){
    if(initialized){
      throw new RuntimeException("Config File already Initialized");
    }
    
    if(CONFIG_FILE.exists()){
      readFile();
    }
    writeFile();
    
    initialized = true;
  }
  
  // Everything bellow is just for getting new Options for a Config File //
  
  /**
   * @param name         Name of the Option
   * @param defaultValue the Value that the Option will default to
   * @param comment      Optional Comment (use "null" for no Comment)
   * @param validator    Function for additional Validation (like: value > 10 && value < 100 or smth.)
   */
  public BooleanOption newBooleanOption(String name, Boolean defaultValue, @Nullable String comment, Function<Boolean, Boolean> validator) {
    BooleanOption option = new BooleanOption(name, defaultValue, comment, validator);
    this.options.add(option);
    return option;
  }
  /**
   * @param name         Name of the Option
   * @param defaultValue the Value that the Option will default to
   * @param comment      Optional Comment (use "null" for no Comment)
   */
  public BooleanOption newBooleanOption(String name, Boolean defaultValue, @Nullable String comment) {
    return newBooleanOption(name, defaultValue, comment, value -> true);
  }
  /**
   * @param name         Name of the Option
   * @param defaultValue the Value that the Option will default to
   * @param comment      Optional Comment (use "null" for no Comment)
   * @param validator    Function for additional Validation (like: value > 10 && value < 100 or smth.)
   */
  public DoubleOption newDoubleOption(String name, Double defaultValue, @Nullable String comment, Function<Double, Boolean> validator) {
    DoubleOption option = new DoubleOption(name, defaultValue, comment, validator);
    this.options.add(option);
    return option;
  }
  /**
   * @param name         Name of the Option
   * @param defaultValue the Value that the Option will default to
   * @param comment      Optional Comment (use "null" for no Comment)
   * @param min          Minimum allowed Value
   * @param max          Maximum allowed Value
   */
  public DoubleOption newDoubleOption(String name, Double defaultValue, @Nullable String comment, Double min, Double max) {
    return newDoubleOption(name, defaultValue, comment, value -> value >= min && value <= max);
  }
  /**
   * @param name         Name of the Option
   * @param defaultValue the Value that the Option will default to
   * @param comment      Optional Comment (use "null" for no Comment)
   */
  public DoubleOption newDoubleOption(String name, Double defaultValue, @Nullable String comment) {
    return newDoubleOption(name, defaultValue, comment, value -> true);
  }
  /**
   * @param name         Name of the Option
   * @param defaultValue the Value that the Option will default to
   * @param comment      Optional Comment (use "null" for no Comment)
   * @param validator    Function for additional Validation (like: value > 10 && value < 100 or smth.)
   */
  public FloatOption newFloatOption(String name, Float defaultValue, @Nullable String comment, Function<Float, Boolean> validator) {
    FloatOption option = new FloatOption(name, defaultValue, comment, validator);
    this.options.add(option);
    return option;
  }
  /**
   * @param name         Name of the Option
   * @param defaultValue the Value that the Option will default to
   * @param comment      Optional Comment (use "null" for no Comment)
   * @param min          Minimum allowed Value
   * @param max          Maximum allowed Value
   */
  public FloatOption newFloatOption(String name, Float defaultValue, @Nullable String comment, Float min, Float max) {
    return newFloatOption(name, defaultValue, comment, value -> value >= min && value <= max);
  }
  /**
   * @param name         Name of the Option
   * @param defaultValue the Value that the Option will default to
   * @param comment      Optional Comment (use "null" for no Comment)
   */
  public FloatOption newFloatOption(String name, Float defaultValue, @Nullable String comment) {
    return newFloatOption(name, defaultValue, comment, value -> true);
  }
  /**
   * @param name         Name of the Option
   * @param defaultValue the Value that the Option will default to
   * @param comment      Optional Comment (use "null" for no Comment)
   * @param validator    Function for additional Validation (like: value > 10 && value < 100 or smth.)
   */
  public IntegerOption newIntegerOption(String name, Integer defaultValue, @Nullable String comment, Function<Integer, Boolean> validator) {
    IntegerOption option = new IntegerOption(name, defaultValue, comment, validator);
    this.options.add(option);
    return option;
  }
  /**
   * @param name         Name of the Option
   * @param defaultValue the Value that the Option will default to
   * @param comment      Optional Comment (use "null" for no Comment)
   * @param min          Minimum allowed Value
   * @param max          Maximum allowed Value
   */
  public IntegerOption newIntegerOption(String name, Integer defaultValue, @Nullable String comment, Integer min, Integer max) {
    return newIntegerOption(name, defaultValue, comment, value -> value >= min && value <= max);
  }
  /**
   * @param name         Name of the Option
   * @param defaultValue the Value that the Option will default to
   * @param comment      Optional Comment (use "null" for no Comment)
   */
  public IntegerOption newIntegerOption(String name, Integer defaultValue, @Nullable String comment) {
    return newIntegerOption(name, defaultValue, comment, value -> true);
  }
  /**
   * @param name         Name of the Option
   * @param defaultValue the Value that the Option will default to
   * @param comment      Optional Comment (use "null" for no Comment)
   * @param validator    Function for additional Validation (like: value > 10 && value < 100 or smth.)
   */
  public StringOption newStringOption(String name, String defaultValue, @Nullable String comment, Function<String, Boolean> validator) {
    StringOption option = new StringOption(name, defaultValue, comment, validator);
    this.options.add(option);
    return option;
  }
  /**
   * @param name          Name of the Option
   * @param defaultValue  the Value that the Option will default to
   * @param comment       Optional Comment (use "null" for no Comment)
   * @param allowedValues All Allowed Values
   */
  public StringOption newStringOption(String name, String defaultValue, @Nullable String comment, String... allowedValues) {
    return newStringOption(name, defaultValue, comment, value -> List.of(allowedValues).contains(value));
  }
  /**
   * @param name         Name of the Option
   * @param defaultValue the Value that the Option will default to
   * @param comment      Optional Comment (use "null" for no Comment)
   */
  public StringOption newStringOption(String name, String defaultValue, @Nullable String comment) {
    return newStringOption(name, defaultValue, comment, value -> true);
  }
  /**
   * @param name         Name of the Option
   * @param defaultValue the Value that the Option will default to
   * @param comment      Optional Comment (use "null" for no Comment)
   * @param validator    Function for additional Validation (like: value > 10 && value < 100 or smth.)
   */
  public StringListOption newStringListOption(String name, List<String> defaultValue, @Nullable String comment, Function<List<String>, Boolean> validator) {
    StringListOption option = new StringListOption(name, defaultValue, comment, validator);
    this.options.add(option);
    return option;
  }
  /**
   * @param name         Name of the Option
   * @param defaultValue the Value that the Option will default to
   * @param comment      Optional Comment (use "null" for no Comment)
   */
  public StringListOption newStringListOption(String name, List<String> defaultValue, @Nullable String comment) {
    return newStringListOption(name, defaultValue, comment, value -> true);
  }
}
