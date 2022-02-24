class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        else if (s.length() == 1) return 1;

        int result = 0;
        String temp = String.valueOf(s.charAt(0)), nextChar;
        s = s.substring(1);

        while (s.length() > 0) {
            nextChar = String.valueOf(s.charAt(0));
            if (!temp.contains(nextChar)) {
                temp += nextChar;
            }
            else {
                if (temp.substring(temp.length() - 1).equals(nextChar))
                    temp = temp.substring(temp.length() - 1);
                else
                    temp = temp.substring(temp.indexOf(nextChar) + 1) + nextChar;
            }

            s = s.substring(1);

            result = temp.length() > result ? temp.length() : result;

        }

        return result;
    }
}
