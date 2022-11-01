import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    int[][] copyArr;
    int[] dx = new int[]{0, 0, -1, 1};
    int[] dy = new int[]{-1, 1, 0, 0};
    boolean[][] visited;
    List<int[]> cheesePoints;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        StringTokenizer st;
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Solution s = new Solution();
        System.out.println(s.solution(arr, n, m));
    }

    public int solution(int[][] arr, int n, int m) {
        // find
        // melting
        copyArr = arr;
        int count = 0;
        while (true) {
            count++;
            visited = new boolean[n][m];
            cheesePoints = new ArrayList<>();
            find(0, 0);
            melting();
            if (isFinished()) {
                break;
            }
        }
        return count;
    }

    private boolean isFinished() {
        for (int i = 0; i < copyArr.length; i++) {
            for (int j = 0; j < copyArr[0].length; j++) {
                if (copyArr[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private void melting() {
        for (int i = 0; i < cheesePoints.size(); i++) {
            int x = cheesePoints.get(i)[0];
            int y = cheesePoints.get(i)[1];
            int count = 0;

            for (int j = 0; j < 4; j++) {
                int nx = dx[j] + x;
                int ny = dy[j] + y;

                if (copyArr[nx][ny] == 2) {
                    count++;
                }
            }

            if (count >= 2) {
                copyArr[x][y] = 0;
            }
        }
    }

    private void find(int x, int y) {
        // dfs로 외부 공기는 2로 바꾼다
        if (x == copyArr.length - 1 && y == copyArr[0].length - 1) {
            return;
        }

        visited[x][y] = true;
        copyArr[x][y] = 2;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || ny < 0 || nx >= copyArr.length || ny >= copyArr[0].length) {
                continue;
            }

            if (visited[nx][ny]) {
                continue;
            }

            if (copyArr[nx][ny] == 1) {
                cheesePoints.add(new int[]{nx, ny});
                continue;
            }

            find(nx, ny);
        }
    }
}
