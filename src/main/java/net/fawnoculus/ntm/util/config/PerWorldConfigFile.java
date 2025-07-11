package net.fawnoculus.ntm.util.config;

import net.fawnoculus.ntm.util.config.options.*;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PerWorldConfigFile extends ConfigFile{
  public PerWorldConfigFile(String defaultSubPath, String WorldSubPath, ConfigFileType configFileType, @Nullable Logger logger) {
    super(defaultSubPath, configFileType, logger);
    
    if (WorldSubPath.endsWith(configFileType.getFileExtension())) {
      this.SUB_PATH = WorldSubPath;
    } else {
      this.SUB_PATH = WorldSubPath + configFileType.getFileExtension();
    }
    
    perWorldConfigFiles.add(this);
  }
  
  private static final List<PerWorldConfigFile> perWorldConfigFiles = new ArrayList<>();
  private final String SUB_PATH;
  private final HashMap<Option<?>, Option<?>> PER_WORLD_TO_REGULAR = new HashMap<>();
  private final HashMap<Option<?>, Option<?>> REGULAR_TO_PER_WORLD = new HashMap<>();
  private List<Option<?>> perWorldOptions = new ArrayList<>();
  private File perWorldConfigFile;
  private boolean hasActiveFile = false;
  
  public static List<PerWorldConfigFile> getPerWorldConfigFiles(){
    return List.copyOf(perWorldConfigFiles);
  }
  
  public void setConfigPath(Path worldSavePath){
    this.perWorldConfigFile = new File(worldSavePath.resolve(this.SUB_PATH).toUri());
    this.hasActiveFile = true;
    this.writeFile();
  }
  
  public void removeConfigPath(){
    this.perWorldConfigFile = null;
    this.hasActiveFile = false;
    for(Option<?> option : this.getAllOptions()){
      option.resetToDefault();
    }
  }
  
  @Override
  public void writeFile() {
    // Write the default options
    super.writeFile();
    if(!this.hasActiveFile) return;
    
    // Write the per World options
    try {
      if (!perWorldConfigFile.exists()) {
        boolean ignored = perWorldConfigFile.getParentFile().mkdirs();
        boolean newFile = perWorldConfigFile.createNewFile();
        if (newFile) {
          LOGGER.info("Created new per World Config File: {}", perWorldConfigFile.getPath());
        } else {
          LOGGER.warn("Failed to create per World Config File: {}", perWorldConfigFile.getPath());
        }
      } else {
        boolean delete = perWorldConfigFile.delete();
        if (!delete) {
          LOGGER.warn("Failed to delete old per World Config File: {}", perWorldConfigFile.getPath());
        }
      }
      
      this.CONFIG_FILE_TYPE.writeFile(perWorldConfigFile, this.LOGGER, this.perWorldOptions);
    } catch (Exception exception) {
      LOGGER.error("Failed to write to per World Config File: {} \n Exception: {}", perWorldConfigFile.getPath(), exception);
    }
  }
  
  @Override
  public void readFile() {
    // Read the default options and update the Defaults
    super.readFile();
    for(Option<?> defaultOption : this.options){
      Option<?> perWorldOption = REGULAR_TO_PER_WORLD.get(defaultOption);
      perWorldOption.castAndOverwriteDefault(defaultOption.getValue());
    }
    if(!this.hasActiveFile) return;
    
    // Read the per World Options
    List<Option<?>> readOptions = this.perWorldOptions;
    
    try {
      readOptions = this.CONFIG_FILE_TYPE.readFile(perWorldConfigFile, this.LOGGER, this.perWorldOptions);
    } catch (Exception exception) {
      LOGGER.error("Failed to read from per World Config File: {} \n Exception: {}", perWorldConfigFile.getPath(), exception);
    }
    
    this.perWorldOptions = readOptions;
  }
  
  public List<Option<?>> getAllPerWorldOptions() {
    return List.copyOf(this.perWorldOptions);
  }
  
  // Overwriting option creation to return the per world option
  
  
  @Override
  protected void addAndValidateOption(Option<?> option) {
    throw new IllegalArgumentException("This is a per world config, please use the appropriate 'addAndValidateOption' method");
  }
  
  protected void addAndValidateOption(Option<?> defaultOption, Option<?> perWorldOption) {
    String name = defaultOption.NAME;
    if(!name.equals(perWorldOption.NAME)) throw new IllegalStateException("default & perWorld option do not have the same name!");
    
    if (!CONFIG_FILE_TYPE.isValidOption(defaultOption) && !CONFIG_FILE_TYPE.isValidOption(perWorldOption))
      throw new IllegalArgumentException("Option with name '" + name + "' is not valid for Config Type '" + CONFIG_FILE_TYPE.getClass().getName() + "'");
    if (OPTION_NAMES.contains(name))
      throw new IllegalArgumentException("Option with name '" + name + "' already exist in perWorld Config File '" + SUB_PATH + "'");
    
    this.OPTION_NAMES.add(name);
    this.options.add(defaultOption);
    this.perWorldOptions.add(perWorldOption);
    this.PER_WORLD_TO_REGULAR.put(perWorldOption, defaultOption);
    this.REGULAR_TO_PER_WORLD.put(defaultOption, perWorldOption);
  }
  
  @Override
  public BooleanOption newBooleanOption(String name, Boolean defaultValue, @Nullable String comment, Option.ExtraType extraType) {
    if (comment != null) comment += " [Default: " + defaultValue + "]";
    
    BooleanOption defaultOption = new BooleanOption(this, name, defaultValue, comment);
    BooleanOption perWorldOption = new BooleanOption(this, name, defaultValue, comment);
    defaultOption.setExtraType(extraType);
    perWorldOption.setExtraType(extraType);
    addAndValidateOption(defaultOption, perWorldOption);
    return perWorldOption;
  }
  
  @Override
  public DoubleOption newDoubleOption(String name, Double defaultValue, @Nullable String comment, Option.ExtraType extraType) {
    if (comment != null) comment += " [Default: " + defaultValue + "]";
    
    DoubleOption defaultOption = new DoubleOption(this, name, defaultValue, comment);
    DoubleOption perWorldOption = new DoubleOption(this, name, defaultValue, comment);
    defaultOption.setExtraType(extraType);
    perWorldOption.setExtraType(extraType);
    addAndValidateOption(defaultOption, perWorldOption);
    return perWorldOption;
  }
  
  @Override
  public FloatOption newFloatOption(String name, Float defaultValue, @Nullable String comment, Option.ExtraType extraType) {
    if (comment != null) comment += " [Default: " + defaultValue + "]";
    
    FloatOption defaultOption = new FloatOption(this, name, defaultValue, comment);
    FloatOption perWorldOption = new FloatOption(this, name, defaultValue, comment);
    defaultOption.setExtraType(extraType);
    perWorldOption.setExtraType(extraType);
    addAndValidateOption(defaultOption, perWorldOption);
    return perWorldOption;
  }
  
  @Override
  public IntegerOption newIntegerOption(String name, Integer defaultValue, @Nullable String comment, Option.ExtraType extraType) {
    if (comment != null) comment += " [Default: " + defaultValue + "]";
    
    IntegerOption defaultOption = new IntegerOption(this, name, defaultValue, comment);
    IntegerOption perWorldOption = new IntegerOption(this, name, defaultValue, comment);
    defaultOption.setExtraType(extraType);
    perWorldOption.setExtraType(extraType);
    addAndValidateOption(defaultOption, perWorldOption);
    return perWorldOption;
  }
  
  @Override
  public StringOption newStringOption(String name, String defaultValue, @Nullable String comment, Option.ExtraType extraType) {
    if (comment != null) comment += " [Default: " + defaultValue + "]";
    
    StringOption defaultOption = new StringOption(this, name, defaultValue, comment);
    StringOption perWorldOption = new StringOption(this, name, defaultValue, comment);
    defaultOption.setExtraType(extraType);
    perWorldOption.setExtraType(extraType);
    addAndValidateOption(defaultOption, perWorldOption);
    return perWorldOption;
  }
  
  @Override
  public StringListOption newStringListOption(String name, List<String> defaultValue, @Nullable String comment, Option.ExtraType extraType) {
    if (comment != null) comment += " [Default: " + defaultValue + "]";
    
    StringListOption defaultOption = new StringListOption(this, name, defaultValue, comment);
    StringListOption perWorldOption = new StringListOption(this, name, defaultValue, comment);
    defaultOption.setExtraType(extraType);
    perWorldOption.setExtraType(extraType);
    addAndValidateOption(defaultOption, perWorldOption);
    return perWorldOption;
  }
}
