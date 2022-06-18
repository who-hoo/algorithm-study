import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> memories = new HashSet<>();  // 중복 단어를 확인할 Set
        memories.add(words[0]);
        int prevWordCharAscii = words[0].charAt(words[0].length() - 1) - 'a';
        int peopleOrder = 1;
        int turnCount = 1;

        while (true) {
            for (int i = 1; i < words.length; i++) {
                int nowWordCharAscii = words[i].charAt(0) - 'a';

                if (peopleOrder == n) {
                    peopleOrder = 1;
                    turnCount++;
                } else {
                    peopleOrder++;
                }

                if (!memories.add(words[i]) || prevWordCharAscii != nowWordCharAscii) {
                    // 탈락
                    answer[0] = peopleOrder;
                    answer[1] = turnCount;
                    return answer;
                }
                prevWordCharAscii = words[i].charAt(words[i].length() - 1) - 'a';

                memories.add(words[i]);
            }
            answer[0] = 0;
            answer[1] = 0;
            return answer;
        }
    }
} 
