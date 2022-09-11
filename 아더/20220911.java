package 아더;

import java.util.LinkedList;
import java.util.Queue;

public class PRO_60058_괄호변환 {

    public static void main(String[] args) {
        PRO_60058_괄호변환 pro = new PRO_60058_괄호변환();

        String p1 = "(()())()";
        String p2 = ")(";
        String p3 = "()))((()"	;
        String p4 = "))))))((((((";
        String p5 = ")()(";

        System.out.println(pro.solution(p1)); // (()())()
        System.out.println(pro.solution(p2)); // ()
        System.out.println(pro.solution(p3)); // ()(())()
        System.out.println(pro.solution(p4));
        System.out.println(pro.solution(p5)); //

    }

    public String solution(String p) {
        String answer = "";

        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다. || 만약 p가 이미 "올바른 괄호 문자열"이라면 그대로 return 하면 됩니다.
        if (p.isEmpty() || isRightString(p)) {
            return p;
        }

        // 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다.
        // 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
        String u = extractBalancedString(p);
        String v = p.substring(u.length());

        // 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
        if (isRightString(u)) {
            answer += u;
            answer += solution(v);
        } else { // 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
            StringBuilder temp = new StringBuilder();
            // 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
            temp.append("(");
            // 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
            temp.append(solution(v));
            // 4-3. ')'를 다시 붙입니다.
            temp.append(")");
            // 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
            if (u.length() > 2) {
                StringBuilder tempBuilder = new StringBuilder();

                for (int i = 1; i < u.length() - 1; i++) {
                    if (u.charAt(i) == '(') {
                        tempBuilder.append(')');
                    } else {
                        tempBuilder.append('(');
                    }
                }
                temp.append(tempBuilder);
            }
            // 4-5. 생성된 문자열을 반환합니다.
            return temp.toString();
        }

        return answer;
    }

    private String extractBalancedString(String p) {
        StringBuilder balancedString = new StringBuilder();

        int count = 0;
        
          for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            balancedString.append(p.charAt(i));
            
            if (count == 0) {
                break;
            }
        }

        return balancedString.toString();
    }
    
    private boolean isRightString(String p) {
        Queue<Character> que = new LinkedList<>();

        for (Character ch : p.toCharArray()) {
            if (ch == '(') {
                que.add(ch);
                continue;
            }
            if (que.size() > 0) {
                que.poll();
            }
        }

        return que.size() == 0;
    }

}
