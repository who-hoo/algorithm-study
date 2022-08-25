import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int totalRuntime = 0;
        Queue<String> cache = new LinkedList<>();
        for (String city : cities) {

            if (cacheSize == 0) {
                totalRuntime += 5;
                continue;
            }

            String ignoreCaseString = city.toUpperCase();
            if (cache.contains(ignoreCaseString)) {
                totalRuntime += 1;
                if (cache.size() >= cacheSize) {
                    cache.remove(ignoreCaseString);
                }
            } else {
                totalRuntime += 5;
                if (cache.size() >= cacheSize) {
                    cache.poll();
                }
            }
            cache.offer(ignoreCaseString);
        }
        return totalRuntime;
    }
}
