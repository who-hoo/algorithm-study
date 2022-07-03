import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		String commonType = input[0];
		for (int i = 1; i < input.length; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(commonType);
			String reversed = new StringBuilder(input[i]).reverse().toString();
			char[] chars = reversed.toCharArray();
			for (int j = 1; j < chars.length; j++) {
				char c = chars[j];
				if (isVarName(c)) {
					sb.append(" ")
						.append(new StringBuilder(reversed.substring(j)).reverse())
						.append(";\n");
					break;
				}
				if (isArray(c)) {
					sb.append("[]");
					j++;
					continue;
				}
				sb.append(c);
			}
			bw.write(sb.toString());
		}
		bw.close();
		br.close();
	}

	static boolean isVarName(char c) {
		return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
	}

	static boolean isArray(char c) {
		return c == ']';
	}
}
