public class min_operation_to_make_binary_operation_one {
    public int minOperations(int[] nums) {
        int op = 0;  // Operation counter
        int start = 0;
        
        while (start < nums.length) {
            if (nums[start] == 0 && start + 2 < nums.length) {
                // Flip the three consecutive elements
                nums[start] = 1 - nums[start];
                nums[start + 1] = 1 - nums[start + 1];
                nums[start + 2] = 1 - nums[start + 2];
                op++;  // Increment the operation counter
            }
            start++;
        }
        
        // Check if there are any zeros left in the array
        for (int num : nums) {
            if (num == 0) {
                return -1;  // If there's a zero left, it's impossible to make all elements 1
            }
        }
        
        return op;  // Return the number of operations performed
    }
}
