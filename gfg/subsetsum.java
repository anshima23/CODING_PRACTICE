import java.util.ArrayList;

public class subsetsum {
     public static void subset(ArrayList<Integer> arr,int index,int sum,int n,ArrayList<Integer> ans){
        
        if(index ==n){
            ans.add(sum);
            return;
        }
        
        subset(arr,index+1,sum+arr.get(index),n,ans);
        subset(arr,index+1,sum,n,ans);
        
    }
    
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        subset(arr,0,0,n,ans);
        return ans;
    }
}
