package net.fawnoculus.ntm.util;

import org.jetbrains.annotations.Nullable;

import java.util.Locale;

public enum OS {
  WINDOWS("windows"),
  LINUX("linux"),
  MAC_OS("mac"),
  OTHER((String) null);
    
  @Nullable
  private final String detectWith;
    
  OS(@Nullable String detectWith) {
    this.detectWith = detectWith;
  }
    
  public static OS getOS() {
    String test = System.getProperty("os.name").toLowerCase(Locale.ROOT);
    
    for (OS value : values()) {
      if (value.detectWith != null && test.contains(value.detectWith)) {
        return value;
      }
    }
    
    return OTHER;
  }
  
  public static String getUserName() {
    return System.getProperty("user.name");
  }
}