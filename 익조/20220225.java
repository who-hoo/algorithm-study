class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        else if (s.length() == 1) return 1;

        int result = 0;
        String temp = String.valueOf(s.charAt(0));
        s = s.substring(1);

        while (s.length() > 0) {
            if (!temp.contains(String.valueOf(s.charAt(0)))) { // 마지막 글자가 다음 글자와 같은 경우
                temp += String.valueOf(s.charAt(0));
            }
            else {
                if (temp.substring(temp.length() - 1).equals(String.valueOf(s.charAt(0))))
                    temp = temp.substring(temp.length() - 1);
                else
                    temp = temp.substring(temp.indexOf(String.valueOf(s.charAt(0))) + 1) + s.charAt(0);
            }

            s = s.substring(1);

            result = temp.length() > result ? temp.length() : result;

        }

        return result;
    }
}
