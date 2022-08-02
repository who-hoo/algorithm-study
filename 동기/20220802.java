import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] board;
    static boolean[][] visited;
    static int n;
    static int minResult = 10;
    static int maxResult = -1;
    static int minValue = 0;
    static int maxValue = 0;
    static int sum = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[0][0] = true;
        dfs(0);
        System.out.println(maxValue + " " + minValue);
        // 최대 점수와 최소 점수를 띄어서 출력
    }

    private static void dfs(int depth) {
        // 첫번째 줄 각 칸에서 시작하여 마지막 줄까지 이동하면서 더해진 값을 각각 최대값, 최소값 변수에 값을 비교하여 저장
        // 2중 for문으로 인덱스 체크해서 돌거면 visited는 필요가 없을 것 같기도하다
        if (depth == n) {
            return ;
        }


    }
}
