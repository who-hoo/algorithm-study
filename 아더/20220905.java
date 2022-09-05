package 아더;

import java.util.ArrayList;
import java.util.List;

public class PRO_17677_뉴스클러스터링 {

    public static void main(String[] args) {
        PRO_17677_뉴스클러스터링 pro = new PRO_17677_뉴스클러스터링();

        String str11 = "FRANCE";
        String str12 = "french";
        String str21 = "handshake";
        String str22 = "shake hands";
        String str31 = "aa1+aa2";
        String str32 = "AAAA12";
        String str41 = "E=M*C^2";
        String str42 = "e=m*c^2";
        String str51 = "BAAAA"; // BA AA AA AA
        String str52 = "AAA";   // AA AA

        System.out.println(pro.solution(str11, str12));
        System.out.println(pro.solution(str21, str22));
        System.out.println(pro.solution(str31, str32));
        System.out.println(pro.solution(str41, str42));
        System.out.println(pro.solution(str51, str52)); // 32768
    }

    public int solution(String str1, String str2) {
        int answer = 0;
        List<String> str1Lists = new ArrayList<>();
        List<String> str2Lists = new ArrayList<>();
        double list1Count = 0;
        double list2Count = 0;

        for (int i = 0; i < str1.length() - 1; i++) {
            String sub = str1.substring(i, i + 2);
            if (isAlpha(sub)) {
                str1Lists.add(sub.toLowerCase());
            }
        }
        list1Count = str1Lists.size();

        for (int i = 0; i < str2.length() - 1; i++) {
            String sub = str2.substring(i, i + 2);
            if (isAlpha(sub)) {
                str2Lists.add(sub.toLowerCase());
            }
        }
        list2Count = str2Lists.size();

        double intersectionCount = 0;
        for (String str1List : str1Lists) {
            if (str2Lists.contains(str1List)) {
                intersectionCount++;
                str2Lists.remove(str1List);
            }
        }

        double unionCount = (list1Count + list2Count) - intersectionCount;
        if (unionCount == 0) {
            return 65536;
        }

        answer = (int)((intersectionCount / unionCount) * 65536);

        return answer;
    }

    public static boolean isAlpha(String str) {
        return str != null && str.chars().allMatch(Character::isLetter);
    }
}
