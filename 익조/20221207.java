import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> countByTangerine = new HashMap<>();
        for (int t : tangerine) {
            countByTangerine.put(t, countByTangerine.getOrDefault(t, 0) + 1);
        }

        List<Integer> stat = new ArrayList<>(countByTangerine.keySet());
        Collections.sort(stat, (o1, o2) -> countByTangerine.get(o2) - countByTangerine.get(o1));

        for (Integer s : stat) {
            answer++;
            Integer count = countByTangerine.get(s);
            if (k > count) {
                k -= count;
            } else {
                break;
            }
        }

        return answer;
    }
}
