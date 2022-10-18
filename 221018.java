package programmers.kakao.후보키;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(new String[][]{
            {"100", "ryan", "music", "2"},
            {"200", "apeach", "math", "2"},
            {"300", "tube", "computer", "3"},
            {"400", "con", "computer", "4"},
            {"500", "muzi", "music", "3"},
            {"600", "apeach", "music", "2"}
        });
        System.out.println(answer);
    }

    public int solution(String[][] relation) {
        int answer = 0;
        boolean[] unique = new boolean[relation[0].length];
        for (int i = 0; i < unique.length; i++) {
            unique[i] = true;
        }

        for (int i = 0; i < relation[0].length; i++) {
            Set<String> set = new HashSet<>();
            for (int j = 0; j < relation.length; j++) {
                if (!set.add(relation[j][i])) {
                    unique[i] = false;
                }
            }
        }
        System.out.println(unique);
        return answer;
    }
}
