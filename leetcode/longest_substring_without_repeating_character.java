import java.util.HashMap;
import java.util.Map;

public class longest_substring_without_repeating_character {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int length = 0;

        Map<Character, Integer> map = new HashMap<>();
        
        while (end < s.length()) {
            char currentChar = s.charAt(end);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);

            while (map.get(currentChar) > 1) {
                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                start++;
            }

            length = Math.max(length, end - start + 1);
            end++;
        }

        return length;
    }
}
