public class min_window_substring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int[] tFreq = new int[128];
        for (char c : t.toCharArray()) {
            tFreq[c]++;
        }

        int[] windowFreq = new int[128];
        int have = 0, need = t.length();
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;

        while (right < s.length()) {
            char rChar = s.charAt(right);
            if (tFreq[rChar] > 0) {
                windowFreq[rChar]++;
                if (windowFreq[rChar] <= tFreq[rChar]) {
                    have++;
                }
            }

            while (have == need) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                }

                char lChar = s.charAt(left);
                if (tFreq[lChar] > 0) {
                    if (windowFreq[lChar] <= tFreq[lChar]) {
                        have--;
                    }
                    windowFreq[lChar]--;
                }

                left++;
            }

            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }
}
