public class grumpy_bookstore_owner {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int satis = 0;
        int n = customers.length;
        
        // Calculate initial satisfaction without using the technique
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                satis += customers[i];
            }
        }
        
        // Initialize the extra satisfaction and maxExtraSatis
        int extraSatis = 0, maxExtraSatis = 0;
        
        // Slide the window over the elements
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 1) {
                extraSatis += customers[i];
            }
            
            // Ensure the window size is exactly 'minutes'
            if (i >= minutes && grumpy[i - minutes] == 1) {
                extraSatis -= customers[i - minutes];
            }
            
            // Update the maxExtraSatis after the first 'minutes' elements
            if (i >= minutes - 1) {
                maxExtraSatis = Math.max(maxExtraSatis, extraSatis);
            }
        }
        
        // Total satisfied customers = base satisfaction + maximum extra satisfaction
        return satis + maxExtraSatis;
    }   
}
