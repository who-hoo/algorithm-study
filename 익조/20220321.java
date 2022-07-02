import java.util.SortedMap;
import java.util.TreeMap;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        TreeMap<String, Object> map = new TreeMap<>();

        for (String phone : phone_book) {
            map.put(phone, null);
        }

        for (String key : map.keySet()) {
            SortedMap<String, Object> tailMap = map.tailMap(key, false);
            if (!tailMap.isEmpty() && tailMap.firstKey().startsWith(key)) {
                answer = false;
                break;
            }
        }

        return answer;
    }
}
