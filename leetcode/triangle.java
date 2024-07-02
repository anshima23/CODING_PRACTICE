import java.util.List;

public class triangle {
     public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        // Initialize the bottom row of dp with the values from the bottom row of the triangle
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }

        // Starting from the second to last row, calculate the minimum path sum for each element
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                // Calculate the two possible paths: moving down or moving diagonally
                int down = triangle.get(i).get(j) + dp[i + 1][j];
                int diagonal = triangle.get(i).get(j) + dp[i + 1][j + 1];

                // Store the minimum of the two paths in dp
                dp[i][j] = Math.min(down, diagonal);
            }
        }

        // The result is stored at the top of dp array
        return dp[0][0];
    }
}
