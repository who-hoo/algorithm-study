public class Solution {

    public static void main(String[] args) {
        String s = "AAAE";
        System.out.println(solution(s));
    }

    private static int solution(String word) {
        int answer = 0;
        int diff = 781;

        char[] alphabet = new char[]{'A', 'E', 'I', 'O', 'U'};

        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < 5; j++) {
                if (alphabet[j] == word.charAt(i)) {
                    answer += 1 + j * diff;
                }
            }
            diff = (diff - 1) / 5;
        }
        return answer;
    }
}
