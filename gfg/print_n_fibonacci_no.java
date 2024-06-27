public class print_n_fibonacci_no {
    public static long[] printFibb(int n) 
    {
         long[] dp = new long[n];
        
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == 1) { dp[i] = 1;}
            else {dp[i] = dp[i - 1] + dp[i - 2];}
        }
        return dp;
    }
}
