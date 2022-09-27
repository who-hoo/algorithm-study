public class Solution2 {

    int zero = 0;
    int one = 0;

    public int[] solution(int[][] arr) {

        recursive(arr, 0, 0, arr.length);

        return new int[]{zero, one};
    }

    private void recursive(int[][] arr, int x, int y, int length) {
        // 탈출 조건
        if (length == 1) {
            if (arr[x][y] == 0) {
                zero++;
                return;
            } else {
                one++;
                return;
            }
        }

        // 재귀 로직
        // 순회해서 같은 숫자가 아니면 쿼드 압축
        if (!check(arr, x, y, length)) {
            recursive(arr, x, y, length / 2);
            recursive(arr, x + length / 2, y, length / 2);
            recursive(arr, x, y + length / 2, length / 2);
            recursive(arr, x + length / 2, y + length / 2, length / 2);
        } else {
            if (arr[x][y] == 0) {
                zero++;
            } else {
                one++;
            }
        }

    }

    private boolean check(int[][] arr, int x, int y, int length) {
        int firstValue = arr[x][y];
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                // 순회하다가 첫번째 숫자와 다른 숫자가 나오면 압축 불가
                if (arr[i][j] != firstValue) {
                    return false;
                }
            }
        }
        return true;
    }

}
