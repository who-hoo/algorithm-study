import java.util.*;

class Solution {
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
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
                
                if (nextX == 0 && nextY == 0) continue;
                
                if (0 <= nextX && 0 <= nextY && nextX < m && nextY < n && maps[nextY][nextX] == 1) {
                    maps[nextY][nextX] = maps[xy[1]][xy[0]] + 1;
                    q.offer(new int[]{nextX, nextY});    
                }
            }
        }
        
        return maps[n - 1][m - 1];
    }
}
