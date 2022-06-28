import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] strings = br.readLine().split(" ");
        String type = strings[0];
        List<String> arr = new ArrayList<>();

        for (int i = 1; i < strings.length; i++) {
            sb.append(type);
            String[] split = strings[i].split("");
            boolean flag = true;
            for (int j = split.length - 1; j >= 0; j--) {
                if (split[j].equals(",") || split[j].equals(";")) {
                    continue;
                }

                if (split[j].equals("]")) {
                    sb.append("[");
                    continue;
                } else if (split[j].equals("[")) {
                    sb.append("]");
                    continue;
                }

                if (97 <= split[j].charAt(0) && split[j].charAt(0) <= 122 && flag) {
                    flag = false;
                    sb.append(" ");
                }
                sb.append(split[j]);
//                arr.add(split[j]);
            }

            Collections.sort(arr, Collections.reverseOrder());
            sb.append(arr);

            sb.append(";").append("\n");
        }
        System.out.println(sb);
    }

}
