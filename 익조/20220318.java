import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int result = 0, cnt = 0, n = citations.length;

        Arrays.sort(citations);

        for (int h = 0; h < 1001; h++) {
            if (h > citations[n-1]) break;
            for (int citation : citations) {
                if (citation >= h) {
                    cnt++;
                }
                if (cnt >= h) {
                    result = h;
                    break;
                }
            }
            cnt = 0;
        }

        return result;
    }
}
