import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        s = s.replace("{", "");
        s = s.replace("}", "");
        String[] numbers = s.split(",");
        for (String number : numbers) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        int totalCount = map.size();
        int[] answer = new int[totalCount];

        for (String key : map.keySet()) {
            answer[totalCount - map.get(key)] = Integer.parseInt(key);
        }

        return answer;
    }
}
