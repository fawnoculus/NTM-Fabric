package net.fawnoculus.ntm.util.config;


import net.fawnoculus.ntm.util.config.options.*;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ConfigFile {
  private List<Option<?>> options = new ArrayList<>();
  private Boolean initialized = false;
  
  public final ConfigFileType CONFIG_FILE_TYPE;
  
  private final File CONFIG_FILE;
  private final Logger LOGGER;
  private final List<String> optionNames = new ArrayList<>();
  
  ConfigFile(String path, ConfigFileType configFileType, @Nullable Logger logger){
    this.CONFIG_FILE_TYPE = configFileType;
    this.LOGGER = logger != null ? logger : LoggerFactory.getLogger("FawnConfigUtil");
    
    if(path.endsWith(configFileType.getFileExtension())){
      this.CONFIG_FILE = new File(path);
    }else {
      this.CONFIG_FILE = new File(path + configFileType.getFileExtension());
    }
  }
  
  /**
   * @return whether the Config is Missing any Options (aka whether to rewrite the Config)
   */
  public boolean readFile(){
    List<Option<?>> readOptions = this.options;
    
    try {
      readOptions = this.CONFIG_FILE_TYPE.readFile(CONFIG_FILE, this.LOGGER, this.options);
    } catch(Exception exception) {
      LOGGER.error("Failed to read from Config File: {} \n Exception: {}", CONFIG_FILE.getPath(), exception);
    }
    
    boolean valuesChanged = false;
    
    for (int i = 0; i < this.options.size(); i++) {
      Option<?> previousOption = this.options.get(i);
      Option<?> newOption = readOptions.get(i);
      
      if(previousOption.getValue() != newOption.getValue()) valuesChanged = true;
    }
    
    this.options = readOptions;
    return valuesChanged;
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
      
      this.CONFIG_FILE_TYPE.writeFile(CONFIG_FILE, this.LOGGER, this.options);
    } catch(Exception exception) {
      LOGGER.error("Failed to write to Config File: {} \n Exception: {}", CONFIG_FILE.getPath(), exception);
    }
  }
  
  public void initialize(){
    if(initialized){
      throw new RuntimeException("Config File already Initialized");
    }
    if(!CONFIG_FILE.exists()) writeFile();
    
    boolean shouldWrite = readFile();
    if(shouldWrite) writeFile();
    
    initialized = true;
  }
  
  // Everything bellow is just for getting new Options for a Config File //
  
  private void addAndValidateOption(Option<?> option){
    String name = option.NAME;
    
    if(CONFIG_FILE_TYPE.isValidOption(option)) throw new IllegalArgumentException("Option with name '" + name + "' is not valid for Config Type '"+ CONFIG_FILE_TYPE.getClass() +"'");
    if(optionNames.contains(name)) throw new IllegalArgumentException("Option with name '" + name + "' already exist in Config File '"+ CONFIG_FILE.getPath() +"'");
    
    this.optionNames.add(name);
    this.options.add(option);
  }
  
  /**
   * @param name         Name of the Option
   * @param defaultValue the Value that the Option will default to
   * @param comment      Optional Comment (use "null" for no Comment)
   * @param validator    Function for additional Validation (like: value > 10 && value < 100 or smth.)
   */
  public BooleanOption newBooleanOption(String name, Boolean defaultValue, @Nullable String comment, Function<Boolean, Boolean> validator) {
    BooleanOption option = new BooleanOption(this, name, defaultValue, comment, validator);
    addAndValidateOption(option);
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
    DoubleOption option = new DoubleOption(this, name, defaultValue, comment, validator);
    addAndValidateOption(option);
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
    FloatOption option = new FloatOption(this, name, defaultValue, comment, validator);
    addAndValidateOption(option);
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
    IntegerOption option = new IntegerOption(this, name, defaultValue, comment, validator);
    addAndValidateOption(option);
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
    StringOption option = new StringOption(this, name, defaultValue, comment, validator);
    addAndValidateOption(option);
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
    StringListOption option = new StringListOption(this, name, defaultValue, comment, validator);
    addAndValidateOption(option);
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
