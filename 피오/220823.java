import java.util.LinkedList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        LinkedList<String> cache = new LinkedList<>();
        for (int i = 0; i < cities.length; i++) {
            if (!cache.contains(cities[i].toLowerCase())) {
                cache.addFirst(cities[i].toLowerCase());
                answer += 5;
                
                if (cache.size() > cacheSize) {
                    cache.removeLast();
                }
                continue;
            }
            
            int cityIndex = cache.indexOf(cities[i].toLowerCase());
            answer += 1;
            cache.remove(cityIndex);
            cache.addFirst(cities[i].toLowerCase());
        }
        
        return answer;
    }
}
