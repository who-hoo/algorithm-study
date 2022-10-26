class Solution {

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    public int solution(String dirs) {
        int answer = 0;
        int[][] map = new int[11][11];
        boolean[][][] visited = new boolean[11][11][4];
        int cx = 5;
        int cy = 5;
        for (int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);
            int d = 0;
            if (c == 'U') {
                d = 0;

            } else if (c == 'L') {
                d = 1;

            } else if (c == 'D') {
                d = 2;

            } else {
                // R
                d = 3;
            }
            int nx = cx + dx[d];
            int ny = cy + dy[d];
            if (nx < 0 || ny < 0 || nx >= map.length || ny >= map.length) {
                continue;
            }

            if (!visited[nx][ny][d]) {
                visited[nx][ny][d] = true;
                d = (d % 2 == 0) ? 2 - d : 4 - d;
                visited[cx][cy][d] = true; // 반대편 방향도 방문 체크
                answer++;
            }
            cx = nx;
            cy = ny;
        }

        return answer;
    }
}
