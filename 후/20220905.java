import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String str1, String str2) {
        List<String> set1 = set(str1);
        List<String> set2 = set(str2);
        int intersection = intersectionCount(new ArrayList<>(set1), new ArrayList<>(set2));
        int union = (set1.size() + set2.size()) - intersection;
        double similarity = jaccardSimilarity(intersection, union);
        return (int) (similarity * 65536);
    }

    /**
     * 입력으로 들어온 문자열을 두 글자씩 끊어서 다중 집합의 원소로 만든다. 
     * 영문으로 된 글자 쌍만 유효(공백, 숫자, 특수문자가 들어 있는 경우 그 글자 쌍을 버림)
     */
    private List<String> set(String str) {
        List<String> set = new ArrayList<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (isAlphabet(chars[i]) && isAlphabet(chars[i + 1])) {
                set.add(str.substring(i, i + 2));
            }
        }
        return set;
    }

    private boolean isAlphabet(char ch) {
        return ('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z');
    }

    private int intersectionCount(List<String> set1, List<String> set2) {
        int count = 0;
        for (String s1 : set1) {
            for (String s2 : set2) {
                if (s1.equalsIgnoreCase(s2)) { // 원소 사이를 비교할 때, 대문자와 소문자의 차이는 무시한다.
                    count++;
                    set2.remove(s2);
                    break;
                }
            }
        }
        return count;
    }

    /**
     * 자카드 유사도 J(A, B) = 두 집합의 교집합 크기를 두 집합의 합집합 크기로 나눈 값 
     * 두 집합이 모두 공집합일 경우에는 나눗셈이 정의되지 않으니 1
     */
    private double jaccardSimilarity(int intersectionCount, int unionCount) {
        if (intersectionCount == 0 && unionCount == 0) {
            return 1;
        }
        return (double) intersectionCount / (double) unionCount;
    }
}
