import java.util.Arrays;

public class magnetic_force_between_two_balls {
     public int maxDistance(int[] position, int m) {
         Arrays.sort(position);

        int low = 1; // Minimum possible force
        int high = position[position.length - 1] - position[0]; // Maximum possible force

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlaceBalls(position, m, mid)) {
                low = mid + 1; // Try for a larger minimum distance
            } else {
                high = mid - 1; // Try for a smaller minimum distance
            }
        }

        return high; // The largest minimum distance found
    }
     private boolean canPlaceBalls(int[] position, int m, int minDist) {
        int count = 1; // Place the first ball
        int lastPos = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPos >= minDist) {
                count++;
                lastPos = position[i];
                if (count == m) {
                    return true;
                }
            }
        }

        return false;
    }
}
