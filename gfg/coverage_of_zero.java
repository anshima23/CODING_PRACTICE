public class coverage_of_zero {
    public int FindCoverage(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int totalCoverage = 0;

        // Directions arrays for left, right, up, and down
        int[] rowDirections = {-1, 1, 0, 0};
        int[] colDirections = {0, 0, -1, 1};

        // Iterate through each cell in the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    int coverage = 0;
                    // Check all four directions
                    for (int k = 0; k < 4; k++) {
                        int newRow = i + rowDirections[k];
                        int newCol = j + colDirections[k];

                        // Check if the new position is within the matrix bounds
                        if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                            if (matrix[newRow][newCol] == 1) {
                                coverage++;
                            }
                        }
                    }
                    totalCoverage += coverage;
                }
            }
        }

        return totalCoverage;
    

    }
}
