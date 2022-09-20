public class N진수게임 {

    public String solution(int n, int t, int m, int p) {
        StringBuilder fullString = new StringBuilder();
        int index = 0;
        int maxIndex = t * m;

        while (index != maxIndex) {
            fullString.append(Integer.toString(index, 0).toUpperCase());
            index++;
        }

        StringBuilder answer = new StringBuilder();

        while (answer.length() < t) {
            answer.append(fullString.toString().charAt(p - 1));
            p += m;
        }

        return answer.toString();
    }


}
