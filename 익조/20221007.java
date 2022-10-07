class Solution {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] d = new int[rows + 1][columns + 1];
        int[][] origin = new int[rows + 1][columns + 1];

        int count = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                d[i][j] = ++count;
                origin[i][j] = count;
            }
        }

        int[] answer = new int[queries.length];
        int rowStart, colStart, rowEnd, colEnd, resultIndex = 0, result = 10001;

        for (int[] query : queries) {
            rowStart = query[0];
            colStart = query[1];
            rowEnd = query[2];
            colEnd = query[3];

            for (int i = colStart + 1; i <= colEnd; i++) {
                d[rowStart][i] = origin[rowStart][i - 1];
                result = Math.min(result, d[rowStart][i]);
            }

            for (int i = colEnd - 1; i >= colStart; i--) {
                d[rowEnd][i] = origin[rowEnd][i + 1];
                result = Math.min(result, d[rowEnd][i]);
            }

            for (int i = rowStart + 1; i <= rowEnd; i++) {
                d[i][colEnd] = origin[i - 1][colEnd];
                result = Math.min(result, d[i][colEnd]);
            }

            for (int i = rowEnd - 1; i >= rowStart; i--) {
                d[i][colStart] = origin[i + 1][colStart];
                result = Math.min(result, d[i][colStart]);
            }

            deepCopy(d, origin, rows, columns);

            answer[resultIndex] = result;
            result = 10001;
            resultIndex++;
        }

        return answer;
    }

    private void deepCopy(int[][] d, int[][] origin, int row, int col) {
        for (int i = 1; i <= row; i++) {
            if (col >= 0)
                System.arraycopy(d[i], 1, origin[i], 1, col);
        }
    }
}
