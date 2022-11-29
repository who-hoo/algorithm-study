import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] op = new int[4];
    static int minValue = Integer.MAX_VALUE;
    static int maxValue = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr[0], 1);
        System.out.println(maxValue);
        System.out.println(minValue);
    }

    private static void dfs(int num, int idx) {

        if (idx == N) {
            minValue = Math.min(minValue, num);
            maxValue = Math.max(maxValue, num);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {

                // 해당 연산자 1 감소
                op[i] --;

                switch (i) {
                    case 0 :
                        dfs(num + arr[idx], idx + 1);
                        break;
                    case 1:
                        dfs(num - arr[idx], idx + 1);
                        break;
                    case 2:
                        dfs(num * arr[idx], idx + 1);
                        break;
                    case 3:
                        dfs(num / arr[idx], idx + 1);
                        break;
                }
                op[i] ++;
            }
        }

    }
}
