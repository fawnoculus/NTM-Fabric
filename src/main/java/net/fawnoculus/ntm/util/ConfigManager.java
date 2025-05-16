package net.fawnoculus.ntm.util;

// TODO: make this BS work

//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.File;
//import java.io.Serializable;
//import java.util.List;
//import java.util.function.Function;
//
//public class ConfigManager {
//  public static class ConfigFile{
//    private final File FILE;
//    private final Logger LOGGER;
//    ConfigFile(String fileName, @Nullable Logger logger, Option... options){
//      this.LOGGER = logger != null ? logger : LoggerFactory.getLogger("Config/" + fileName);
//
//      String filePath = "config/" + fileName + ".json";
//
//      File file = new File(filePath);
//      if(!file.exists()){
//        try {
//          file.createNewFile();
//        }catch (Exception exception){
//          LOGGER.warn("failed to create config file \n", exception);
//        }
//      }
//      this.FILE = file;
//      if(!file.canRead()){
//        LOGGER.warn("can't read config file: " + filePath);
//      } else {
//
//      }
//      if(!file.canWrite()){
//        LOGGER.warn("can't write to config file: " + filePath);
//      } else {
//
//      }
//    }
//    private List<Option> readConfigFile(){
//      return List.of();
//    }
//
//    /**
//     * @return whether the config file was able to save or not
//     **/
//    private boolean writeConfigFile(){
//      try {
//        // Write to the file
//        return true;
//      } catch (Exception ignored) {}
//
//      return false;
//    }
//  }
//  public abstract class Option {
//    public final String NAMESPACE;
//    public final String NAME;
//    public final ValueType VALUE_TYPE;
//    public final Serializable DEFAULT_VALUE;
//    public final Function<Serializable, Boolean> VALUE_CHECKER;
//    public final Function<Serializable, Boolean> TYPE_VERIFYER;
//
//    public Serializable value;
//
//    Option(String nameSpace, String name, ValueType valueType, Serializable defaultValue, Function<Serializable, Boolean> valueChecker){
//      this.NAMESPACE = nameSpace;
//      this.NAME = name;
//      this.VALUE_TYPE = valueType;
//      this.DEFAULT_VALUE = defaultValue;
//      this.VALUE_CHECKER = valueChecker;
//      this.TYPE_VERIFYER = valueType.validator;
//    }
//    Option(String nameSpace, String name, ValueType valueType, Serializable defaultValue, @NotNull Serializable... values){
//      this.NAMESPACE = nameSpace;
//      this.NAME = name;
//      this.VALUE_TYPE = valueType;
//      this.DEFAULT_VALUE = defaultValue;
//
//      // Sanity Check
//      for (Serializable value : values){
//        if(!valueType.validator.apply(value)){
//          throw new IllegalArgumentException("Allowed Value is not of given ValueType");
//        }
//      }
//
//      List<Serializable> allowedValues = List.of(values);
//      this.VALUE_CHECKER = allowedValues::contains;
//    }
//    Option(String nameSpace, String name, ValueType valueType, Serializable defaultValue){
//      this.NAMESPACE = nameSpace;
//      this.NAME = name;
//      this.VALUE_TYPE = valueType;
//      this.DEFAULT_VALUE = defaultValue;
//      this.VALUE_CHECKER = value -> true; // Allow all Values
//    }
//
//    public Serializable getValue(){
//      return this.value != null ? this.value : this.DEFAULT_VALUE;
//    }
//
//    /**
//     * @param value (value you are trying to set)
//     * @return whether the Value was Valid
//     */
//    public boolean setValue(Serializable value){
//      if(!isValidValue(value)){
//        return false;
//      }
//      this.value = value;
//      return true;
//    }
//    private boolean isValidValue(Serializable value){
//      return this.VALUE_CHECKER.apply(value) && this.VALUE_TYPE.isValidValue(value);
//    }
//  }
//
//  public static class ValueType{
//    // Default Value Types
//    public static ValueType BOOLEAN = new ValueType(value -> value instanceof Boolean);
//    public static ValueType INTIGER = new ValueType(value -> value instanceof Integer);
//    public static ValueType FLOAT = new ValueType(value -> value instanceof Float);
//    public static ValueType DOUBLE = new ValueType(value -> value instanceof Double);
//    public static ValueType STRING = new ValueType(value -> value instanceof String);
//
//    private final Function<Serializable, Boolean>  validator;
//
//    ValueType(Function<Serializable, Boolean> validator){
//      this.validator = validator;
//    }
//
//    public boolean isValidValue(Serializable value){
//      return this.validator.apply(value);
//    }
//  }
//}