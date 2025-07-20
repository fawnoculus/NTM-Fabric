package net.fawnoculus.ntm.util;

import net.fawnoculus.ntm.NTMConfig;
import org.jetbrains.annotations.NotNull;

public class ExceptionUtil {
  public static @NotNull String makePretty(@NotNull Throwable throwable){
    return makePretty(throwable, NTMConfig.PrintStackTrace.getValue());
  }
  public static @NotNull String makePretty(@NotNull Throwable throwable, boolean stacktrace){
    StringBuilder Exception = new StringBuilder(throwable.toString());
    
    if(stacktrace){
      for(StackTraceElement element : throwable.getStackTrace()){
        Exception.append("\n\t").append(element);
      }
    }
    
    return Exception.toString();
  }
}
