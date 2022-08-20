package 아더;

import java.util.LinkedList;
import java.util.Queue;

public class PRO_1844_게임맵최단거리 {

    public static void main(String[] args) {
        PRO_1844_게임맵최단거리 pro = new PRO_1844_게임맵최단거리();

        int[][] maps1 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        int[][] maps2 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};

        System.out.println(pro.solution(maps1));
        System.out.println(pro.solution(maps2));
    }

    public int solution(int[][] maps) {
        int answer = -1;
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        // bfs해서 각 위치에 몇칸 떨어졌는지 계산 후 갱신?
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        que.add(0);
        visited[0][0] = true;

        while (!que.isEmpty()) {
            int x = que.poll();
            int y = que.poll();

            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                // 범위 확인
                if (nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length) {
                    continue;
                }
                // 방문 확인
                if (visited[nx][ny]) {
                    continue;
                }
                // 갈 수 있는지 확인
                if (maps[nx][ny] == 0) {
                    continue;
                }

                que.add(nx);
                que.add(ny);
                visited[nx][ny] = true;
                maps[nx][ny] = maps[x][y] + 1;
            }
        }

        if (!visited[maps.length - 1][maps[0].length - 1]) {
            return answer;
        }

        return maps[maps.length - 1][maps[0].length - 1];
    }
}
