package beakjoon.main_3568;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main { //iSharp

    private static StringBuilder sb = new StringBuilder();
    private static String commonType;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String variable = br.readLine();
        commonType = variable.split(" ")[0];
        String[] variables = variable.split(", ");
        variables[0] = variables[0].substring(commonType.length() + 1);
        variables[variables.length - 1] = variables[variables.length - 1].substring(0, variables[variables.length - 1].indexOf(";"));

        for (int i = 0; i < variables.length; i++) {
            sb.append(commonType);
            if (variables[i].length() == 1) {
                sb.append(" " + variables[i] + ";\n");
                continue;
            }
            String reversed = new StringBuilder(variables[i].substring(1)).reverse().toString();
            if (reversed.contains("[")) {
                int indexBracketL = reversed.indexOf("[");
                int indexBracketR = reversed.indexOf("]");
                char[] chars = reversed.toCharArray();
                chars[indexBracketL] = ']';
                chars[indexBracketR] = '[';
                reversed = String.valueOf(chars);
            }
            sb.append(reversed);
            sb.append(" " + variables[i].charAt(0) + ";\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();

    }

}
