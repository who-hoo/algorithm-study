package programmers.교점에_별_만들기;

public class Solution {

    public static void main(String[] args) {

    }

    public static String[] solution(int[][] line) {
        for (int i = 0; i < line.length; i++) {
            int a1 = line[i][0];
            int b1 = line[i][1];
            int c1 = line[i][2];

            for (int j = i + 1; j < line.length; j++) {
                int a2 = line[i][0];
                int b2 = line[i][1];
                int c2 = line[i][2];

                int intersectionX = (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
                int intersectionY = -(a1 / b1) * (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1) - (c1 / b1);
            }
        }
        String[] answer = {};
        return answer;
    }

}
