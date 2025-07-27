package net.fawnoculus.ntm.util;

@FunctionalInterface
public interface QuadConsumer<T, U, V, R> {
  
  /**
   * Performs the operation given the specified arguments.
   *
   * @param k the first input argument
   * @param v the second input argument
   * @param s the third input argument
   */
  void accept(T k, U v, V s, R r);
}
