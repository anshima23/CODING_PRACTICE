public class largest_sq_matrix {
    static int maxSquare(int n, int m, int mat[][]) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
             return 0;
         }
 
         int[][] dp = new int[n][m];
         int maxSide = 0;
 
         // Initialize the first row and first column
         for (int i = 0; i < n; i++) {
             dp[i][0] = mat[i][0];
             maxSide = Math.max(maxSide, dp[i][0]);
         }
         for (int j = 0; j < m; j++) {
             dp[0][j] = mat[0][j];
             maxSide = Math.max(maxSide, dp[0][j]);
         }
 
         // Fill the dp array
         for (int i = 1; i < n; i++) {
             for (int j = 1; j < m; j++) {
                 if (mat[i][j] == 1) {
                     dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                     maxSide = Math.max(maxSide, dp[i][j]);
                 } else {
                     dp[i][j] = 0;
                 }
             }
         }
 
         return maxSide;
     }
}
