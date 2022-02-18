class Solution {
    public String convert(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n >= k) {
            sb.append(n % k);
            n = n / k;
        }
        sb.append(n);
        sb.reverse();
        return sb.toString();
    }

    public boolean isPrime(String number) {
        long n = Long.parseLong(number);
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (long i = 3; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int solution(int n, int k) {
        String converted = convert(n, k);
        int answer = 0;
        for (String number : converted.split("0")) {
            if (number.isEmpty() || number.isBlank()) {
                continue;
            }
            if (isPrime(number)) {
                answer++;
            }
        }
        return answer;
    }
}
