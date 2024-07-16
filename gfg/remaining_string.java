public class remaining_string {
    public String printString(String s, char ch, int count) {
        int occurrences = 0;

       for (int i = 0; i < s.length(); i++) {
           if (s.charAt(i) == ch) {
               occurrences++;
               if (occurrences == count) {
                   return s.substring(i + 1);
               }
           }
       }
       
       return "";
   }
}
