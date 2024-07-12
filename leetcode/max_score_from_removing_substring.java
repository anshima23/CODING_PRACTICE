
public class max_score_from_removing_substring {
    public int maximumGain(String s, int x, int y) {
        if (x < y) {
           return maximumGain(s, y, x, 'b', 'a');
       } else {
           return maximumGain(s, x, y, 'a', 'b');
       }
   }

   private int maximumGain(String s, int highValue, int lowValue, char highChar, char lowChar) {
       int points = 0;
       StringBuilder stack = new StringBuilder();

       // First remove high value substrings
       for (char ch : s.toCharArray()) {
           if (ch == lowChar && stack.length() > 0 && stack.charAt(stack.length() - 1) == highChar) {
               stack.deleteCharAt(stack.length() - 1);
               points += highValue;
           } else {
               stack.append(ch);
           }
       }

       // Convert remaining stack to string for second round of removals
       s = stack.toString();
       stack.setLength(0);

       // Then remove low value substrings
       for (char ch : s.toCharArray()) {
           if (ch == highChar && stack.length() > 0 && stack.charAt(stack.length() - 1) == lowChar) {
               stack.deleteCharAt(stack.length() - 1);
               points += lowValue;
           } else {
               stack.append(ch);
           }
       }

       return points;
   }
}

