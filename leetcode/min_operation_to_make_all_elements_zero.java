public class min_operation_to_make_all_elements_zero {
    public int minimumOperations(int[] nums) {
        int op =0;
        
        for(int i =0;i<nums.length;i++){
            if(nums[i]%3==1 || nums[i]%3==2){op++;}
        }
        return op;
    }
}
