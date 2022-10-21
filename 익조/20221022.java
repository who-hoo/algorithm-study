class Solution {
    
    public int solution(int[] sticker) {
        int length = sticker.length;

        if (length == 1) {
            return sticker[0];
        } else if (length == 2) {
            return Math.max(sticker[0], sticker[1]);
        }

        int[] memo1 = new int[length], memo2 = new int[length];

        memo1[0] = sticker[0];
        memo1[1] = Math.max(sticker[0], sticker[1]);
        memo2[1] = sticker[1];

        for (int i = 2; i < length; i++) {
            memo1[i] = Math.max(memo1[i - 2] + sticker[i], memo1[i - 1]);
            memo2[i] = Math.max(memo2[i - 2] + sticker[i], memo2[i - 1]);
        }

        return Math.max(memo1[length - 2], memo2[length - 1]);
    }
}
