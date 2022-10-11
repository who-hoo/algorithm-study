import java.util.Arrays;

public class Solution {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] arr = initArray(rows, columns);
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int min = Integer.MAX_VALUE;
            int startRow = queries[i][0];
            int startCol = queries[i][1];
            int endRow = queries[i][2];
            int endCol = queries[i][3];

            // TODO: arr 돌려돌려
            answer[i] = min;
        }

        return answer;
    }

    private int[][] initArray(int rows, int columns) {
        int[][] arr = new int[rows][columns];
        int num = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                arr[row][col] = num++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Programmers77485 sol = new Programmers77485();

        int[] rows = new int[]{6, 3, 100};
        int[] columns = new int[]{6, 3, 97};
        int[][][] queries = new int[][][]{
            {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}},
            {{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}},
            {{1, 1, 100, 97}}
        };

        for (int i = 0; i < rows.length; i++) {
            System.out.println(
                Arrays.toString(
                    sol.solution(rows[i], columns[i], queries[i])
                )
            );
        }
    }
}
