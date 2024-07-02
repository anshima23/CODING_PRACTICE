public class 0_1_knapshok {
    static int knapsackUtil(int[] wt, int[] val, int ind, int W, int[][] dp) {
        
        if (ind == 0) {
            if (wt[0] <= W) { return val[0];}
            else {return 0;}
        }

        if (dp[ind][W] != -1) {return dp[ind][W];}
        int notTaken = 0 + knapsackUtil(wt, val, ind - 1, W, dp);
        int taken = Integer.MIN_VALUE;
        if (wt[ind] <= W) { taken = val[ind] + knapsackUtil(wt, val, ind - 1, W - wt[ind], dp);}
       
        dp[ind][W] = Math.max(notTaken, taken);
        return dp[ind][W];
    }
   
   
   
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         int dp[][] = new int[n][W + 1];
        for (int row[] : dp) { Arrays.fill(row, -1);}
        return knapsackUtil(wt, val, n - 1, W, dp);
    } 
}
