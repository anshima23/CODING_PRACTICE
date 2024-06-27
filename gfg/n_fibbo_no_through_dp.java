import java.util.Arrays;

public class n_fibbo_no_through_dp {
    public static long find(int n, long[] dp) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = find(n - 1, dp) + find(n - 2, dp);
    }

    
    
    //Function to return list containing first n fibonacci numbers.
    public static long[] printFibb(int n) 
    {
         if (n == 1) {
            return new long[]{1};
        }
        
        long[] dp = new long[n];
        Arrays.fill(dp, -1);
        dp[0]=1;
        dp[1]=1;
        find(n - 1, dp);
        return dp;
    }
}
