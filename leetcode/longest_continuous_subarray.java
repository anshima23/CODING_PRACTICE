import java.util.Deque;
import java.util.LinkedList;

public class longest_continuous_subarray {
    public int longestSubarray(int[] nums, int limit) {
        int length = 0;
        int start = 0;
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        for (int end = 0; end < nums.length; end++) {
            while (!maxDeque.isEmpty() && nums[end] > maxDeque.peekLast()) {
                maxDeque.pollLast();
            }
            while (!minDeque.isEmpty() && nums[end] < minDeque.peekLast()) {
                minDeque.pollLast();
            }

            maxDeque.addLast(nums[end]);
            minDeque.addLast(nums[end]);

            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if (nums[start] == maxDeque.peekFirst()) {
                    maxDeque.pollFirst();
                }
                if (nums[start] == minDeque.peekFirst()) {
                    minDeque.pollFirst();
                }
                start++;
            }

            length = Math.max(length, end - start + 1);
        }

        return length;
    }
}
