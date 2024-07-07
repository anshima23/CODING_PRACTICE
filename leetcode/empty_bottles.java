public class empty_bottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles; 
           int emptyBottles = numBottles; 
   
           while (emptyBottles >= numExchange) {
               int newFullBottles = emptyBottles / numExchange; // Number of new full bottles we get
               ans += newFullBottles; // Add the new full bottles to the total count
               emptyBottles = emptyBottles % numExchange + newFullBottles; // Update the count of empty bottles
           }
           
           return ans; 
       }
}
