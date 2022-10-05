package level2;

import java.util.*;
import java.util.stream.Collectors;

public class MenuRenewal {

    public static Map<String, Integer> map = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();


        int maxLength = Arrays.stream(orders)
                .max(Comparator.comparingInt(String::length))
                .get()
                .length();
        List<Integer> courses = Arrays.stream(course)
                .filter(s -> s <= maxLength)
                .boxed()
                .collect(Collectors.toList());

        Arrays.sort(orders);

        for (int i = 0; i < orders.length; i++) {
            char[] word = orders[i].toCharArray();
            Arrays.sort(word);
            orders[i] = word.toString();
        }

        for (int i = 0; i < courses.size(); i++) {
            int type = courses.get(i);

            for (int j = 0; j < orders.length; j++) {
                String cur = orders[j];
                if (cur.length() < type) {
                    continue;
                }

                //단어를 type 길이가 되도록 조합한다.
                StringBuilder sb = new StringBuilder();
                recursion(sb, type);

            }
        }


        return null;
    }

    public void recursion(StringBuilder word, int type) {
        if (word.length() == type) {
            //조합한 단어가 map에 있으면 1증가, 없으면 저장 및 1로 초기화
            if (map.containsKey(word.toString())) {
                map.put(word.toString(), map.get(word) + 1);
            } else {
                map.put(word.toString(), 1);
            }
            return;
        }

        //ACEX
        //현재 단어에서 누적해서 더해야한다
        //-> A
        //AC -> ACE ->ACX
        //AE -> AEX
        //AX
        //CE -> CEX

    }

}

//최소 2명 이상이 주문한 음식구성만 코스로 등록할 수 있다.
//course의 숫자들 중에서 orders의 주문개수보다 더 큰 값들은 만들어낼 수 없는 조합이다.
//orders를 길이가 짧은 것 순서대로 나열한다.
//orders의 요소들도 정렬을 한다.
//각 요소들에 대해서 조합을 만들어서 HashMap에 등록한다. (길이는 course에 나온 숫자들 기준)
//같은 조합이 2개 이상이라면 answer list에 담는다.



