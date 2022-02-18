package programmers.k진수에서_소수_개수_구하기;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        solution(437674, 3);
    }

    public static int solution(int n, int k) {
        //진법 변환
        String notationStr = "";
        while (n != 0) {
            notationStr = (n % k) + notationStr;
            n = n / k;
        }

        //공백 요소 제거
        List<String> nums = Arrays.stream(notationStr.split("0"))
            .filter(s -> !s.isEmpty() && !s.equals("1"))
            .collect(Collectors.toList());

        //제곱근까지만 판별 -> 어떤 수의 약수를 구할 때 제곱근 이후로는 제곱근 전에 n x m 하던 걸 m x n으로 순서를 바꾸는 것일 뿐이기 때문.
        int answer = 0;

        for (int i = 0; i < nums.size(); i++) {
            int num = Integer.parseInt(nums.get(i));
            if (isPrime(num)) {
                answer++;
            }
        }
        System.out.println(answer);
        return answer;
    }

    private static boolean isPrime(int num) {
        for (int j = 2; j <= Math.sqrt(num); j++) { // '<=' 제곱근이 정수인 경우가 있음
            if (num % j == 0) {
                return false;
            }
        }
        return true;
    }
}
