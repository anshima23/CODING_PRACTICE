import java.util.HashMap;
import java.util.Map;

public class better_string {
     public static int countDistinctSubsequences(String str) {
        int n = str.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // Empty subsequence

        Map<Character, Integer> lastOccurrence = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] * 2;
            char currentChar = str.charAt(i - 1);

            if (lastOccurrence.containsKey(currentChar)) {
                dp[i] -= dp[lastOccurrence.get(currentChar) - 1];
            }

            lastOccurrence.put(currentChar, i);
        }

        return dp[n];
    }

    // Function to find the better string based on the number of distinct subsequences
    public static String betterString(String str1, String str2) {
        int count1 = countDistinctSubsequences(str1);
        int count2 = countDistinctSubsequences(str2);

        if (count1 >= count2) {
            return str1;
        } else {
            return str2;
        }
    }
}

