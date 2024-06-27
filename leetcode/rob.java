import java.util.Arrays;

class  rob {
    public static int solve(int n, int[] nums, int[] dp) {
        if (n < 0) { return 0; }
        if (n == 0) { return nums[0]; }
        if (dp[n] != -1) { return dp[n]; }
        
        // Either skip the current house or rob it and add the solution for (n-2)th house
        int robCurrent = nums[n] + solve(n - 2, nums, dp);
        int skipCurrent = solve(n - 1, nums, dp);
        dp[n] = Math.max(robCurrent, skipCurrent);
        
        return dp[n];
    }

    public int rob1(int[] nums) {
        int n = nums.length;
        if (n == 0) { return 0; }
        if (n == 1) { return nums[0]; }
        
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(n - 1, nums, dp);
    }
}
