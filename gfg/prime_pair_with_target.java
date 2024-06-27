import java.util.ArrayList;

public class prime_pair_with_target {
    public static boolean isPrime(int number) {
        // Check for less than 2 (0 and 1 are not prime numbers)
        if (number <= 1) 
            return false;
        
        // Check for factors from 2 to the square root of the number
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) 
                return false; // Found a factor, not a prime number
        }
        
        return true; // No factors found, it's a prime number
    }
    
     public static ArrayList<Integer> getPrimes(int n) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 2;i<(n/2 + 1);i++){//as we know 4 + 6 = 10 = 6 + 4 as well
            if(isPrime(i) && isPrime(n-i)){
                    ans.add(i);
                    ans.add(n-i);
                    return ans;
            }
        }

        if(ans.isEmpty()){//not found
            ans.add(-1);
            ans.add(-1);
        }
        return ans;
    }
}
