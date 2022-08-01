import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine().replace(",", "").replace(";", "");
        String[] s = line.split(" ");
        String type = s[0];


        StringBuilder result = new StringBuilder();
        for (int i = 1; i < s.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(type);
            String word = s[i];
            String[] var = word.split("");
            for (int j = var.length - 1; j >= 0; j--) {
                if (var[j].equals("]")) {
                    j--;
                    sb.append("[]");
                } else if(var[j].equals("&") || var[j].equals("*")){
                    sb.append(var[j]);
                }else{
                    sb.append(" " + word.substring(0, j + 1) + ";\n");
                    break;
                }
            }

            result.append(sb);
        }

        System.out.println(result);
    }
}
