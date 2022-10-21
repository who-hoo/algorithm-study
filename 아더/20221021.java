package 아더;

public class PRO_49994_방문길이 {

    public static void main(String[] args) {
        PRO_49994_방문길이 pro = new PRO_49994_방문길이();

        System.out.println(pro.solution("ULURRDLLU"));
        System.out.println(pro.solution("LULLLLLLU"));
    }

    public int solution(String dirs) {
        int answer = 0;
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 북 동 서 남
        boolean[][][] visited = new boolean[11][11][4]; // 마지막은 들어온 방향
        int x = 5;
        int y = 5;

        for (char direction : dirs.toCharArray()) {
            int change = convertDirection(direction);
            int oldX = x;
            int oldY = y;
            x += dir[change][0];
            y += dir[change][1];
            int fromDir = (change + 2) % 4;

            if ((x < 0 || y < 0 || x >= 11 || y >= 11)) {
                x -= dir[change][0];
                y -= dir[change][1];
                continue;
            }
            if (visited[x][y][fromDir] || visited[oldX][oldY][change]) {
                continue;
            }

            visited[x][y][fromDir] = true;
            answer++;
        }

        return answer;
    }

    private int convertDirection(char direction) {
        if (direction == 'U') {
            return 0;
        }
        if (direction == 'R') {
            return 1;
        }
        if (direction == 'D') {
            return 2;
        }
        return 3;
    }

}
