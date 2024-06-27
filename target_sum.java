public class target_sum {
    public static int targetsum(int[] nums, int index, int target) {
        // Base case: if we have processed all elements
        if (index == nums.length) {
            return target == 0 ? 1 : 0; // If target is achieved, return 1 else 0
        }

        // Include the current number with a positive sign and a negative sign
        int add = targetsum(nums, index + 1, target - nums[index]);
        int subtract = targetsum(nums, index + 1, target + nums[index]);

        // Total number of ways
        return add + subtract;
    }

    public int findTargetSumWays(int[] nums, int target) {
        return targetsum(nums, 0, target);
    }
}
