import java.util.ArrayList;
import java.util.List;

class Solution {

    public int solution(int cacheSize, String[] cities) {
        int runTime = 0;
        List<String> cache = new ArrayList<>();

        for (String city : cities) {
            city = city.toLowerCase();
            if (cache.contains(city)) {
                runTime += 1;
                cache.remove(city);
                cache.add(city);
            } else {
                runTime += 5;
                if (cache.size() >= cacheSize && cache.size() != 0) {
                    cache.remove(0);
                }
                if (cacheSize != 0) {
                    cache.add(city);
                }
            }
        }

        return runTime;
    }
}
