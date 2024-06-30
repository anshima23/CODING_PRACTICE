import java.util.ArrayList;
import java.util.List;

public class max_edges {
      public int maxNumEdgesToRemove(int n, int[][] edges) {
        // Initialize Union-Find structures for Alice and Bob
        UnionFind ufAlice = new UnionFind(n + 1); // n + 1 because nodes are 1-indexed
        UnionFind ufBob = new UnionFind(n + 1);

        int maxRemovableEdges = 0;

        // Separate edges by type
        List<int[]> type1Edges = new ArrayList<>();
        List<int[]> type2Edges = new ArrayList<>();
        List<int[]> type3Edges = new ArrayList<>();

        for (int[] edge : edges) {
            int type = edge[0];
            int u = edge[1];
            int v = edge[2];
            
            if (type == 1) {
                type1Edges.add(edge);
            } else if (type == 2) {
                type2Edges.add(edge);
            } else { // type == 3
                type3Edges.add(edge);
            }
        }

        // Process type 3 edges (both Alice and Bob can traverse)
        for (int[] edge : type3Edges) {
            int u = edge[1];
            int v = edge[2];
            if (!ufAlice.union(u, v)) {
                maxRemovableEdges++;
            } else {
                ufBob.union(u, v);
            }
        }

        // Process type 1 edges (only Alice can traverse)
        for (int[] edge : type1Edges) {
            int u = edge[1];
            int v = edge[2];
            if (!ufAlice.union(u, v)) {
                maxRemovableEdges++;
            }
        }

        // Process type 2 edges (only Bob can traverse)
        for (int[] edge : type2Edges) {
            int u = edge[1];
            int v = edge[2];
            if (!ufBob.union(u, v)) {
                maxRemovableEdges++;
            }
        }

        // Check if both Alice and Bob can reach all nodes
        if (ufAlice.countComponents() > 1 || ufBob.countComponents() > 1) {
            return -1;
        }

        return maxRemovableEdges;
    }
    
    // Union-Find (Disjoint Set Union) implementation
    class UnionFind {
        int[] parent;
        int[] size;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 1; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return false; // Already in the same component
            }

            // Union by size
            if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }

            return true;
        }

        public int countComponents() {
            int count = 0;
            for (int i = 1; i < parent.length; i++) {
                if (parent[i] == i) {
                    count++;
                }
            }
            return count;
        }
    }
}
