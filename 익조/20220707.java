import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

    static class Node {
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public int[] solution(String[][] places) {
        int length = places.length;
        int[] answer = new int[length];

        char[][] room = new char[5][5];

        for (int i = 0; i < length; i++) {

            answer[i] = 1;

            String[] place = places[i];

            for (int j = 0; j < place.length; j++) {
                room[j] = place[j].toCharArray();
            }

            boolean flag = false;
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (room[j][k] == 'P') {
                        if (!find(j, k, room)) {
                            answer[i] = 0;
                            flag = true;
                            break;
                        }
                    }
                }
                if (flag) {
                    break;
                }
            }
        }

        return answer;
    }

    private boolean find(int x, int y, char[][] room) {

        boolean[][] visited = new boolean[5][5];
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(new Node(x, y, 0));
        visited[x][y] = true;

        int nx, ny;

        while (!nodes.isEmpty()) {

            Node node = nodes.poll();

            for (int i = 0; i < 4; i++) {
                nx = node.x + dx[i];
                ny = node.y + dy[i];

                if (nx < 0 || nx > 4 || ny < 0 || ny > 4 || visited[nx][ny] || room[nx][ny] == 'X') {
                    continue;
                }

                if (room[nx][ny] == 'P' && node.distance + 1 <= 2) {
                    return false;
                }

                visited[nx][ny] = true;
                nodes.add(new Node(nx, ny, node.distance + 1));
            }
        }

        return true;
    }
}
