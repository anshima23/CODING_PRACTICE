import java.util.ArrayList;
import java.util.List;

public class combinationsum3 {
     public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(k, n, 1, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int k, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0 && current.size() == k) {
            result.add(new ArrayList<>(current)); // Found a valid combination, add to result
            return;
        }
        
        for (int i = start; i <= 9; i++) {
            if (target - i < 0) {
                break; // Optimization: If i is greater than remaining target, no need to proceed
            }
            
            current.add(i); // Include current number
            backtrack(k, target - i, i + 1, current, result); // Recur with remaining target and next start index
            current.remove(current.size() - 1); // Backtrack: remove last added number
        }
    }
}
