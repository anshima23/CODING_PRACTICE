import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class max_connected_groups {
     public int MaxConnection(int grid[][]) {
         int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        int[][] componentId = new int[n][n];
        List<Integer> componentSizes = new ArrayList<>();
        int componentIndex = 0;

        // Directions for moving up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // DFS to find the size of each component
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int size = dfs(grid, visited, i, j, componentIndex, componentId, directions);
                    componentSizes.add(size);
                    componentIndex++;
                }
            }
        }

        // If no 1's are present, the largest group is 1 by changing one 0 to 1
        if (componentSizes.isEmpty()) {
            return 1;
        }

        // Find the maximum size of initial components
        int maxGroupSize = Collections.max(componentSizes);

        // Check each 0 and calculate potential maximum group size by changing it to 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> uniqueComponents = new HashSet<>();
                    int potentialSize = 1; // Changing the 0 to 1

                    for (int[] dir : directions) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1) {
                            int compId = componentId[x][y];
                            if (!uniqueComponents.contains(compId)) {
                                potentialSize += componentSizes.get(compId);
                                uniqueComponents.add(compId);
                            }
                        }
                    }

                    maxGroupSize = Math.max(maxGroupSize, potentialSize);
                }
            }
        }

        return maxGroupSize;
    }

    private int dfs(int[][] grid, boolean[][] visited, int i, int j, int componentIndex, int[][] componentId, int[][] directions) {
        int n = grid.length;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i, j});
        visited[i][j] = true;
        componentId[i][j] = componentIndex;
        int size = 0;

        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int x = cell[0];
            int y = cell[1];
            size++;

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] == 1 && !visited[newX][newY]) {
                    stack.push(new int[]{newX, newY});
                    visited[newX][newY] = true;
                    componentId[newX][newY] = componentIndex;
                }
            }
        }

        return size;
    }
}
