public class count_good_no {
    private static final int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2; // Number of even positions
        long oddCount = n / 2;        // Number of odd positions

        long evenChoices = power(5, evenCount, MOD); // 5 choices for even positions
        long oddChoices = power(4, oddCount, MOD);   // 4 choices for odd positions

        return (int) (evenChoices * oddChoices % MOD);
    }

    private long power(long base, long exp, int mod) {
        long result = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp % 2) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp = exp / 2;
        }
        return result;
    }
}
