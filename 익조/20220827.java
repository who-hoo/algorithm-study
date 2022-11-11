class Solution {

    int[][] board;
    int countOfZero = 0, countOfOne = 0;

    public int[] solution(int[][] arr) {
        board = arr;
        int length = arr.length;

        search(0, length, 0, length);

        return new int[]{countOfZero, countOfOne};
    }

    private void search(int rowStart, int rowEnd, int colStart, int colEnd) {
        int countOfZero = 0, countOfOne = 0;
        for (int i = rowStart; i < rowEnd; i++) {
            for (int j = colStart; j < colEnd; j++) {
                if (board[i][j] == 0) countOfZero++;
                else countOfOne++;
            }
        }

        if (countOfZero == 0) {
            this.countOfOne++;
        } else if (countOfOne == 0) {
            this.countOfZero++;
        } else {
            search(rowStart, (rowStart + rowEnd) / 2, colStart, (colStart + colEnd) / 2);
            search(rowStart, (rowStart + rowEnd) / 2, (colStart + colEnd) / 2, colEnd);
            search((rowStart + rowEnd) / 2, rowEnd, colStart, (colStart + colEnd) / 2);
            search((rowStart + rowEnd) / 2, rowEnd, (colStart + colEnd) / 2, colEnd);
        }
    }
}
