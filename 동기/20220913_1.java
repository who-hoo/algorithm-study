public class Solution {
    String answer;

    public String solution(String p) {
        // p를 문자열 u, v로 나눈다.
            // 문자열 u 는 괄호 개수가 맞을때
            // 문자열 v 는 문자열 u 만들고 나머지, 그 나머지가 빈 문자열이 될 수도 있음
        String[] answerArr = new String[2];
        answer = "";
        answerArr[0] = answer;
        answerArr[1] = p;

        divide(answerArr);
        return answer;
    }

    private String[] divide(String[] p) {
        // todo string v 가 빈 문자열이될때까지 recursive
//        String stringU = "";
        String stringV = "";
        int openCount = 0;
        int closeCount = 0;

        char[] chars = p[1].toCharArray();
        if (chars[0] == '(') {
            openCount++;
        } else {
            closeCount++;
        }

        int copyI = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '(') {
                openCount++;
            } else {
                closeCount++;
            }

            if (openCount == closeCount) {
                copyI = i + 1;
                break;
            }
        }

        answer += p[1].substring(0, copyI);
        stringV = p[1].substring(copyI);

        // 문자열 v가 ( ) 개수가 같고 짝도 맞는지 체크
        // 그렇다면 그대로 answer에 이어붙이고 반환
        // 아니라면 이제 recursive
        // 빈 문자열에 (
        // todo 첫번째, 마지막 문자 제거 후 나머지 문자열 방향 뒤집는 로직 추가

        openCount = 0;
        closeCount = 0;
        chars = stringV.toCharArray();
        if (chars[0] == '(') {
            openCount++;
        } else {
            closeCount++;
        }

        for (int i = 1; i < chars.length; i++) {

        }

//        String str = stringV.substring(1, stringV.length() - 1);

        p[0] = answer;
        p[1] = stringV;

        // 탈출조건
        // strinvV 가 빈 문자열이면 recursive 탈출
        if (stringV.equals("")) {
            return new String[]{answer, stringV};
        }

        // stringV를 recursive
        return divide(p);
    }
}
