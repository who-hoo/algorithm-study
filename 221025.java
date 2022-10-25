package programmers.방문_길이;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution("ULURRDLLU");
//        int answer = solution.solution("LLLLLLLLLL");


        System.out.println(answer);
    }

    public int solution(String dirs) {
        int answer = 0;
        Set<String> pathCheck = new HashSet<>();
        int curr = 55;
        for (int i = 0; i < dirs.length(); i++) {
            int tens = getNextTens(curr, dirs.charAt(i));
            int units = getNextUnits(curr, dirs.charAt(i));
            if (tens < 0 || units < 0) {
                continue;
            }
            String nextStr = String.valueOf(tens) + String.valueOf(units);
            String nc = nextStr + String.valueOf(curr);
            String cn = String.valueOf(curr) + nextStr;
            if (!pathCheck.contains(nc) && !pathCheck.contains(cn)) {
                pathCheck.add(nc);
                pathCheck.add(cn);
                answer++;
            }
            curr = Integer.parseInt(nextStr);
        }
        return answer;
    }

    private int getNextUnits(int curr, char direction) {
        if (direction == 'U') {
            return curr % 10;
        } else if (direction == 'R') {
            if (10 < curr % 10 + 1) {
                return -1;
            }
            return curr % 10 + 1;
        } else if (direction == 'D') {
            return curr % 10;
        } else { // L
            return curr % 10 - 1;
        }
    }

    private int getNextTens(int curr, char direction) {
        if (direction == 'U') {
            if (100 < (curr / 10 + 1) * 10) {
                return -1;
            }
            return (curr / 10 + 1) * 10;
        } else if (direction == 'R') {
            return (curr / 10) * 10;
        } else if (direction == 'D') {
            if ((curr / 10 - 1) * 10 < 0) {
                return -1;
            }
            return (curr / 10 - 1) * 10;
        } else { // L
            return (curr / 10) * 10;
        }
    }
}
