package 아더;

public class PRO_12971_스티커모으기2 {

    public static void main(String[] args) {
        PRO_12971_스티커모으기2 pro = new PRO_12971_스티커모으기2();

        int[][] sticker = {
            {14, 6, 5, 11, 3, 9, 2, 10},
            {1, 3, 2, 5, 4},
            {5, 1, 16, 17, 16}
        };

        for (int[] st : sticker) {
            System.out.println(pro.solution(st));
        }
    }

    public int solution(int sticker[]) {
        int[][] DP = new int[sticker.length][2];

        DP[0][0] = sticker[0];
        DP[0][1] = 0;

        for (int i = 1; i < sticker.length; i++) {
            if (i == 1) {
                DP[i][0] = Math.max(sticker[0], sticker[1]);
                DP[i][1] = sticker[1];
                continue;
            }
            if (i == sticker.length - 1) {
                DP[i][0] = DP[i - 1][0];
                DP[i][1] = Math.max(DP[i - 1][1], DP[i - 2][1] + sticker[i]);
                break;
            }
            DP[i][0] = Math.max(DP[i - 1][0], DP[i - 2][0] + sticker[i]);
            DP[i][1] = Math.max(DP[i - 1][1], DP[i - 2][1] + sticker[i]);
        }

        return Math.max(DP[sticker.length - 1][0], DP[sticker.length - 1][1]);
    }

}
