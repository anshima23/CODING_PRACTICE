public class given_valid_matrix {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
       int n = colSum.length;
       int[][] mat = new int[m][n];

       for (int i = 0; i < m; i++) {
           for (int j = 0; j < n; j++) {
               int minVal = Math.min(rowSum[i], colSum[j]);
               mat[i][j] = minVal;
               rowSum[i] -= minVal;
               colSum[j] -= minVal;
           }
       }
       return mat;
   }
}
