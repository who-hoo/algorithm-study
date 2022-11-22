package 아더;

public class PRO_1832_보행자천국 {

    public static void main(String[] args) {
        PRO_1832_보행자천국 pro = new PRO_1832_보행자천국();

        int m = 3;
        int[] n = {3, 6};
        int[][][] city_map = {
            {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
            {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}}
        };

        for (int i = 0; i < 2; i++) {
            System.out.println(pro.solution(m, n[i], city_map[i]));
        }
    }

    int MOD = 20170805;
    int answer = 0;
    boolean[][] visited;
    int[][] dir = {{0, 1}, {1, 0}}; // 오른쪽 아래쪽

    public int solution(int m, int n, int[][] cityMap) {
        visited = new boolean[m][n];
        answer = 0;

        // dfs 사용해야할 듯
        dfs(0, 0, m, n, cityMap, 0, 0);


        return answer;
    }

    void dfs(int x, int y, int m, int n, int[][] cityMap, int oldX, int oldY) {
        visited[x][y] = true;

        if (x == m - 1 && y == n - 1) {
            answer = (answer + 1) % MOD;
        }

        for (int k = 0; k < 2; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if (nx < 0 || ny < 0 || nx >= m || ny >= n){
                continue;
            }
            if (cityMap[nx][ny] == 1){
                continue;
            }
//            if (cityMap[nx][ny] == 2) {
//                // 오던 방향으로만 진행가능하다
//                // 위에서 오는 방향
//                if ((oldX == x && oldY == y + 1) && (x != nx || y != ny + 1)) {
//                    continue;
//                }
//                // 왼쪽에서 오는 방향
//                if ((oldX == x - 1 && oldY == y) && (x != nx - 1 || y != ny)) {
//                    continue;
//                }
//            }
            if (visited[nx][ny]){
                continue;
            }

            dfs(nx, ny, m, n, cityMap, x, y);
        }
    }

}
