package level2;

import java.util.ArrayList;
import java.util.List;

public class 뉴스_클러스터링 {

    public static int UPPER_MAX = 90;
    public static int UPPER_MIN = 65;
    public static int LOWER_MAX = 122;
    public static int LOWER_MIN = 97;

    public int solution(String str1, String str2) {
        int x = 65536;

        List<String> listA = createList(str1);
        List<String> listB = createList(str2);

        double intersection = 0;

        for (int i = 0; i < listA.size(); i++) {
            String s = listA.get(i);
            if (listB.contains(s)) {
                intersection++;
                listB.remove(s);
            }
        }

        double sum = listA.size() + listB.size();

        if (sum == 0) {
            return x;
        }

        return (int) Math.floor((intersection / sum) * x);
    }

    private List<String> createList(String str1) {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            String sub = str1.substring(i, i + 2);

            if (sub.chars().allMatch(this::isChar)) {
                list.add(sub.toLowerCase());
            }
        }
        return list;
    }

    private boolean isChar(int c) {
        return (c >= LOWER_MIN && c <= LOWER_MAX)
            || (c >= UPPER_MIN && c <= UPPER_MAX);
    }

}
