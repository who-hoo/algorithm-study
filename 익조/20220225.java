class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        else if (s.length() == 1) return 1;

        int result = 0;
        String temp = String.valueOf(s.charAt(0));
        s = s.substring(1);

        while (s.length() > 0) {
            if (!temp.contains(String.valueOf(s.charAt(0)))) {
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("abcabcbb : " + solution.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println("bbbbbb : " + solution.lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println("pwwkew : " + solution.lengthOfLongestSubstring("pwwkew")); // 3
        System.out.println("aab : " + solution.lengthOfLongestSubstring("aab")); // 2
        System.out.println("dvdf : " + solution.lengthOfLongestSubstring("dvdf")); // 3
        System.out.println("anviaj : " + solution.lengthOfLongestSubstring("anviaj")); // 5
        System.out.println("ckilbkd : " + solution.lengthOfLongestSubstring("ckilbkd")); // 5
    }
}
