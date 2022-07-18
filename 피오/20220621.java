package programmers.메뉴_리뉴얼;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course = {2, 3, 5};
        List<String> answer = solution(orders, course);
    }

    public static List<String> solution(String[] orders, int[] course) {
        Set<String> ordersSet = new HashSet<>();
        Map<String, Integer> ordersMap = new HashMap<>();

        for (int i = 0; i < orders.length; i++) {
            if (!lengthCheck(orders[i].length(), course)) {
                continue;
            }
            Set<String> keySet = ordersMap.keySet();
            if (keySet.size() == 0) {
                ordersMap.put(orders[i], 1);
                continue;
            }
            Iterator<String> iterator = keySet.iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                if (key.contains(orders[i])) { //orders가 원래 들어간 메뉴에 포함되는 부분메뉴든, 아예 똑같든 이걸로 다 처리 가능.
//                    int count = ordersMap.getOrDefault(orders[i], 0);
                    int count = ordersMap.getOrDefault(key, 0);
                    ordersMap.put(orders[i], count + 1);
                    continue;
                }
            }
        }

        List<String> answerList = new ArrayList<>();
        for (String key : ordersMap.keySet()) {
            if (ordersMap.get(key) >= 2) {
                answerList.add(key);
            }
        }


//        String[] answer = {};
        return answerList;
    }

    private static boolean lengthCheck(int length, int[] course) {
        return Arrays.stream(course).anyMatch(a -> a == length);
    }

}
