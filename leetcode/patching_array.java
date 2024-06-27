public class patching_array {
    public int minPatches(int[] nums, int n) {
        long miss = 1; // The smallest number that cannot be formed
        int patches = 0; // Number of patches added
        
        int i = 0;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i]; // Extend coverage to include nums[i]
                i++;
            } else {
                // Add patch for miss
                miss += miss; // Add miss itself as the patch
                patches++; // Increment the patch count
            }
        }
        
        return patches;
    }
}
