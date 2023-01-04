package level2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

class 귤고르기 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }

        List<Integer> collect = map.entrySet().stream()
            .sorted((a, b) -> b.getValue() - a.getValue())
            .map(Entry::getKey)
            .collect(Collectors.toList());

        int i = 0;

        while(k > 0) {
            k -= map.get(collect.get(i));
            answer++;
            i++;
        }

        return answer;
    }
}