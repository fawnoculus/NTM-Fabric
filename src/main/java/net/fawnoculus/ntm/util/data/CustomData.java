package net.fawnoculus.ntm.util.data;

import com.google.gson.*;
import net.fawnoculus.ntm.util.JsonUtil;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.function.Function;

public class CustomData {
  public static final String  KEY = "ntm.custom_data";
  
  private final JsonObject Data;
  
  public CustomData(){
    this(new JsonObject());
  }
  public CustomData(String json){
    this(JsonUtil.jsonFromString(json));
  }
  public CustomData(JsonObject json){
    this.Data = json;
  }
  
  public void set(Identifier identifier, String string){
    this.set(identifier, JsonPrimitive::new, string);
  }
  public void set(Identifier identifier, Number number){
    this.set(identifier, JsonPrimitive::new, number);
  }
  public void set(Identifier identifier, Boolean bool){
    this.set(identifier, JsonPrimitive::new, bool);
  }
  public void set(Identifier identifier, JsonElement json){
    this.set(identifier, object -> object, json);
  }
  
  public String getStringOrThrow(Identifier identifier) throws NullPointerException{
    return Objects.requireNonNull(this.get(identifier)).getAsJsonPrimitive().getAsString();
  }
  public Integer getIntOrThrow(Identifier identifier) throws NullPointerException{
    return Objects.requireNonNull(this.get(identifier)).getAsJsonPrimitive().getAsInt();
  }
  public Float getFloatOrThrow(Identifier identifier) throws NullPointerException{
    return Objects.requireNonNull(this.get(identifier)).getAsJsonPrimitive().getAsFloat();
  }
  public Double getDoubleOrThrow(Identifier identifier) throws NullPointerException{
    return Objects.requireNonNull(this.get(identifier)).getAsJsonPrimitive().getAsDouble();
  }
  public Boolean getBoolOrThrow(Identifier identifier) throws NullPointerException{
    return Objects.requireNonNull(this.get(identifier)).getAsJsonPrimitive().getAsBoolean();
  }
  public JsonObject getJsonOrThrow(Identifier identifier) throws NullPointerException{
    return Objects.requireNonNull(this.get(identifier)).getAsJsonObject();
  }
  
  public String getOrDefaultString(Identifier identifier, String val){
    try{
      return getStringOrThrow(identifier);
    }catch (NullPointerException exception){
      return val;
    }
  }
  public Integer getOrDefaultInt(Identifier identifier, Integer val){
    try{
      return getIntOrThrow(identifier);
    }catch (NullPointerException exception){
      return val;
    }
  }
  public Float getOrDefaultFloat(Identifier identifier, Float val){
    try{
      return getFloatOrThrow(identifier);
    }catch (NullPointerException exception){
      return val;
    }
  }
  public Double getOrDefaultDouble(Identifier identifier, Double val){
    try{
      return getDoubleOrThrow(identifier);
    }catch (NullPointerException exception){
      return val;
    }
  }
  public Boolean getOrDefaultBool(Identifier identifier, Boolean val){
    try{
      return getBoolOrThrow(identifier);
    }catch (NullPointerException exception){
      return val;
    }
  }
  public JsonObject getOrDefaultJson(Identifier identifier, JsonObject val){
    try{
      return getJsonOrThrow(identifier);
    }catch (NullPointerException exception){
      return val;
    }
  }
  
  public <T> void set(Identifier identifier, Function<T, JsonElement> serializer, T object){
    Data.add(identifier.toString(), serializer.apply(object));
  }
  @Nullable JsonElement get(Identifier identifier){
    return Data.get(identifier.toString());
  }
  
  public JsonObject getData(){
    return this.Data;
  }
  public String getDataAsString(){
    return this.Data.toString();
  }
}
