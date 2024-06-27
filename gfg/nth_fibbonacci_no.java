public class nth_fibbonacci_no {
    static final int MOD = 1000000007;

    static int nthFibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        return dp[n];
    }
}
