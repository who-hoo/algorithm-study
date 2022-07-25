package Baekjoon.num3568;

/*
	문제    : BOJ iSharp
    유형    : 구현
	난이도   : EASY (S3)
	시간    : 20m
	uri    : https://www.acmicpc.net/problem/3568
    날짜    : 22.06.25(o)
    refer  :
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line;
		while ((line = br.readLine()) != null) {
			String[] s = line.split(" ");
			String variable = s[0];

			for (int i = 1; i < s.length; i++) {
				String input = s[i].substring(0, s[i].length() - 1);
				if (input.length() == 1) {
					System.out.println(variable + " " + input + ";");
					continue;
				}
				StringBuilder sb = new StringBuilder(variable);
				for (int j = input.length() - 1; j >= 0; j--) {
					char c = input.charAt(j);
					if (c == ']') {
						sb.append("[]");
						j--;
					} else {
						if (c == '*' || c == '&') {
							sb.append(c);
						} else {
							sb.append(' ').append(input.substring(0, j + 1) + ";");
							break;
						}
					}
				}
				System.out.println(sb);
			}

		}
	}

}
