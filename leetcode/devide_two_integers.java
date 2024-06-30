public class devide_two_integers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
           throw new IllegalArgumentException("Cannot divide by zero");
       }
       
       // Handle overflow case
       if (dividend == Integer.MIN_VALUE && divisor == -1) {
           return Integer.MAX_VALUE;
       }
       
       // Determine sign of the quotient
       boolean isNegative = (dividend < 0) ^ (divisor < 0);
       
       // Work with positive numbers
       long absDividend = Math.abs((long) dividend);
       long absDivisor = Math.abs((long) divisor);
       
       // Initialize result
       long quotient = 0;
       
       // Bitwise division
       for (int i = 31; i >= 0; i--) {
           if ((absDividend >> i) >= absDivisor) { // Check if absDividend >= absDivisor << i
               // If true, subtract absDivisor << i from absDividend
               quotient += (1L << i); // Add 2^i to quotient
               absDividend -= (absDivisor << i); // Subtract absDivisor << i from absDividend
           }
       }
       
       // Adjust sign
       if (isNegative) {
           quotient = -quotient;
       }
       
       // Return int value, handle overflow
       if (quotient > Integer.MAX_VALUE) {
           return Integer.MAX_VALUE;
       } else if (quotient < Integer.MIN_VALUE) {
           return Integer.MIN_VALUE;
       } else {
           return (int) quotient;
       }
   }
}
