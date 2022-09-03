import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class Solution {

	public int solution(int cacheSize, String[] cities) {
		if (cacheSize == 0) {
			return cities.length * 5;
		}

		int time = 0;
		List<String> cache = new LinkedList<>();

		for (String city : cities) {
			city = city.toLowerCase(Locale.ROOT);
			if (cache.contains(city)) {
				cache.remove(city);
				cache.add(city);
				time += 1;
				continue;
			}

			if (cache.size() < cacheSize) {
				cache.add(city);
			} else {
				cache.remove(0);
				cache.add(city);
			}
			time += 5;
		}

		return time;
	}
}
