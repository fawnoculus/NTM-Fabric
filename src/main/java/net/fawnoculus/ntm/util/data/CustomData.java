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
  
  void set(Identifier identifier, String string){
    this.set(identifier, object -> new JsonPrimitive(object).getAsJsonObject(), string);
  }
  void set(Identifier identifier, Number number){
    this.set(identifier, object -> new JsonPrimitive(object).getAsJsonObject(), number);
  }
  void set(Identifier identifier, Boolean bool){
    this.set(identifier, object -> new JsonPrimitive(object).getAsJsonObject(), bool);
  }
  void set(Identifier identifier, JsonObject json){
    this.set(identifier, object -> object, json);
  }
  
  String getStringOrThrow(Identifier identifier) throws NullPointerException{
    return Objects.requireNonNull(this.get(identifier)).getAsJsonPrimitive().getAsString();
  }
  Integer getIntOrThrow(Identifier identifier) throws NullPointerException{
    return Objects.requireNonNull(this.get(identifier)).getAsJsonPrimitive().getAsInt();
  }
  Float getFloatOrThrow(Identifier identifier) throws NullPointerException{
    return Objects.requireNonNull(this.get(identifier)).getAsJsonPrimitive().getAsFloat();
  }
  Double getDoubleOrThrow(Identifier identifier) throws NullPointerException{
    return Objects.requireNonNull(this.get(identifier)).getAsJsonPrimitive().getAsDouble();
  }
  Boolean getBoolOrThrow(Identifier identifier) throws NullPointerException{
    return Objects.requireNonNull(this.get(identifier)).getAsJsonPrimitive().getAsBoolean();
  }
  JsonObject getJsonOrThrow(Identifier identifier) throws NullPointerException{
    return Objects.requireNonNull(this.get(identifier)).getAsJsonObject();
  }
  
  String getOrDefaultString(Identifier identifier, String val){
    try{
      return getStringOrThrow(identifier);
    }catch (NullPointerException exception){
      return val;
    }
  }
  Integer getOrDefaultInt(Identifier identifier, Integer val){
    try{
      return getIntOrThrow(identifier);
    }catch (NullPointerException exception){
      return val;
    }
  }
  Float getOrDefaultFloat(Identifier identifier, Float val){
    try{
      return getFloatOrThrow(identifier);
    }catch (NullPointerException exception){
      return val;
    }
  }
  Double getOrDefaultDouble(Identifier identifier, Double val){
    try{
      return getDoubleOrThrow(identifier);
    }catch (NullPointerException exception){
      return val;
    }
  }
  Boolean getOrDefaultBool(Identifier identifier, Boolean val){
    try{
      return getBoolOrThrow(identifier);
    }catch (NullPointerException exception){
      return val;
    }
  }
  JsonObject getOrDefaultJson(Identifier identifier, JsonObject val){
    try{
      return getJsonOrThrow(identifier);
    }catch (NullPointerException exception){
      return val;
    }
  }
  
  <T> void set(Identifier identifier, Function<T, JsonObject> serializer, T object){
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
