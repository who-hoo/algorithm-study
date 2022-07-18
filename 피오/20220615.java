import java.util.*;

class Solution {
    
    private static Set<String> wordSet = new HashSet<>();
    
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        wordSet.add(words[0]);
        char lastChar = words[0].charAt(words[0].length() - 1);
        int count = 0;
        for (int i = 1; i < words.length; i++) {
            if (!checkIsAnswerRight(words[i], lastChar)) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            lastChar = words[i].charAt(words[i].length() - 1);
        }

        return answer;
    }
    
    public static boolean checkIsAnswerRight(String word, char lastChar) {
        return wordSet.add(word) && lastChar == word.charAt(0);
    }
}
