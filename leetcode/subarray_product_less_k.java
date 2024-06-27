public class subarray_product_less_k {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n  = nums.length;
         int product = 1;
         int count =0;
        int start=0;
         int end = 0;
 
           if (k <= 1) {
             return 0; // If k <= 1, no product can be less than k
         }
         
 
         while(end<n){
             product*=nums[end];
             while(product>=k && start<=end){
                 product/=nums[start];
                 start++;
             }
           
             count += end -start +1;
                end++;
         }
         return count;
     }
}
