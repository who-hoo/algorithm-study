public class Solution {
    /**
     *
     * @param n 진수로
     * @param t 개를 구하고
     * @param m 명 중
     * @param p 번째
     * @return
     */
    public String solution(int n, int t, int m, int p) {
        String template = numToString(n, t, m);
        StringBuilder sb = new StringBuilder();

        while (sb.length() != t) {
            sb.append(template.charAt(p - 1));
            p += m;
        }
        return sb.toString();
    }

    public String numToString(int n, int t, int m) {
        StringBuilder sb = new StringBuilder();
        int number = 0;

        while (sb.length() <= t * m) {
            sb.append(Integer.toString(number++, n));
        }

        return sb.toString().toUpperCase();
    }
}
