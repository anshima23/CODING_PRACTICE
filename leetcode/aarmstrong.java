public class aarmstrong {
    static String armstrongNumber(int n){
        int sum =0;int r =0;int temp =n;
       while(n>0){
            r = n%10;
           sum+=r*r*r;
           n/=10;
       }
       if(sum == temp){
           return "Yes";
       }
       else{
           return "No";
       }
    }
}
