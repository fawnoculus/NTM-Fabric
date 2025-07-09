package net.fawnoculus.ntm.util;

import net.fawnoculus.ntm.main.NTMConfig;

public class ExceptionUtil {
  public static String makePretty(Throwable throwable){
    StringBuilder Exception = new StringBuilder(throwable.toString());
    
    if(NTMConfig.PrintStackTrace.getValue()){
      for(StackTraceElement element : throwable.getStackTrace()){
        Exception.append("\n\t").append(element);
      }
    }
    
    return Exception.toString();
  }
}
