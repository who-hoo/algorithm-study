class Solution {
    int MOD = 20170805;

    static boolean[][] chk;
    static int answer = 0;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    public int solution(int m, int n, int[][] cityMap) {
        chk = new boolean[m][n];
        chk[0][0] = true;
        DFS(0, 0, m, n, cityMap, 0);
        return answer % MOD;
    }

    private void DFS(int x, int y, int m, int n, int[][] cityMap, int dir) {
        if (x == m - 1 && y == n - 1) {
            answer += 1;
            return;
        }
        int nx, ny;
        if (cityMap[x][y] == 2) {
            nx = x + dx[dir];
            ny = y + dy[dir];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && !chk[nx][ny] && cityMap[nx][ny] != 1) {
                chk[nx][ny] = true;
                DFS(nx, ny, m, n, cityMap, dir);
                chk[nx][ny] = false;
            }
        } else {
            for (int i = 0; i < 2; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !chk[nx][ny] && cityMap[nx][ny] != 1) {
                    chk[nx][ny] = true;
                    DFS(nx, ny, m, n, cityMap, i);
                    chk[nx][ny] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // int results = s.solution(3, 6, new int[][] {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}});
        int results = s.solution(3, 3, new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}});
        System.out.println("results = " + results);
    }
}
