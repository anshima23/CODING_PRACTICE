import java.util.HashMap;
import java.util.Map;

public class subarray_sum_divisible_by_k {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Initialize with prefix sum 0 having count 1 (helps with subarrays starting from index 0)
        
        int count = 0;
        int pref = 0; // Variable to store current prefix sum modulo k
        
        for (int i = 0; i < n; i++) {
            pref = (pref + nums[i]) % k;
            if (pref < 0) pref += k; // Ensure pref is non-negative
            
            if (map.containsKey(pref)) {
                count += map.get(pref);
            }
            
            map.put(pref, map.getOrDefault(pref, 0) + 1);
        }
        
        return count;
    }
}
