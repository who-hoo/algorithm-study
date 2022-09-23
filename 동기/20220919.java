import java.util.LinkedList;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();

        String convertedNumeric = "";
        int number = 0;
        while (answer.toString().length() < t) {

            String convert = convert(number, n);
            convertedNumeric += convert;
            if (convertedNumeric.length() > m) {
                String substring = convertedNumeric.substring(p - 1, p);
                answer.append(substring);
                convertedNumeric = convertedNumeric.substring(m);
            }
            number++;
        }

        return answer.toString();
    }

    private String convert(int number, int n) {
        LinkedList<String> linkedList = new LinkedList<>();
        String[] alphabets = new String[]{"A", "B", "C", "D", "E", "F"};
        if (number == 0) {
            return "0";
        }
        while (number > 0) {
            int cal = number % n;
            if (cal >= 10) {
                linkedList.addFirst(alphabets[cal - 10]);
            } else {
                linkedList.addFirst(String.valueOf(cal));
            }

            number /= n;
        }

        StringBuilder str = new StringBuilder();
        for (String s : linkedList) {
            str.append(s);
        }
        return str.toString();
    }

}
