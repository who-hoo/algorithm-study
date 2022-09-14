package programmers.kakao.괄호_변환;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<String> properBrackets = new ArrayList<>();

    public static void main(String[] args) {
//        System.out.println(solution("()))((()"));
        System.out.println(solution("(()())()"));
    }

    public static String solution(String p) {
        //'(' 의 개수와 ')' 의 개수가 같다면 이를 균형잡힌 괄호 문자열이라고 부릅니다.
        //'('와 ')'의 괄호의 짝도 모두 맞을 경우에는 이를 올바른 괄호 문자열이라고 부릅니다.
        //'균형잡힌 괄호 문자열'의 경우 1~4 스텝을 밟는다.
        proceedSteps(p);
        StringBuilder sb = new StringBuilder();
        for (String bracket : properBrackets) {
            sb.append(bracket);
        }
        return sb.toString();
    }

    public static void proceedSteps(String p) {
        //step1
        //입력이 빈 문자열인 경우, 빈 문자열 반환
        if (p.isEmpty()) {
            return;
        }

        //step2
        //u,v로 분리. u는 균형잡힌 문자열로 더 이상 분리할 수 업성야 함. v는 빈 문자열 가능.
        String[] uv = getBalancedBrackets(p);

        //step3
        //u가 '올바른 괄호'라면 v에 대해서 1단계부터 다시 한다.
        if (isProperBracket(uv[0])) {
            properBrackets.add(uv[0]);
            proceedSteps(uv[1]);
            return;
        }

        //step4
        //u가 '올바른 괄호'가 아니라면 어쩌고저쩌고 한다.
        //4-1 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
        properBrackets.add("(");
        //4-2 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
        proceedSteps(uv[1]);
        //4-3  ')'를 다시 붙입니다.
        properBrackets.add(")");

        //4-4 u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
        String u = uv[0];
        if (2 < u.length()) {
            u = u.substring(1, u.length() - 1);
            properBrackets.add(reverseBracket(u));
        }
    }

    private static String reverseBracket(String u) {
        String reversed = "";
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                reversed += ")";
            } else {
                reversed += "(";
            }
        }
        return reversed;
    }

    public static String[] getBalancedBrackets(String w) {
        int i = 0;
        int open = 0;
        int close = 0;
        String[] brackets = new String[2];

        while (i < w.length()) {
            if (w.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
            if (open == close) {
//                brackets.add()
                brackets[0] = w.substring(0, i + 1);
                brackets[1] = w.substring(i + 1);
                break;
            }
            i++;
        }
        return brackets;
    }

    //문자열 p에서 균형잡힌 문자열을 먼저 찾아낸다.
    public static int getLastIndexOfBalancedWord(String p, int start) {
        int opening = 0;
        int closing = 0;
        for (int i = start; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                opening++;
            } else {
                closing++;
            }
            if (opening == closing) {
                return i;
            }
        }

        return p.length() - 1;
    }

    public static boolean isProperBracket(String balancedBracket) {
        int firstCloseBracketIndex = balancedBracket.indexOf(")");
        if (firstCloseBracketIndex == 0) {
            return false;
        }
        // ')'로 시작하지 않고 길이가 2만 남았다면 올바른 괄호
        if (balancedBracket.length() == 2) {
            return true;
        }

        String pairOfBracketDeleted = balancedBracket.substring(0, firstCloseBracketIndex - 1)
            + balancedBracket.substring(firstCloseBracketIndex + 1);

        return isProperBracket(pairOfBracketDeleted);

    }
}
