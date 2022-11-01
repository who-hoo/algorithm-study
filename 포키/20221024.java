package level2;

public class 방문길이 {


    public int solution(String dirs) {
        int startX = 5, startY = 5;
        boolean[][][] visited  = new boolean[11][11][4];

        int result = 0;

        String[] dirsArr = dirs.split("");

        for (int i = 0; i < dirs.length(); i++) {
            Direction direction = Direction.valueOf(dirsArr[i]);

            int newX = startX + direction.dir[0];
            int newY = startY + direction.dir[1];

            if (0 <= newX && newX < 11 && 0 <= newY && newY < 11) {

                if (!visited[newX][newY][direction.index]) {
                    int oppIndex = Direction.valueOf(direction.opposite).index;
                    visited[newX][newY][direction.index] = true;
                    visited[startX][startY][oppIndex] = true;
                    result++;
                }

                startX = newX;
                startY = newY;
            }

        }

        return result;
    }

    enum Direction {
        U(0, new int[]{0, -1}, "D"),
        D(1, new int[]{0, 1}, "U"),
        L(2, new int[]{-1, 0}, "R"),
        R(3,
            new int[]{1, 0}, "L");

        public int index;
        public int[] dir;
        public String opposite;

        Direction(int index, int[] dir, String opposite) {
            this.index = index;
            this.dir = dir;
            this.opposite = opposite;
        }
    }
}
