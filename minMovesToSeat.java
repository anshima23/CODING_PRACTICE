import java.util.*;
class minMovesToSeat{
public int min_MovesToSeat(int[] seats, int[] students) {
    Arrays.sort(seats);
    Arrays.sort(students);

    int sum =0;
   int n = seats.length;

   for(int i =0;i<n;i++){
    sum += Math.abs(seats[i]-students[i]);
   }
   return sum;
 }
}
