public class left_rotate_matrix_k_times {
    int[][] rotateMatrix(int k, int mat[][]) {
        int n = mat.length;
       int m = mat[0].length;
       int effectiveK = k % m;

       int[][] result = new int[n][m];

       for (int i = 0; i < n; i++) {
           for (int j = 0; j < m; j++) {
               int newPos = (j - effectiveK + m) % m;
               result[i][newPos] = mat[i][j];
           }
       }

       return result;
   }
}
