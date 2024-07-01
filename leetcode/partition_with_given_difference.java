public class partition_with_given_difference {
      
    static int MOD = 1000000007;

    public static int countPartitions(int n, int d, int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        // If (sum + d) is odd or if (sum < d), return 0
        if ((sum + d) % 2 != 0 || sum < d) {
            return 0;
        }

        int target = (sum + d) / 2;

        // DP array initialization
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1; // There's one way to get a sum of 0, by choosing no elements
        }

        // Fill the DP array
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i-1][j]; // Exclude the current element
                if (j >= arr[i-1]) {
                    dp[i][j] = (dp[i][j] + dp[i-1][j - arr[i-1]]) % MOD; // Include the current element
                }
            }
        }

        return dp[n][target];
    }
}
