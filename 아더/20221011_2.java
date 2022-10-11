package 아더;

import java.util.Arrays;

public class PRO_77485_행렬테두리회전하기 {

    public static void main(String[] args) {

        PRO_77485_행렬테두리회전하기 pro = new PRO_77485_행렬테두리회전하기();

        int[] rows = {6, 3, 100};
        int[] columns = {6, 3, 97};
        int[][][] queries = {
            {{2,2,5,4},{3,3,6,6},{5,1,6,3}},
            {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}},
            {{1,1,100,97}}
        };

        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(pro.solution(rows[i], columns[i], queries[i])));
        }

    }

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};



        return answer;
    }

}
