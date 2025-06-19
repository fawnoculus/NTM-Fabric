package net.fawnoculus.ntm.util.messages;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Environment(EnvType.CLIENT)
public class MessageSystem {
  private static final List<AdvancedMessage> ALL_MESSAGES = new ArrayList<>();
  private static final HashMap<String, AdvancedMessage> MESSAGE_HASH_MAP = new HashMap<>();
  
  public static void addMessage(AdvancedMessage message){
    Identifier identifier = message.getID();
    removeMessage(identifier);
    ALL_MESSAGES.add(message);
    MESSAGE_HASH_MAP.put(identifier.toString(), message);
  }
  
  private static void removeMessage(AdvancedMessage message){
    ALL_MESSAGES.remove(message);
    MESSAGE_HASH_MAP.remove(message.getID().toString());
  }
  public static void removeMessage(Identifier identifier){
    if(MESSAGE_HASH_MAP.containsKey(identifier.toString())){
      removeMessage(getMessage(identifier));
    }
  }
  public static void removeAllMessages(){
    ALL_MESSAGES.clear();
    MESSAGE_HASH_MAP.clear();
  }
  
  public static AdvancedMessage getMessage(Identifier identifier){
    return MESSAGE_HASH_MAP.get(identifier.toString());
  }
  
  public static List<AdvancedMessage> getAllMessages(){
    return ALL_MESSAGES;
  }
}
