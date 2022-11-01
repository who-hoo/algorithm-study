class Solution {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] d = new int[rows + 1][columns + 1];

        int count = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                d[i][j] = ++count;
            }
        }

        int[] answer = new int[queries.length];
        int rowStart, colStart, rowEnd, colEnd, resultIndex = 0, result = 10001;

        for (int[] query : queries) {
            rowStart = query[0];
            colStart = query[1];
            rowEnd = query[2];
            colEnd = query[3];

            int temp = d[rowStart][colStart];
            result = Math.min(result, temp);

            // left
            for (int i = rowStart; i < rowEnd; i++) {
                d[i][colStart] = d[i + 1][colStart];
                result = Math.min(result, d[i][colStart]);
            }

            // bottom
            for (int i = colStart; i < colEnd; i++) {
                d[rowEnd][i] = d[rowEnd][i + 1];
                result = Math.min(result, d[rowEnd][i]);
            }

            // right
            for (int i = rowEnd; i > rowStart; i--) {
                d[i][colEnd] = d[i - 1][colEnd];
                result = Math.min(result, d[i][colEnd]);
            }

            // top
            for (int i = colEnd; i > colStart; i--) {
                d[rowStart][i] = d[rowStart][i - 1];
                result = Math.min(result, d[rowStart][i]);
            }

            d[rowStart][colStart + 1] = temp;

            answer[resultIndex] = result;
            result = 10001;
            resultIndex++;
        }

        return answer;
    }
}
