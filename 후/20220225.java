class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> charSet = new HashSet<>();
        ArrayList<String> substrings = new ArrayList<>();
        char[] input = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int startIndex = 0;
        int currentIndex = 0;
        while (currentIndex < input.length) {
            if (charSet.add(input[currentIndex])) {
                sb.append(input[currentIndex]);
                currentIndex++;
            } else {
                substrings.add(sb.toString());
                sb.delete(0, sb.length());
                charSet.clear();
                currentIndex = ++startIndex;
            }
        }
        substrings.add(sb.toString());
        Collections.sort(substrings, (str1, str2) -> str2.length() - str1.length());
        return substrings.get(0).length();
    }
}
