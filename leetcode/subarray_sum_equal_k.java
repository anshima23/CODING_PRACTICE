import java.util.HashMap;
import java.util.Map;

public class subarray_sum_equal_k {
     public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] pref = new int[n];
        pref[0] = nums[0];

        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] + nums[i];
        }

        int count = 0;
        map.put(0, 1);  // To handle the case when subarray itself equals k

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(pref[i] - k)) {
                count += map.get(pref[i] - k);
            }
            map.put(pref[i], map.getOrDefault(pref[i], 0) + 1);
        }

        return count;
    }
}
