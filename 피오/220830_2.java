class Solution {
    
    public static int[][] board;
    public static int zeroCount;
    public static int oneCount;
    
    public int[] solution(int[][] arr) {
        board = arr;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 0) {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }
        }

        iterateArr(0, 0, arr.length);

        return new int[]{zeroCount, oneCount};
    }

    public static void iterateArr(int startX, int startY, int iterLength) {
        if (iterLength == 1) return;
        int zero = 0;
        int one = 0;
        for (int i = startY; i < startY + iterLength; i++) {
            for (int j = startX; j < startX + iterLength; j++) {
                if (board[i][j] == 0) {
                    zero++;
                } else {
                    one++;
                }
            }
        }

        if (zero == 0) {
            oneCount -= Math.pow(iterLength, 2) - 1;
            return;
        }
        if (one == 0) {
            zeroCount -= Math.pow(iterLength, 2) - 1;
            return;
        }

        iterateArr(startX, startY + iterLength / 2, iterLength / 2);
        iterateArr(startX, startY, iterLength / 2);
        iterateArr(startX + iterLength / 2, startY, iterLength / 2);
        iterateArr(startX + iterLength / 2, startY + iterLength / 2, iterLength / 2);
    }
}
