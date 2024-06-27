
class Solution {

    public static void subsequence(int[] nums, int index, int n, ArrayList<List<Integer>> ans, ArrayList<Integer> temp) {
        if (index == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        // Exclude the current element and proceed
        subsequence(nums, index + 1, n, ans, temp);
        
        // Include the current element and proceed
        temp.add(nums[index]);
        subsequence(nums, index + 1, n, ans, temp);
        
        // Backtrack
        temp.remove(temp.size() - 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        subsequence(nums, 0, n, ans, temp);
        return ans;
    }
}
