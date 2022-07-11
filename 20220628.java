import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] strings = br.readLine().replace(",","").replace(";","").split(" ");
        String type = strings[0];

        for (int i = 1; i < strings.length; i++) {
            String result = type;
            String[] split = strings[i].split("");
            for (int j = split.length - 1; j >= 0; j--) {

                if (split[j].equals("*") || split[j].equals("&")) {
                    result += split[j];
                    continue;
                } else if (split[j].equals("]")) {
                    result += "[";
                    continue;
                } else if (split[j].equals("[")) {
                    result += "]";
                    continue;
                } else {
                    result += " ";
                    for (int k = 0; k <= j; k++) {
                        result += split[k];
                    }
                    break;
                }
            }
            sb.append(result).append(";").append("\n");
        }
        System.out.println(sb);
    }
}
