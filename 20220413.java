import java.util.HashMap;
import java.util.Map;

public class Solution {

    static int[] addArray = {781, 156, 31, 6, 1}; // 1, 2, 3, 4, 5의 자리 계산
    static Map<Character, Integer> map = new HashMap<>();

    public int solution(String word) {
        int answer = 0;

        map.put('A', 0);
        map.put('E', 1);
        map.put('I', 2);
        map.put('O', 3);
        map.put('U', 4);
        
        for (int i = 0; i < word.length(); i++) {
            answer += (1 + map.get(word.charAt(i)) * addArray[i]);
        }
        return answer;
    }
}
