import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result;
        if (s.length() == 0) {
            result = 0;
        } else
            result = 1;
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (queue.contains(tmp)) {
                result = Math.max(result, queue.size());
                while (!queue.isEmpty() && queue.peek() != tmp) {
                    queue.poll();
                }
                if (!queue.isEmpty()) {
                    queue.poll();
                }
                queue.add(tmp);
                continue;
            }
            queue.add(tmp);
        }
        result = Math.max(result, queue.size());
        return result;
    }
}
