import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        StringBuilder result = new StringBuilder();

        for (int i = 1; i < s.length; i++) {
            int start = 0;
            for (int j = 0; j < s[i].length(); j++) {
                if (!Character.isAlphabetic(s[i].charAt(j))) {
                    start = j;
                    break;
                }
            }
            StringBuilder reverse = new StringBuilder(s[i].substring(start, s[i].length() - 1));
            reverse.reverse();
            result.append(s[0]).append(reverse.toString().replaceAll("]\\[", "[]")).append(" ").append(s[i], 0, start).append(";\n");
        }
        System.out.println(result);
    }
}
