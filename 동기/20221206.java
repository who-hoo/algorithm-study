import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // 보도블럭은 1번부터 N번까지 번호가 매겨져 있다
        // k칸만큼 점프를 하는데 필요한 에너지 양은 k*k
        // b, o, j, b, o, j 순서로 보도블럭을 밟으면서 점프를 할 것임
        // 에너지 양의 최소값을 구하라
        String[] split = br.readLine().split("");
        String[] roads = new String[n + 1];
        for (int i = 1; i <= n; i++) {
            roads[i] = split[i - 1];
        }

        Solution s = new Solution();
        System.out.println(s.solution(n, roads));
    }

    public int solution(int n, String[] roads) {
        return 0;
    }
}
