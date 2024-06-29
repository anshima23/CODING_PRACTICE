import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class all_ancester_in_DAG {
     public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Set<Integer>> ancestors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ancestors.add(new HashSet<>());
        }
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        
        for (int i = 0; i < n; i++) {
            dfs(i, i, graph, ancestors);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> ancestorList = new ArrayList<>(ancestors.get(i));
            Collections.sort(ancestorList);
            result.add(ancestorList);
        }
        
        return result;
    }
    
    private void dfs(int start, int node, List<List<Integer>> graph, List<Set<Integer>> ancestors) {
        for (int neighbor : graph.get(node)) {
            if (ancestors.get(neighbor).add(start)) {
                dfs(start, neighbor, graph, ancestors);
            }
        }
    }
}
