public class compare_two_fractions {
    String compareFrac(String str) {
        String[] fractions = str.split(", ");
        
      String[] fraction1 = fractions[0].split("/");
       int a = Integer.parseInt(fraction1[0]);
       int b = Integer.parseInt(fraction1[1]);
       
       // Split the second fraction by "/"
       String[] fraction2 = fractions[1].split("/");
       int c = Integer.parseInt(fraction2[0]);
       int d = Integer.parseInt(fraction2[1]);
       
       
        double x = (double) a / b;
       double y = (double) c / d;
       
       if(x>y){return fractions[0];}
       else if(x<y){
           return fractions[1];
       }
       else{
           return "equal";
       }
       
   }
}
