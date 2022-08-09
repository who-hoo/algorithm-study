import java.util.*;

class Solution {
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public int solution(int[][] maps) {
        int answer = bfs(0, 0, maps);
        return answer == 1 ? -1 : answer;
    }
    
    public int bfs(int x, int y, int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        
        while (!q.isEmpty()) {
            int[] xy = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nextX = xy[0] + dx[i];
                int nextY = xy[1] + dy[i];
                if (0 <= nextX && 0 <= nextY && nextX < 5 && nextY < 5 && maps[nextY][nextX] == 1) {
                    maps[nextY][nextX] = maps[y][x] + 1;
                    q.offer(new int[]{nextX, nextY});
                }
            }
        }
        
        return maps[4][4];
    }
}
