import java.util.Arrays;

public class make_array_unique {
     public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        
        int moves = 0;
        
        // Iterate through the sorted array
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                // Calculate the needed increment
                int increment = nums[i - 1] + 1 - nums[i];
                nums[i] += increment;
                moves += increment;
            }
        }
        
        return moves;
    }
}
