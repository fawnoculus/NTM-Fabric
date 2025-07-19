package net.fawnoculus.ntm.util;

import com.mojang.datafixers.util.Either;
import net.fawnoculus.ntm.NTMConfig;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

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
  
  public static <T> T getOrDefault(Supplier<T> supplier, T orElse){
    try{
      return supplier.get();
    }catch (Throwable throwable){
      return orElse;
    }
  }
  public static <T> Either<T, Throwable> getOrGetException(Supplier<T> supplier){
    try{
      return Either.left(supplier.get());
    }catch (Throwable throwable){
      return Either.right(throwable);
    }
  }
}
