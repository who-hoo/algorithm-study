public class Solution {

    public static int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();

        while (n != 0) {
            sb.append(n % k);
            n /= k;
        }
        String[] arr = sb.reverse().toString().split("0");

        int count = 0;

        for (String s : arr) {
            if (s.equals("")) {
                continue;
            }

            long a = Long.parseLong(s);

            if (a > 1 && isPrime(a)) {
                count++;
            }
        }
        return count;

    }

    private static Boolean isPrime(long a) {
        for (long i = 2; i * i <= a; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 110011;
        int k = 10;
        System.out.println(solution(n, k));


    }
}
