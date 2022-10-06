class Solution {
  
    int[][] map;

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        map = new int[rows][columns];
        boolean[][] visit = new boolean[rows][columns];
        int count = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = count++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(queries[i][0] - 1, queries[i][1] - 1, queries[i][2] - 1, queries[i][3] - 1);
        }
        return answer;
    }

    private int rotate(int x1, int y1, int x2, int y2) {
        // 왼쪽 변부터 반시계 방향 순서로 rotate
        int temp = map[x1][y1];
        int min = Integer.MAX_VALUE;
        for (int i = x1; i < x2; i++) {
            map[i][y1] = map[i + 1][y1];
            min = Math.min(min, map[i][y1]);
        }
        for (int i = y1; i < y2; i++) {
            map[x2][i] = map[x2][i + 1];
            min = Math.min(min, map[x2][i]);
        }
        for (int i = x2; i > x1; i--) {
            map[i][y2] = map[i - 1][y2];
            min = Math.min(min, map[i][y2]);
        }
        for (int i = y2; i > y1 + 1; i--) {
            map[x1][i] = map[x1][i - 1];
            min = Math.min(min, map[x1][i]);
        }
        map[x1][y1 + 1] = temp;
        min = Math.min(min, map[x1][y1 + 1]);

        return min;
    }

}
