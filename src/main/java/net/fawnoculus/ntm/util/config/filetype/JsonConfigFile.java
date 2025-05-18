package net.fawnoculus.ntm.util.config.filetype;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonSyntaxException;
import com.google.gson.JsonElement;
import com.google.gson.stream.JsonReader;
import net.fawnoculus.ntm.util.config.ConfigFileType;
import net.fawnoculus.ntm.util.config.Option;
import net.fawnoculus.ntm.util.config.options.*;
import org.slf4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class JsonConfigFile implements ConfigFileType {
  @Override
  public String getFileExtension() {
    return ".json";
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
        || string.contains("\"");
  }
  
  @Override
  public List<Option<?>> readFile(File configFile, Logger LOGGER, List<Option<?>> expectedOptions) {
    Gson gson = new Gson();
    JsonObject jsonObject;
    try {
      JsonReader jsonReader = new JsonReader(new FileReader(configFile));
      jsonObject = gson.fromJson(jsonReader, JsonObject.class);
      if (!jsonObject.isJsonObject()) {
        throw new JsonSyntaxException("What the hell did you do to the Json File?!");
      }
    } catch (Exception exception) {
      LOGGER.error("Failed to Parse Json Config File '{}' \n Exception: {}", configFile.getPath(), exception);
      return expectedOptions;
    }
    
    // Setting Option Values to the read Values
    for (Option<?> option : expectedOptions) {
      JsonElement readValue = jsonObject.get(option.NAME);
      if (readValue == null || !readValue.isJsonPrimitive()) {
        LOGGER.warn("Didn't find option '{}' of type '{}' in Config File '{}', using default value", option.NAME, option.getClass(), configFile.getPath());
        continue;
      }
      switch (option) {
        case BooleanOption booleanOption -> {
          try {
            booleanOption.setValue(readValue.getAsBoolean());
          } catch (Exception ignored) {
            LOGGER.warn("Option '{}' of type '{}' in Config File '{}' is not of type Boolean, using Default Value", option.NAME, option.getClass(), configFile.getPath());
          }
        }
        case DoubleOption doubleOption -> {
          try {
            doubleOption.setValue(readValue.getAsDouble());
          } catch (Exception ignored) {
            LOGGER.warn("Option '{}' of type '{}' in Config File '{}' is not of type Double, using Default Value", option.NAME, option.getClass(), configFile.getPath());
          }
        }
        case FloatOption floatOption -> {
          try {
            floatOption.setValue(readValue.getAsFloat());
          } catch (Exception ignored) {
            LOGGER.warn("Option '{}' of type '{}' in Config File '{}' is not of type Float, using Default Value", option.NAME, option.getClass(), configFile.getPath());
          }
        }
        case IntegerOption integerOption -> {
          try {
            integerOption.setValue(readValue.getAsInt());
          } catch (Exception ignored) {
            LOGGER.warn("Option '{}' of type '{}' in Config File '{}' is not of type Integer, using Default Value", option.NAME, option.getClass(), configFile.getPath());
          }
        }
        case StringOption stringOption -> {
          try {
            stringOption.setValue(readValue.getAsString());
          } catch (Exception ignored) {
            LOGGER.warn("Option '{}' of type '{}' in Config File '{}' is not of type String, using Default Value", option.NAME, option.getClass(), configFile.getPath());
          }
        }
        case StringListOption stringListOption -> {
          try {
            JsonArray jsonArray = readValue.getAsJsonArray();
            List<String> strings = new LinkedList<>();
            for (JsonElement object : jsonArray) {
              strings.add(object.getAsString());
            }
            stringListOption.setValue(strings);
          } catch (Exception ignored) {
            LOGGER.warn("Option '{}' of type '{}' in Config File '{}' is not of type StringArray, using Default Value", option.NAME, option.getClass(), configFile.getPath());
          }
        }
        default -> {
          LOGGER.error("Tried to read Option with unknown Option Type: {}", option.getClass());
          LOGGER.error("To whichever Developer did this, don't forget to add write & read methods for your option type when you add them!");
        }
      }
    }
    return expectedOptions;
  }
  
  @Override
  public void writeFile(File configFile, Logger LOGGER, List<Option<?>> options) throws IOException {
    FileWriter writer = new FileWriter(configFile);
    
    writer.write("{\n");
    for (int i = 0; i < options.size(); i++) {
      Option<?> option = options.get(i);
      writeOption(writer, LOGGER, option, i == options.size() - 1);
    }
    writer.write("\n}");
    writer.flush();
    writer.close();
  }
  private void writeOption(FileWriter writer, Logger LOGGER, Option<?> option, boolean lastOption) throws IOException {
    String suffix = ",";
    if(lastOption) suffix = "";
    
    switch (option) {
      case BooleanOption booleanOption -> writer.write(String.format("\t\"%s\": %b%s\n", option.NAME, booleanOption.getValue(), suffix));
      case DoubleOption doubleOption -> writer.write(String.format("\t\"%s\": %f%s\n", option.NAME, doubleOption.getValue(), suffix));
      case FloatOption floatOption -> writer.write(String.format("\t\"%s\": %f%s\n", option.NAME, floatOption.getValue(), suffix));
      case IntegerOption integerOption -> writer.write(String.format("\t\"%s\": %d%s\n", option.NAME, integerOption.getValue(), suffix));
      case StringOption stringOption -> writer.write(String.format("\t\"%s\": %b%s\n", option.NAME, stringOption.getValue(), suffix));
      case StringListOption stringListOption -> {
        writer.write(String.format("\t\"%s\": [\n", option.NAME));
        String[] strings = stringListOption.getValue().toArray(new String[0]);
        for (int i = 0; i < strings.length ; i++) {
          // Last String
          if(i == strings.length - 1){
            writer.write(String.format("\t\t\"%s\"", strings[i]));
          }
          // All other Strings
          writer.write(String.format("\t\t\"%s\",", strings[i]));
        }
        writer.write(String.format("\t]%s\n", suffix));
      }
      default -> {
        LOGGER.error("Tried to write Option with unknown Option Type: {}", option.getClass());
        LOGGER.error("To whichever Developer did this, don't forget to add write & read methods for your option type when you add them!");
      }
    }
    
  }
}
