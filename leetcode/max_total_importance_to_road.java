import java.util.*;

class Solution {
    public long maximumImportance(int n, int[][] roads) {
        // Step 1: Calculate the degree of each city
        int[] degree = new int[n];
        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }

        // Step 2: Create a list of cities with their degrees
        List<int[]> cityDegrees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cityDegrees.add(new int[]{i, degree[i]});
        }

        // Step 3: Sort cities based on their degrees in descending order
        cityDegrees.sort((a, b) -> b[1] - a[1]);

        // Step 4: Assign values from n to 1 based on the sorted order
        int[] values = new int[n];
        int value = n;
        for (int[] city : cityDegrees) {
            values[city[0]] = value--;
        }

        // Step 5: Calculate the total importance of all roads
        long totalImportance = 0;
        for (int[] road : roads) {
            totalImportance += values[road[0]] + values[road[1]];
        }

        return totalImportance;
    }
}
