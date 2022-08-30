import java.util.LinkedList;

public class FirstCache {

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if (cacheSize == 0) {
            return 5 * cities.length;
        }
        LinkedList<String> cache = new LinkedList<>();

        for (String c : cities) {
            c = c.toLowerCase();

            if (!cache.contains(c)) {
                if (!(cache.size() < cacheSize)) {
                    cache.removeFirst();
                }
                cache.add(c);
                answer += 5;
            } else {
                cache.remove(c);
                cache.add(c);
                answer++;
            }
        }

        return answer;
    }
}
