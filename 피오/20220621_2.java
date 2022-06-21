package programmers.피로도;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int result = solution(80, new int[][]{{80,20},{50,40},{30,10}});
    }

    public static int solution(int k, int[][] dungeons) {
        int answer = -1;

        Arrays.sort(dungeons, (e1, e2) -> {
            if (k >= e1[0]) {
                return 
            }
            return 1;
        });

        return answer;
    }
}
