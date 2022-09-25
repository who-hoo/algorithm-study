package 아더;

public class PRO_17687_n진수게임 {

    public static void main(String[] args) {
        PRO_17687_n진수게임 pro = new PRO_17687_n진수게임();

        int n1 = 2; int t1 = 4; int m1 = 2; int p1 = 1;
        int n2 = 16; int t2 = 16; int m2 = 2; int p2 = 1;
        int n3 = 16; int t3 = 16; int m3 = 2; int p3 = 2;

        System.out.println(pro.solution(n1, t1, m1, p1));
        System.out.println(pro.solution(n2, t2, m2, p2));
        System.out.println(pro.solution(n3, t3, m3, p3));
    }

    public String solution(int n, int t, int m, int p) {
        StringBuilder preBuilder = new StringBuilder();
        StringBuilder answerBuilder = new StringBuilder();
        int number = 0;
        int maxLength = t * m;

        while (preBuilder.length() <= maxLength + m) {
            if (answerBuilder.length() == t) {
                break;
            }
            preBuilder.append(Integer.toString(number++, n).toUpperCase());
        }

        int count = p;
        while (answerBuilder.length() != t) {
            answerBuilder.append(preBuilder.charAt(count - 1));

            count += m;
        }

        return answerBuilder.toString();
    }

}
