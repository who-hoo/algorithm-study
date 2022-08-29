package programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers68936 {

    public int[] solution(int[][] arr) {
        int[] answer = {0, 0};
        Queue<int[][]> queue = new LinkedList<>();
        queue.add(arr.clone());
        while (!queue.isEmpty()) {
            int[][] array = queue.poll();
            if (array.length == 1) {
                answer[array[0][0]]++;
                continue;
            }
            if (isAllSameNumber(array)) {
                answer[array[0][0]]++;
            } else {
                for (int i = 0; i < 4; i++) {
                    queue.add(divide(array, i));
                }
            }
        }
        return answer;
    }

    private int[][] divide(int[][] arr, int n) {
        // 뭔가 수학자가 되어서,,, 쪼개기
        if (n == 0) {
            return new int[0][0];
        } else if (n == 1) {
            return new int[0][0];
        } else if (n == 2) {
            return new int[0][0];
        } else {
            return new int[0][0];
        }
    }

    private boolean isAllSameNumber(int[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[0][0] != arr[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    private void print(int[][] arr) {
        for (int[] ints : arr) {
            for (int i : ints) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Programmers68936 sol = new Programmers68936();
        int[][][] arr = {
            {{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}},
            {{1, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 1, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 1, 1, 1, 1}}
        };
        for (int[][] ints : arr) {
            System.out.println(Arrays.toString(sol.solution(ints)));
        }
    }
}
