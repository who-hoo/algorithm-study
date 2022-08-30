public class Solution {
    // 쿼드 트리 : 각 내부 노드에 4개의 자식이 있는 트리 데이터 구조
    // arr 행의 개수는 2의 거듭 제곱수, 1, 2, 4, 8, ..., 1024 중 하나
    // 0번째 행부터 오른쪽으로 숫자를 하나씩 체꾸한다링
    // 압축하고자 하는 영역을 구분해야하기 때문에 첫 압축은 arr.length / 2 가 되겠다.
    // 거기까지 탐색했을 때 숫자가 섞여있지 않으면 ok
    // 가다가 중간에 섞여있으면 행 (그니까 가장 바깥쪽 루프의 탐색 위치를 arr.length / 2 여기로 옮겨버린다
    // 여기서부터 탐색하게 하고
    // 얘도 가다가 섞여있으면 고냥 break;? 해서 다시 돌게........

    // 한 줄 체크해보니 네방향으로 dfs하면 되겠다하는 생각이듦
    // dfs가 아니라 bfs로 네모 하나를 다 돌고
    int oneValueCount;
    int zeroValueCount;

    public int[] solution(int[][] arr) {
        int length = arr.length;

        recursive(arr, 0, 0, length);

        return new int[]{zeroValueCount, oneValueCount};
    }

    private void recursive(int[][] arr, int x, int y, int length) {
        // 탈출 조건
        if (length == 1) {
            if (arr[x][y] == 0) {
                zeroValueCount++;
                return;
            } else {
                oneValueCount++;
                return;
            }
        }
        // 재귀 로직

        if (!checked(arr, x, y, length)) {
            recursive(arr, x, y, length / 2);
            recursive(arr, x, y + length / 2, length / 2);
            recursive(arr, x + length / 2, y, length / 2);
            recursive(arr, x + length / 2, y + length / 2, length / 2);
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
