import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] splitInput = input.split(" ");
        String common = splitInput[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < splitInput.length; i++) {
            sb.append(common)
                    .append(parseType(splitInput[i]))
                        .append(" ")
                            .append(parseName(splitInput[i]))
                                .append(";")
                                    .append("\n");
        }
        System.out.println(sb);
    }

    private static String parseType(String param) {
        int length = param.length();
        if (length == 2) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = length - 2; i > 0; i--) {
            char c = param.charAt(i);
            if (c == ']') c = '[';
            else if (c == '[') c = ']';
            if ((65 <= c && c <= 90) || (97 <= c && c <= 122)) break;
            sb.append(c);
        }

        return sb.toString();
    }

    private static String parseName(String param) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < param.length() - 1; i++) {
            char c = param.charAt(i);
            if (c == '[' || c == ']' || c == '*' || c == '&') break;
            sb.append(c);
        }

        return sb.toString();
    }
}
