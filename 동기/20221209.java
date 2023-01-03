import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : tangerine) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());

        list.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        int count = 0;
        for (Integer key : list) {
            if (count < k) {
                Integer count1 = map.get(key);
                count += count1;
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }

}

