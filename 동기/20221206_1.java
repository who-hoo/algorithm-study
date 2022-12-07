import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    boolean[] prime = new boolean[201];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        Solution s = new Solution();
        System.out.println(s.solution(n, arr));
    }

    public int solution(int n, int[] arr) {
        // 어차피 하나씩 다 순회해서 소수를 찾아 더해야하기 때문에 정렬할 필요는 없을 거 같다
        // 마이너스는 어떻게 해야하나?
        int answer = 0;
        prime[0] = true;
        prime[1] = true;
        for (int i = 2; i * i <= 100; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= 100; j += i) {
                    prime[j] = true;
                }
            }
        }

        for (int index : arr) {
            if (index < 0) {
                if (!prime[-index]) {
                    answer += index;
                }
            } else if (!prime[index]) {
                answer += index;
            }
        }

        return answer;
    }

}
