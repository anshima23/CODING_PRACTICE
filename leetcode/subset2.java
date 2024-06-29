import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subset2 {
     public static void subset(int[] nums, int index, ArrayList<Integer> temp, ArrayList<List<Integer>> ans){
       if(index == nums.length){
           ans.add(new ArrayList<>(temp)); // Add a copy of temp to ans
           return;
       }
       
       // Include the current element
       temp.add(nums[index]);
       subset(nums, index + 1, temp, ans);
       
       // Exclude the current element
       temp.remove(temp.size() - 1);
       
       // Skip duplicates
       while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
           index++;
       }
       subset(nums, index + 1, temp, ans);
   }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // Sort the array to handle duplicates
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        subset(nums, 0, temp, ans);
        return ans;
    }
}
