public class Solution {
    public int solution(int[] citations) {
        int L = citations.length;
        while (true) {
            int cnt = 0;
            for (int c : citations) {
                if(c >= L) {
                    cnt++;
                }
            }
            if (L <= cnt) {
                return L;
            }
            L--;
        }
    }
}
