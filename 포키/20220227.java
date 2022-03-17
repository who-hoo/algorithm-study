public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                if (sb.indexOf(String.valueOf(s.charAt(j))) == -1) {
                    sb.append(s.charAt(j));
                }else{
                    break;
                }
            }
            result = Math.max(result, sb.length());
        }

        return result;
    }
}