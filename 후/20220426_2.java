class Solution {
    public String compress(String s, int unit) {
        StringBuilder result = new StringBuilder();
        int cnt = 1;
        String prev = s.substring(0, unit);
        for (int i = unit; i < s.length(); i += unit) {
            try {
                String current = s.substring(i, i + unit);
                if (current.equals(prev)) {
                    cnt++;
                } else {
                    if (cnt == 1) {
                        result.append(prev);
                    } else {
                        result.append(cnt).append(prev);
                    }
                    cnt = 1;
                    prev = current;
                }
            } catch (IndexOutOfBoundsException e) {
                result.append(s.substring(i));
                cnt = 1;
                prev = "";
            }
        }
        if (cnt == 1) {
            result.append(prev);
        } else {
            result.append(cnt).append(prev);
        }
        if (s.length() % unit > 0) {
            result.append(s.substring(s.length() - unit));
        }
        return result.toString();
    }

    public int solution(String s) {
        int min = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            String compressed = compress(s, i);
            min = Math.min(min, compressed.length());
        }
        return min;
    }
}
