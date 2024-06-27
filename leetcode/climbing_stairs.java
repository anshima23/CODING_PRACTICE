public class climbing_stairs {

    public static int solve(int n ,int[]dp){
          if(n==10){return 1;}
          if(n==2){return 2;}
          if(dp[n]!=-1){return dp[n];}
          dp[n]=solve(n-1,dp) + solve(n-2,dp);
          return dp[n];
    }
    public int climbing_Stairs(int n) {
         int[] dp = new int[n+1];
         for(int i =0;i<=n;i++){dp[i]=-1;}
         dp[1]=1;
         if (n >= 2) { dp[2] = 2;}

         int result = solve(n,dp);
         return result;

    }
}
