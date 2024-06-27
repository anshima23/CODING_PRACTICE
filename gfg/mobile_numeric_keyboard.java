
class Solution {
    public long getCount(int n) {
        if (n == 1) return 10; // If n is 1, all single digits are possible
        
        // Adjacency list for each digit
        int[][] moves = {
            {0, 8}, // moves from 0
            {1, 2, 4}, // moves from 1
            {2, 1, 3, 5}, // moves from 2
            {3, 2, 6}, // moves from 3
            {4, 1, 5, 7}, // moves from 4
            {5, 2, 4, 6, 8}, // moves from 5
            {6, 3, 5, 9}, // moves from 6
            {7, 4, 8}, // moves from 7
            {8, 5, 7, 9, 0}, // moves from 8
            {9, 6, 8} // moves from 9
        };
        
        // Initialize dp array
        long[][] dp = new long[n + 1][10];
        
        // Base case: For length 1, each digit can be itself
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }
        
        // Build dp table
        for (int len = 2; len <= n; len++) {
            for (int digit = 0; digit <= 9; digit++) {
                dp[len][digit] = 0;
                for (int move : moves[digit]) {
                    dp[len][digit] += dp[len - 1][move];
                }
            }
        }
        
        // Sum all counts of sequences of length n
        long result = 0;
        for (int i = 0; i <= 9; i++) {
            result += dp[n][i];
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getCount(1)); // Output: 10
        System.out.println(solution.getCount(2)); // Output: 36
        System.out.println(solution.getCount(3)); // Output should be calculated
    }
}