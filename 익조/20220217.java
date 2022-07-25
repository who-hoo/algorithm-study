import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

class Solution {
    public int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        String base = "0123456789";

        while (n / k != 0) {
            sb.append(base.charAt(n % k));
            n /= k;
        }
        sb.append(base.charAt(n % k)).reverse();
        String[] nums = sb.toString().split("0");

        int result = 0;
        for (String num : nums) {
            if (num.isEmpty()) continue;
            if (isPrime(Long.parseLong(num))) {
                result++;
            }
        }

        return result;
    }

    public boolean isPrime(long num) {
        HashSet factors = IntStream.rangeClosed(1, (int) Math.sqrt(num))
                .filter(i -> num % i == 0)
                .mapToObj(i -> List.of(i, num / i))
                .collect(HashSet::new, HashSet::addAll, HashSet::addAll);

        return num > 1 && factors.size() == 2 && factors.contains(1) && factors.contains(num) ? true : false;
    }
}
