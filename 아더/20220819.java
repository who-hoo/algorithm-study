package 아더;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PRO_17680_캐시 {

    public static void main(String[] args) {
        PRO_17680_캐시 pro = new PRO_17680_캐시();

        int cacheSize1 = 3;
        String[] cities1 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        int cacheSize2 = 3;
        String[] cities2 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        int cacheSize3 = 2;
        String[] cities3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris",
            "Jeju", "NewYork", "Rome"};
        int cacheSize4 = 5;
        String[] cities4 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris",
            "Jeju", "NewYork", "Rome"};
        int cacheSize5 = 2;
        String[] cities5 = {"Jeju", "Pangyo", "NewYork", "newyork"};
        int cacheSize6 = 0;
        String[] cities6 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        int cacheSize7 = 0;
        String[] cities7 = {"LA", "LA"};

        System.out.println(pro.solution(cacheSize1, cities1));
        System.out.println(pro.solution(cacheSize2, cities2));
        System.out.println(pro.solution(cacheSize3, cities3));
        System.out.println(pro.solution(cacheSize4, cities4));
        System.out.println(pro.solution(cacheSize5, cities5));
        System.out.println(pro.solution(cacheSize6, cities6));
        System.out.println(pro.solution(cacheSize7, cities7));
    }

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        List<String> caches = new ArrayList<>();

        for (String city : cities) {
            city = city.toLowerCase(Locale.ROOT);
            // 캐시에 있는지 확인
            if (caches.contains(city) && cacheSize != 0) {
                // 있으면 해당 데이터 빼고 실행시간 +1
                caches.remove(city);
                caches.add(city);
                answer += 1;
            } else {
                // 없으면 제일 앞 데이터빼고 뒤에 넣는다 +5
                if (caches.size() >= cacheSize && cacheSize != 0) {
                    caches.remove(0);
                }
                caches.add(city);
                answer += 5;
            }
        }

        return answer;
    }

}
