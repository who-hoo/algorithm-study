import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

class Solution {
    public int solution(String str1, String str2) {
        // 다중 집합 변환
        List<String> str1MultipleSet = transMultipleSet(str1.toLowerCase());
        List<String> str2MultipleSet = transMultipleSet(str2.toLowerCase());

        // 교집합
        int intersection = getIntersection(str1MultipleSet, str2MultipleSet);

        // 합집합
        int union = getUnion(str1MultipleSet, str2MultipleSet, intersection);

        // 교집합 / 합집합 * 65536
        if (intersection == 0) {
            return union == 0 ? 65536 : 0;
        }
        return (int) ((double) intersection / union * 65536);
    }

    private int getUnion(List<String> str1MultipleSet, List<String> str2MultipleSet, int intersection) {
        return str1MultipleSet.size() + str2MultipleSet.size() - intersection;
    }

    private int getIntersection(List<String> str1MultipleSet, List<String> str2MultipleSet) {
        int intersection = 0;
        boolean[] visited = new boolean[str2MultipleSet.size()];

        for (String s : str1MultipleSet) {
            for (int i = 0; i < str2MultipleSet.size(); i++) {
                if (s.equals(str2MultipleSet.get(i)) && !visited[i]) {
                    visited[i] = true;
                    intersection++;
                    break;
                }
            }
        }
        return intersection;
    }

    private List<String> transMultipleSet(String str) {
        // todo 기타 공백이나 숫자, 특수 문자가 들어있는 경우 그 글자 쌍을 버린다.
        String[] split = str.split("");
        List<String> multipleSet = new ArrayList<>();
        for (int i = 0; i < split.length - 1; i++) {
            // 기타 공백 숫자 특수문자가 없을때에만 add 한다
            // \s 공백, \d 숫자, \S 공백 문자 아닌 나머지 문자
            if (Pattern.matches("^[a-z]*$", split[i])) {
                if (Pattern.matches("^[a-z]*$", split[i + 1])) {
                    multipleSet.add(split[i] + split[i + 1]);
                }
            }

        }
        return multipleSet;
    }

}
