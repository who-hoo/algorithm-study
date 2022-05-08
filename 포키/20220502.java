import java.util.*;

public class Tuple {
    public int[] solution(String s) {
        String newS = s.replaceAll("\\{", "").replaceAll("}", "");
        String[] arr = newS.split(",");
        Map<String, Integer> m = new HashMap<>();
        for (String s1 : arr) {
            if (m.containsKey(s1)) {
                int i = m.get(s1);
                m.replace(s1, i + 1);
            } else {
                m.put(s1, 1);
            }
        }

        int[] answer = new int[m.keySet().size()];

        List<Integer> list = m.keySet().stream()
                .sorted((a, b) -> m.get(b) - m.get(a))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }


        return answer;
    }
}
