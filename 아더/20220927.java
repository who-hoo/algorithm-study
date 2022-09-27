package 아더;

import java.util.Arrays;

public class PRO_43105_정수삼각형 {

    public static void main(String[] args) {
        PRO_43105_정수삼각형 pro = new PRO_43105_정수삼각형();

        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        System.out.println(pro.solution(triangle));
    }

    public int solution(int[][] triangle) {
        int height = triangle.length;
        int[][] DP = new int[height][triangle[height - 1].length];

        DP[0][0] = triangle[0][0];

        for (int i = 1; i < height; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    DP[i][j] = DP[i - 1][j] + triangle[i][j];
                } else if (j == triangle[i].length - 1) {
                    DP[i][j] = DP[i - 1][j - 1] + triangle[i][j];
                } else {
                    DP[i][j] = triangle[i][j] + Math.max(DP[i - 1][j], DP[i - 1][j - 1]);
                }
            }
        }

        return Arrays.stream(DP[height - 1])
            .max()
            .getAsInt();
    }
}
