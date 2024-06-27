class Solution
{
  public int padovanSequence(int n)
    {
        final int MOD = 1000000007;

        if (n == 0 || n == 1 || n == 2) {
            return 1;
        }

        long[] padovanSequence = new long[n + 1];
        padovanSequence[0] = padovanSequence[1] = padovanSequence[2] = 1;

        for (int i = 3; i <= n; i++) {
            padovanSequence[i] = (padovanSequence[i - 2] + padovanSequence[i - 3]) % MOD;
        }

        return (int) padovanSequence[n];
    }
}