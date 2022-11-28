import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] operators = new int[4];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        Solution s = new Solution();
        System.out.println(s.solution(n, numbers, operators));;
    }

    public String solution(int n, int[] numbers, int[] operators) {
        StringBuilder sb = new StringBuilder();
        // int 범위 내의 수
        // 연산자는 덧셈, 뺄셈, 곱셈, 나눗셈 순서대로, 개수
        // 음수를 양수로 나눌 때는. 양수로 바꾼뒤 몫을 취하고 그 몫을 음수로 바꾼다
        dfs(numbers[0], 1, numbers, operators, n);
        sb.append(max).append("\n");
        sb.append(min);
        return sb.toString();
    }

    private void dfs(int num, int index, int[] numbers, int[] operators, int n) {
        if (index == n) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;

//                 if (i == 0) {
//                     dfs(num + numbers[index], index + 1, numbers, operators, n);
//                 } else if (i == 1) {
//                     dfs(num - numbers[index], index + 1, numbers, operators, n);
//                 } else if (i == 2) {
//                     dfs(num * numbers[index], index + 1, numbers, operators, n);
//                 } else {
//                     dfs(num / numbers[index], index + 1, numbers, operators, n);
//                 }
//                 operators[i]++;
            }
        }
    }

}
