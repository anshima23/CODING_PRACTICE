public class closest_three_sum {
    static int threeSumClosest(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr);  // Sort the array first

        int closestSum = arr[0] + arr[1] + arr[2];  // Initialize the closest sum with the first three elements
        
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;  // Left pointer
            int right = n - 1;  // Right pointer
            
            while (left < right) {
                int currentSum = arr[i] + arr[left] + arr[right];
                
                // If the current sum is closer to the target than the closest sum, update the closest sum
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target) || 
                    (Math.abs(currentSum - target) == Math.abs(closestSum - target) && currentSum > closestSum)) {
                    closestSum = currentSum;
                }
                
                // Move the pointers based on the comparison between current sum and target
                if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return closestSum;
    }
}
