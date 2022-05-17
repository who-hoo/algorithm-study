import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        for (int h = n; h >= 0; h--) {
            int finalH = h;
            long cnt = Arrays.stream(citations).filter(c -> c >= finalH).count();
            if (h <= cnt) {
                return h;
            }
        }
        return 0;
    }
}
