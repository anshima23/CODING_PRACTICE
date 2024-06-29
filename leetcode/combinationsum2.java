import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationsum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort candidates to handle duplicates and ensure ascending order
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current)); // Found a valid combination, add to result
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates (ensure i > start to avoid out-of-bounds access and duplicates)
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
            if (candidates[i] > target) {
                break; // Optimization: candidates are sorted, so no need to check further
            }
            
            current.add(candidates[i]); // Include current candidate
            backtrack(candidates, target - candidates[i], i + 1, current, result); // Recur with remaining target and next start index
            current.remove(current.size() - 1); // Backtrack: remove last added candidate
        }
    }
}
