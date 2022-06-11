import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public int[] solution(int n, String[] words) {

        Map<String, Boolean> wordMap = new HashMap<>();

        boolean flag = true;
        int player = 1;
        int turn = 1;
        char presentWord = words[0].charAt(words[0].length() - 1), nextWord;
        wordMap.put(words[0], true);

        for (int i = 1; i < words.length; i++) {
            nextWord = words[i].charAt(0);
            player++;
            if (player > n) {
                player = 1;
                turn++;
            }

            if (wordMap.containsKey(words[i])) {
                flag = false;
                break;
            }

            wordMap.put(words[i], true);

            if (presentWord != nextWord) {
                flag = false;
                break;
            }
            presentWord = words[i].charAt(words[i].length() - 1);
        }

        if (flag) {
            return new int[]{0, 0};
        }

        return new int[]{player, turn};
    }
}
