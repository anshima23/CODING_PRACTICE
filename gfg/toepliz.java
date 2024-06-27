public class toepliz {
    boolean isToepliz(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        
        if(n==1 && m==1){return true;}
        
        int val = mat[0][0];
        int i =1;
        int j =1;
        while(i<n && j<m){
            if(val != mat[i][j]){return false;}
            i+=1;
            j+=1;
        }
       return true;
    }
}
