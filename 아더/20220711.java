import java.util.ArrayList;
import java.util.List;

public class Solution {

    static final int FRIENDS_NUM = 8;
    static int answer = 0;
    static int[] selected, used;
    static List<LineCondition> lineConditions;

    static class LineCondition {
        int person1, person2, interval;
        char sign;

        public LineCondition(int person1, int person2, int interval, char sign) {
            this.person1 = person1;
            this.person2 = person2;
            this.interval = interval;
            this.sign = sign;
        }
    }

    public int solution(int n, String[] data) {
        lineConditions = new ArrayList<>();
        used = new int[FRIENDS_NUM + 1];
        selected = new int[FRIENDS_NUM + 1];
        answer = 0;

        // 조건 파싱하기
        for (int i = 0; i < n; i++) {
            lineConditions.add(new LineCondition(convertNameToNumber(data[i].charAt(0)),
                convertNameToNumber(data[i].charAt(2)),
                Character.getNumericValue(data[i].charAt(4)),
                data[i].charAt(3)));
        }

        rec_func(1);

        return answer;
    }

    private void rec_func(int k) {
        if (k == FRIENDS_NUM + 1) {
            // 8개 다 줄 세움
            if (passCondition()) {
                answer++;
            }
        } else {
            // 아직 8개 줄 못세움
            for (int cand = 1; cand <= 8; cand++) {
                if (used[cand] == 1) continue;
                selected[k] = cand;
                used[cand] = 1;
                rec_func(k + 1);
                selected[k] = 0;
                used[cand] = 0;
            }
        }
    }

    private boolean passCondition() {
        for (LineCondition lineCondition : lineConditions) {
            int firstIndex = findIndex(lineCondition.person1);
            int secondIndex = findIndex(lineCondition.person2);
            int diffIndex = Math.abs(firstIndex - secondIndex) - 1;
            if (lineCondition.sign == '<') {
                if (diffIndex >= lineCondition.interval) {
                    return false;
                }
            }
            if (lineCondition.sign == '>') {
                if (diffIndex <= lineCondition.interval) {
                    return false;
                }
            }
            if (lineCondition.sign == '=') {
                if (diffIndex != lineCondition.interval) {
                    return false;
                }
            }
        }
        return true;
    }

    private int findIndex(int personNumber) {
        for (int i = 0; i < selected.length; i++) {
            if (selected[i] == personNumber) {
                return i;
            }
        }

        return 0;
    }

    private int convertNameToNumber(char c) {
        if (c == 'A') return 1;
        if (c == 'C') return 2;
        if (c == 'F') return 3;
        if (c == 'J') return 4;
        if (c == 'M') return 5;
        if (c == 'N') return 6;
        if (c == 'R') return 7;
        return 8;
    }
}
