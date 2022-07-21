import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static boolean[] visited;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(min);

    }

    private static void dfs(int at, int depth) {
        // 탈출 조건
        if (depth == n / 2) {
            // 비교 로직 추가
            diff();
            return;
        }

        for (int i = at; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }

    }

    private static void diff() {
        int start = 0;
        int link = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visited[i] && visited[j]) {
                    start += arr[i][j];
                    start += arr[j][i];
                } else if (!visited[i] && !visited[j]) {
                    link += arr[i][j];
                    link += arr[j][i];
                }
            }
        }

        int value = Math.abs(start - link);
        // 가장 최적의 조건이기 때문에 해당 값을 출력하고 끝낸다
        if (value == 0) {
            System.out.println(value);
            System.exit(0);
        }
        // 그게 아니라면 최소값 갱신
        min = Math.min(min, value);
    }

}
