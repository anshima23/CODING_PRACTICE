import java.util.HashMap;
import java.util.Map;

public class zero_sum_subarray {
    public static long findSubarray(long[] arr, int n) {
        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 1L); // Initialize map with prefix sum 0

        long[] prefix = new long[n];
        prefix[0] = arr[0];

        long count = 0;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for (long sum : prefix) {
            if (map.containsKey(sum)) {
                count += map.get(sum);
            }
            map.put(sum, map.getOrDefault(sum, 0L) + 1);
        }

        return count;
    }
}
