public class minimal_cost {
    public int minimizeCost(int arr[],int N,int K){
        int[] dp = new int[N];
         
         // Initialize the dp array with a large number since we want to find the minimum cost
         for (int i = 1; i < N; i++) {
             dp[i] = Integer.MAX_VALUE;
         }
 
         dp[0] = 0; // No cost to stay on the first stone
 
         // Fill the dp array
         for (int i = 0; i < N; i++) {
             for (int j = 1; j <= K && i + j < N; j++) {
                 dp[i + j] = Math.min(dp[i + j], dp[i] + Math.abs(arr[i] - arr[i + j]));
             }
         }
 
         return dp[N - 1]; // The cost to reach the last stone
     }
}
