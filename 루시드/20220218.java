package AlgorithmStudy.pro92335;

public class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        String result = Integer.toString(n, k);

        String[] split = result.split("0");
        for (String s : split) {
            if (!s.isBlank() && checkPrime(s)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean checkPrime(String s) {
        long num = Long.parseLong(s);

        if(num == 0 || num == 1) {
            return false;
        }
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
