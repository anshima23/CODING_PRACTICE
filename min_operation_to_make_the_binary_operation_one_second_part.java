public class min_operation_to_make_the_binary_operation_one_second_part {
    public int minOperations(int[] nums) {
        
        int flips = 0; 
           int currentState = 1; 
   
           for (int i = 0; i < nums.length; i++) {
               if (nums[i] != currentState) {
                   flips++;
                   currentState = 1 - currentState; 
               }
           }
   
           return flips;
       }
}
