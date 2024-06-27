public class count_no_containing_four {
    public static boolean findfour(int n){
        while(n>0){
            if(n%10==4){
                return true;
            }
            n/=10;
        }
        return false;
    }
    public static int countNumberswith4(int n) {
        int count=0;
        for(int i =1;i<=n;i++){
            if(findfour(i)){count++;}
        }
        return count;
    }
}
