public class geek_jump {
    public int minimumEnergy(int arr[],int N){
        if (N == 1) return 0; 
         int[] dp = new int[N];
         dp[0] = 0;
         for (int i = 1; i < N; i++) {
             int oneStep = dp[i-1] + Math.abs( arr[i] -  arr[i-1]);
             int twoSteps = (i > 1) ? dp[i-2] + Math.abs( arr[i] -  arr[i-2]) : Integer.MAX_VALUE;
             dp[i] = Math.min(oneStep, twoSteps);
         }
         return dp[N-1];
        }
}
