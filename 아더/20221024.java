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
        int[] DP1 = new int[sticker.length];
        int[] DP2 = new int[sticker.length];

        DP1[0] = sticker[0];

        for (int i = 1; i < sticker.length; i++) {
            if (i == 1) {
                DP1[i] = Math.max(sticker[0], sticker[1]);
                DP2[i] = sticker[1];
                continue;
            }
            if (i == sticker.length - 1) {
                DP1[i] = DP1[i - 1];
                DP2[i] = Math.max(DP2[i - 1], DP2[i - 2] + sticker[i]);
                break;
            }
            DP1[i] = Math.max(DP1[i - 1], DP1[i - 2] + sticker[i]);
            DP2[i] = Math.max(DP2[i - 1], DP2[i - 2] + sticker[i]);
        }

        return Math.max(DP1[sticker.length - 1], DP2[sticker.length - 1]);
    }

}
