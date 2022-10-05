import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

class Solution {

    static HashMap<String, Integer> map;

    public ArrayList<String> solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();

        for (int i = 0; i < orders.length; i++) {
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i] = String.valueOf(charArr);
        }

        for (int k : course) {
            map = new HashMap<>();
            int max = Integer.MIN_VALUE;
            for (String order : orders) {
                StringBuilder sb = new StringBuilder();
                if (k <= order.length()) {
                    combi(order, sb, 0, 0, k);
                }
            }
            for (Entry<String, Integer> entry : map.entrySet()) {
                max = Math.max(max, entry.getValue());

            }
            for (Entry<String, Integer> entry : map.entrySet()) {
                if (max >= 2 && entry.getValue() == max) {
                    answer.add(entry.getKey());
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }

    public static void combi(String str, StringBuilder sb, int idx, int cnt, int n) {
        if (cnt == n) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        for (int i = idx; i < str.length(); i++) {
            sb.append(str.charAt(i));
            combi(str, sb, i + 1, cnt + 1, n);
            sb.deleteCharAt(cnt);
        }
    }
}
