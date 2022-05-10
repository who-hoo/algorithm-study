package beakjoon.greedy;

import java.util.*;

public class Main_1931 { //회의실 배정

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] meetings = new int[N][2];

        for (int i = 0; i < N; i++) {
            meetings[i][0] = sc.nextInt(); //회의시작 시간
            meetings[i][1] = sc.nextInt(); //회의종료 시간
        }
        Arrays.sort(meetings, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        int prevEndTime = 0;
        int count = 1;
        prevEndTime = meetings[0][1];
        for (int i = 1; i < N; i++) {
            if (meetings[i][0] < prevEndTime) {
                continue;
            }
            prevEndTime = meetings[i][1];
            count++;
        }
        System.out.println(count);
    }

}
