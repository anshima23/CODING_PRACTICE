public class center_star_graph {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1; // Since there are n edges, there are n+1 nodes.
        int[] indegree = new int[n + 1]; // Adjusted to n+1 to handle 1-based indexing.

        for (int i = 0; i < edges.length; i++) { // Loop over the edges
            int a = edges[i][0];
            int b = edges[i][1];
            indegree[a]++;
            indegree[b]++;
        }

        for (int i = 1; i <= n; i++) { // Check nodes from 1 to n
            if (indegree[i] == n - 1) { // Center node will be connected to n-1 nodes.
                return i;
            }
        }
        return -1;
    }
}
