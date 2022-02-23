public class Solution{
    public int solution(int n, int k) {
        int answer = 0;
        String num = Integer.toString(n, k);
        List<String> split = Arrays.stream(num.split("0")).filter(s -> !s.equals("")).collect(Collectors.toList());


        for (String s : split) {
            if(s.equals("1")) continue;
            else if (isPrime(Long.parseLong(s))) {
                answer++;
            }
        }

        return answer;
    }

    public boolean isPrime(long num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}