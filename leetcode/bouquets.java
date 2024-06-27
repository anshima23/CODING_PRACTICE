import java.util.Arrays;

public class bouquets {
     public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (m * k > n) {
            return -1; // Not enough flowers to make m bouquets of size k
        }
        
        int left = 1, right = Arrays.stream(bloomDay).max().getAsInt();
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canMakeBouquets(bloomDay, m, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        // After exiting the loop, left should be the minimum days to achieve m bouquets
        // Check if it's actually possible to make m bouquets with k flowers using left days
        if (canMakeBouquets(bloomDay, m, k, left)) {
            return left;
        } else {
            return -1;
        }
    }
    
    private boolean canMakeBouquets(int[] bloomDay, int m, int k, int days) {
        int bouquets = 0;
        int flowers = 0;
        
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= days) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        
        return bouquets >= m;
    }
}
