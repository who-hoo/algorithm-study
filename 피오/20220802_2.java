package beakjoon.main_2096;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 내려가기
* 골드5
* dp
* */

public class Main {

    public static int[] board;
    public static int n;
    public static int answer;
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[3];
        int[] dpMax = new int[3];
        int[] dpMin = new int[3];
        int[] temp = new int[3];

        st = new StringTokenizer(br.readLine());
        board[0] = Integer.parseInt(st.nextToken());
        board[1] = Integer.parseInt(st.nextToken());
        board[2] = Integer.parseInt(st.nextToken());

        dpMax[0] = board[0];
        dpMax[1] = board[1];
        dpMax[2] = board[2];

        dpMin[0] = board[0];
        dpMin[1] = board[1];
        dpMin[2] = board[2];

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            board[0] = Integer.parseInt(st.nextToken());
            board[1] = Integer.parseInt(st.nextToken());
            board[2] = Integer.parseInt(st.nextToken());

            temp[0] = board[0] + Math.max(dpMax[0], dpMax[1]);
            temp[1] = board[1] + Math.max(dpMax[0], Math.max(dpMax[1], dpMax[2]));
            temp[2] = board[2] + Math.max(dpMax[1], dpMax[2]);

            dpMax[0] = temp[0];
            dpMax[1] = temp[1];
            dpMax[2] = temp[2];

            temp[0] = board[0] + Math.min(dpMin[0], dpMin[1]);
            temp[1] = board[1] + Math.min(dpMin[0], Math.min(dpMin[1], dpMin[2]));
            temp[2] = board[2] + Math.min(dpMin[1], dpMin[2]);

            dpMin[0] = temp[0];
            dpMin[1] = temp[1];
            dpMin[2] = temp[2];

        }

        int max = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            max = Math.max(max, dpMax[i]);
            min = Math.min(min, dpMin[i]);
        }

        System.out.println(max + " " + min);
    }

}
