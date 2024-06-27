public class no_of_rectangles_in_circle {
    int rectanglesInCircle(int r) {
        int count =0;
       for(int i =1;i<2*r;i++){
           for(int j =1;j<2*r;j++){
               if((i*i + j*j )<= 4*r*r){count++;}
           }
       }
       return count;
    }
}
