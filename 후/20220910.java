import java.util.Stack;

class Solution {

    public String solution(String p) {
        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if (p.isEmpty()) {
            return "";
        }
        // 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다.
        String[] separatedStr = separate(p);
        StringBuilder u = new StringBuilder(separatedStr[0]);
        String v = separatedStr[1];
        // 3. 문자열 u가 "올바른 괄호 문자열" 이라면,
        if (isValid(u.toString())) {
            // 문자열 v에 대해 1단계부터 다시 수행합니다.
            String convertedV = solution(v);
            // 3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
            return u.append(convertedV).toString();
        }
        // 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
        return getString(u, v);
    }

    // 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다.
    private String[] separate(String w) {
        //  단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
        int leftCnt = 0;
        int rightCnt = 0;
        if (w.charAt(0) == '(') {
            leftCnt++;
        } else {
            rightCnt++;
        }
        for (int i = 1; i < w.length(); i++) {
            if (w.charAt(i) == '(') {
                leftCnt++;
            } else {
                rightCnt++;
            }
            if (leftCnt == rightCnt) {
                return new String[]{w.substring(0, i + 1), w.substring(i + 1)};
            }
        }
        return new String[]{w, ""};
    }

    private boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        stack.push(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            char current = str.charAt(i);
            if (current == ')') {
                if (stack.peek() == ')') {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(current);
            }
        }
        return stack.isEmpty();
    }

    // 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
    private String getString(StringBuilder u, String v) {
        // 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
        StringBuilder answer = new StringBuilder();
        answer.append('(');
        // 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
        answer.append(solution(v));
        // 4-3. ')'를 다시 붙입니다.
        answer.append(')');
        // 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
        u.deleteCharAt(0);
        u.deleteCharAt(u.length() - 1);
        answer.append(u.reverse());
        // 4-5. 생성된 문자열을 반환합니다.
        return answer.toString();
    }
}
