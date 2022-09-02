import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

class Solution {

    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        Map<String, Integer> set1 = getMultipleSets(str1);
        Map<String, Integer> set2 = getMultipleSets(str2);
        if (set1.size() == 0 && set2.size() == 0) {
            return 65536;
        }

        int intersectionCount = 0;
        for (String key : set1.keySet()) {
            if (set1.containsKey(key) && set2.containsKey(key)) {
                intersectionCount += Math.min(set1.get(key), set2.get(key));
            }
        }

        int unionCount = 0;
        for (String key : set1.keySet()) {
            if (set2.containsKey(key)) {
                unionCount += Math.max(set1.get(key), set2.get(key));
                set2.remove(key);
            } else {
                unionCount += set1.get(key);
            }
        }

        for (String key : set2.keySet()) {
            unionCount += set2.get(key);
        }

        return (int) Math.floor(( (double) intersectionCount / unionCount) * 65536);
    }

    private Map<String, Integer> getMultipleSets(String str) {
        Map<String, Integer> multipleSets = new HashMap<>();
        Pattern p = Pattern.compile("[^a-zA-Z]");
        String key;
        for (int i = 0; i < str.length() - 1; i++) {
            key = str.substring(i, i + 2);
            if (!p.matcher(key).find()) {
                multipleSets.put(key, multipleSets.getOrDefault(key, 0) + 1);
            }
        }

        return multipleSets;
    }
}
