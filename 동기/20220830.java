public class Solution {
    int oneValueCount;
    int zeroValueCount;

    public int[] solution(int[][] arr) {
        int length = arr.length;

        recursive(arr, 0, 0, length);

        return new int[]{zeroValueCount, oneValueCount};
    }

    private void recursive(int[][] arr, int x, int y, int length) {
        // 탈출 조건
      
      
        // 재귀 로직

        if (!checked(arr, x, y, length)) {
          
        } else {
            if (arr[x][y] == 0) {
                zeroValueCount++;
            } else {
                oneValueCount++;
            }
        }

    }

    private boolean checked(int[][] arr, int x, int y, int length) {
        int firstValue = arr[x][y];
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (arr[i][j] != firstValue) {
                    return false;
                }
            }
        }
        return true;
    }
}
