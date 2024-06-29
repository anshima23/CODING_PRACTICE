public class perfect_sum_problem {
    static int MOD = 1000000007;

    public static int perfectSum(int[] arr, int n, int sum) {
        int[][] dp = new int[n + 1][sum + 1];

        // There is one subset (empty subset) for sum = 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    // Include the current element or exclude it
                    dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - arr[i - 1]]) % MOD;
                } else {
                    // Exclude the current element
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }
}
