
import java.util.Arrays;

public class house_robber_2 {
    private int robLinear(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        
        return dp[n - 1];
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        
        return Math.max(robLinear(Arrays.copyOfRange(nums, 0, n - 1)), robLinear(Arrays.copyOfRange(nums, 1, n)));
    }
}
