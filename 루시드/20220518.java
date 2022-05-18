import java.util.ArrayList;
import java.util.List;

class Solution {
    static boolean[][][] isVisited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int n, m;

    public int[] solution(String[] grid) {
        List<Integer> answer = new ArrayList<>();

        n = grid.length;
        m = grid[0].length();

        isVisited = new boolean[n][m][4];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    if (!isVisited[i][j][k]) {
                        answer.add(lightRoute(grid, i, j, k));
                    }
                }
            }
        }
        return answer.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
    private int lightRoute(String[] grid, int x, int y, int d) {
        int cnt = 0; // 이동 거리 초기화

        while (!isVisited[x][y][d]) {

            cnt++;
            isVisited[x][y][d] = true;

            if (grid[x].charAt(y) == 'L') {
                d = d == 0 ? 3 : d - 1; // 좌회전
            } else if (grid[x].charAt(y) == 'R') {
                d = d == 3 ? 0 : d + 1; // 우회전
            }

            // x, y 갱신
            x = (x + dx[d] + n) % n;
            y = (y + dy[d] + m) % m;
        }
        return cnt;
    }
}
