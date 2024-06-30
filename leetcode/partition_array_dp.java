import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class partition_array_dp {
      public int minimumDifference(int[] nums) {
          int n = nums.length / 2;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int halfSum = totalSum / 2;

        // Generate subset sums for the first and second halves
        List<List<Integer>> firstHalfSums = generateSubsetSums(Arrays.copyOfRange(nums, 0, n));
        List<List<Integer>> secondHalfSums = generateSubsetSums(Arrays.copyOfRange(nums, n, nums.length));

        int minDiff = Integer.MAX_VALUE;

        // Sort the second half sums for binary search
        for (int i = 0; i <= n; i++) {
            Collections.sort(secondHalfSums.get(i));
        }

        // Try to find the best match for each subset sum in the first half
        for (int i = 0; i <= n; i++) {
            for (int sum1 : firstHalfSums.get(i)) {
                int target = halfSum - sum1;
                List<Integer> secondList = secondHalfSums.get(n - i);

                int j = Collections.binarySearch(secondList, target);
                if (j < 0) {
                    j = -j - 1;
                }

                // Check the closest element in the second half sums
                if (j < secondList.size()) {
                    int sum2 = secondList.get(j);
                    minDiff = Math.min(minDiff, Math.abs(totalSum - 2 * (sum1 + sum2)));
                }
                if (j > 0) {
                    int sum2 = secondList.get(j - 1);
                    minDiff = Math.min(minDiff, Math.abs(totalSum - 2 * (sum1 + sum2)));
                }
            }
        }

        return minDiff;
    }

    private List<List<Integer>> generateSubsetSums(int[] nums) {
        int n = nums.length;
        List<List<Integer>> allSums = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            allSums.add(new ArrayList<>());
        }

        // Use bitmask to generate all subsets
        for (int mask = 0; mask < (1 << n); mask++) {
            int sum = 0;
            int bits = 0;
            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) != 0) {
                    sum += nums[j];
                    bits++;
                }
            }
            allSums.get(bits).add(sum);
        }

        return allSums;
    }
}
