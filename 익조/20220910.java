class Solution {

    public String solution(String p) {
        if (p.isEmpty()) return p;

        String[] result = splitBracket(p);
        if (verify(result[0])) {
            return result[0] += solution(result[1]);
        }
        else {
            return "(" + solution(result[1]) + ")" + reverseString(result[0]);
        }
    }
    
    private String[] splitBracket(String p) {
        String[] result = new String[]{"", ""};
        char[] brackets = p.toCharArray();
        int count = 0;

        for (int i = 0; i < brackets.length; i++) {
            if (brackets[i] == '(') {
                count++;
                result[0] += "(";
            }
            else {
                count --;
                result[0] += ")";
            }
            if (count == 0) {
                if (i != brackets.length - 1)
                    result[1] = p.substring(i + 1);
                break;
            }
        }

        return result;
    }

    private boolean verify(String p) {
        char[] chars = p.toCharArray();
        int count = 0;

        for (char aChar : chars) {
            if (aChar == '(')
                count++;
            else
                count--;

            if (count < 0) {
                return false;
            }
        }

        return true;
    }

    private String reverseString(String p) {
        String temp = p.substring(1, p.length() - 1);
        StringBuilder sb = new StringBuilder();
        char[] chars = temp.toCharArray();
        for (char c : chars) {
            if (c == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }

        return sb.toString();
    }
}
