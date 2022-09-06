package programmers.kakao.뉴스_클러스터링;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("FRANCE", "french"));
    }

    public int solution(String str1, String str2) {
        List<String> s1 = new ArrayList<>();
        List<String> s2 = new ArrayList<>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        for (int i = 0; i < str1.length() - 1; i++) {
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i + 1);
            if (('a' <= c1 && c1 <= 'z') && ('a' <= c2 && c2 <= 'z')) {
                s1.add(str1.substring(i, i + 2).toLowerCase());
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i + 1);
            if (('a' <= c1 && c1 <= 'z') && ('a' <= c2 && c2 <= 'z')) {
                s2.add(str2.substring(i, i + 2).toLowerCase());
            }
        }

        if (s1.size() == 0 && s2.size() == 0) {
            return 65536;
        }

        List<String> union = new ArrayList<>();
        List<String> intersection = new ArrayList<>();

        Collections.sort(s1);
        Collections.sort(s2);

        //교집합
        for (String s : s1) {
            if (s2.remove(s)) { //s1에 s2가 포함되면 s2 요소를 삭제 후 교집합에 추
                intersection.add(s);
            }
            union.add(s);
        }

        //합집합
        for (String s : s2) {
            union.add(s); //교집합 구하고 남은 요소를 합집합에 추가
        }

        double jakard = (double) intersection.size() / union.size();
        return (int) (jakard * 65536);
    }
}
