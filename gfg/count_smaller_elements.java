import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class count_smaller_elements {
     int[] constructLowerArray(int[] arr) {
       int n = arr.length;
        int[] ans = new int[n];
        
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        Map<Integer, Integer> rank = new HashMap<>();
        for (int i = 0; i < n; i++) {
            rank.put(sortedArr[i], i + 1);  
        }

        FenwickTree fenwickTree = new FenwickTree(n);

        for (int i = n - 1; i >= 0; i--) {
            int r = rank.get(arr[i]);
            ans[i] = fenwickTree.query(r - 1);
            fenwickTree.update(r, 1);
        }

        return ans;
    }

    class FenwickTree {
        int[] tree;
        int size;

        public FenwickTree(int size) {
            this.size = size;
            this.tree = new int[size + 1];
        }

        public void update(int index, int value) {
            while (index <= size) {
                tree[index] += value;
                index += index & -index;
            }
        }

        public int query(int index) {
            int sum = 0;
            while (index > 0) {
                sum += tree[index];
                index -= index & -index;
            }
            return sum;
        }
    }
}
