class Solution {
    
    private static int[][] board;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        board = new int[rows][columns];
        int boardNum = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = boardNum++;
            }
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(queries[i]);
        }

        return answer;
    }

    public int rotate(int[] query) {
        int startY = query[0] - 1;
        int startX = query[1] - 1;
        int endY = query[2] - 1;
        int endX = query[3] - 1;
        int startPoint = board[startY][startX];
        int min = startPoint;

        //왼쪽
        for(int i = startY + 1; i <= endY; i++) {
            min = Math.min(min, board[i][startX]);
            board[i - 1][startX] = board[i][startX];
        }
        //위쪽
        for(int i = startX + 1; i <= endX; i++) {
            min = Math.min(min, board[endY][i]);
            board[endY][i - 1] = board[endY][i];
        }
        //오른쪽
        for(int i = endY - 1; i >= startY; i--) {
            min = Math.min(min, board[i][endX]);
            board[i + 1][endX] = board[i][endX];
        }
        //아래쪽
        for(int i = endX - 1; i > startX; i--) {
            min = Math.min(min, board[startY][i]);
            board[startY][i + 1] = board[startY][i];
        }
        board[startY][startX + 1] = startPoint;
        return min;
    }
}
