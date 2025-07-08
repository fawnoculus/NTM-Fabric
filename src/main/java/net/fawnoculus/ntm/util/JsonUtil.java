package net.fawnoculus.ntm.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import java.io.StringReader;

public class JsonUtil {
  private static final Gson gson = new GsonBuilder().disableHtmlEscaping().create();
  
  public static JsonObject jsonFromString(String string){
    JsonReader jsonReader = new JsonReader(new StringReader(string));
    return gson.fromJson(jsonReader, JsonObject.class);
  }
}
