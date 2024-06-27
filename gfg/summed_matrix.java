public class summed_matrix {
    static long sumMatrix(long n, long q) {
        long min_i = Math.max(1, q - n);
      long max_i = Math.min(n, q - 1);

      // Calculate the number of valid i values
      long count = Math.max(0, max_i - min_i + 1);

      return count;
  }
}
