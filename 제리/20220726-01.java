package Baekjoon.num1405;

/*
	문제    : BOJ 미친 로봇
    유형    : dfs
	난이도   : MEDIUM(G5)
	시간    : 20m
	uri    : https://www.acmicpc.net/problem/1405
    날짜    : 22.07.24(o)
    refer  :
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static boolean[][] map;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static double[] percent = new double[4];
	static double answer;
	static double[] sequence;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		percent[0] = Double.parseDouble(st.nextToken()) * 0.01;
		percent[1] = Double.parseDouble(st.nextToken()) * 0.01;
		percent[2] = Double.parseDouble(st.nextToken()) * 0.01;
		percent[3] = Double.parseDouble(st.nextToken()) * 0.01;

		map = new boolean[2 * n + 1][2 * n + 1];
		sequence = new double[n];

		map[n][n] = true;
		dfs(n, n, 0);
		System.out.println(answer);
	}

	private static void dfs(int x, int y, int depth) {
		if (depth == n) {
			double tmp = 1;
			for (double s : sequence) {
				tmp *= s;
			}
			answer += tmp;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			if (!map[newX][newY]) {
				sequence[depth] = percent[i];
				map[newX][newY] = true;
				dfs(newX, newY, depth + 1);
				map[newX][newY] = false;
			}
		}

	}

}
