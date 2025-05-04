package net.fawnoculus.ntm.util;

import org.apache.commons.io.function.IOFunction;
import org.apache.commons.io.function.IOQuadFunction;

import java.util.Objects;

// Functional programing in Java be like

@FunctionalInterface
public interface QuadFunction<T, U, V, W, R> {
  
  R apply(T t, U u, V v, W w);
  
  default <X> IOQuadFunction<T, U, V, W, X> andThen(final IOFunction<? super R, ? extends X> after) {
    Objects.requireNonNull(after);
    return (final T t, final U u, final V v, final W w) -> after.apply(apply(t, u, v, w));
  }
}
