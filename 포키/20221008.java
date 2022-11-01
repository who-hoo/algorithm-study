package level2;

public class 행렬_테두리_회전하기 {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = createMap(rows, columns);
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0]-1;
            int y1 = queries[i][1]-1;
            int x2 = queries[i][2]-1;
            int y2 = queries[i][3]-1;

            int curX = x1;
            int curY = y1;
            int endPoint = map[x1 + 1][y1];
            int hold = map[curX][curY];
            int min = hold;
            while (map[x1][y1] != endPoint) {

                if (curY <= y2 && curX == x1) {
                    if (curY == y2) {
                        curX++;
                    } else {
                        curY++;
                    }
                } else if (curY == y2 && curX > x1) {
                    if (curX == x2) {
                        curY--;
                    } else {
                        curX++;
                    }
                } else if (curY <= y2 && curX == x2) {
                    if (curY == y1) {
                        curX--;
                    } else {
                        curY--;
                    }
                } else {
                    curX--;
                }

                int temp = hold;
                hold = map[curX][curY];
                map[curX][curY] = temp;
                min = Math.min(min, temp);
            }
            answer[i] = min;
        }
        return answer;
    }

    public int[][] createMap(int rows, int columns) {
        int n = 1;
        int[][] map = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = n++;
            }
        }
        return map;
    }

}