public class min_no_k_consecutive_bit_flip {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int flips = 0;
        int[] flipIndicator = new int[n];
        int currentFlips = 0;

        for (int i = 0; i < n; i++) {
            if (i >= k) {
                currentFlips ^= flipIndicator[i - k];
            }
            if (nums[i] == currentFlips) {
                if (i + k > n) {
                    return -1;
                }
                flips++;
                currentFlips ^= 1;
                flipIndicator[i] = 1;
            }
        }
        return flips;
    }
}
