package Baekjoon.num1987;

/*
	문제    : BOJ 알파벳
    유형    : 백트래킹
	난이도   : HARD(G4)
	시간    : 60m
	uri    : https://www.acmicpc.net/problem/1987
    날짜    : 22.05.19(o)
    refer  :
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1,};
	static int length;
	static int max;
	static int r;
	static int c;
	static boolean[] duplicated;
	static boolean[][] visited;
	static char[][] map;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new char[r][c];
		visited = new boolean[r][c];
    
		for (int i = 0; i < r; i++) {
			String line = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		if (r == 1 && c == 1) {
			System.out.println(1);
			return;
		}

		if (r == 1) {
			if (map[0][0] == map[0][1]) {
				System.out.println(1);
				return;
			}
		}

		if (c == 1) {
			if (map[0][0] == map[1][0]) {
				System.out.println(1);
				return;
			}
		}

		if (map[0][0] == map[1][0] && map[0][0] == map[0][1]) {
			System.out.println(1);
			return;
		}

		duplicated = new boolean[30];


		dfs(0, 0);

		System.out.println(max);

	}

	private static void dfs(int row, int col) {

		length++;
		duplicated[map[row][col] - 'A'] = true;
		visited[row][col] = true;


		for (int i = 0; i < 4; i++) {
			int newRow = row + dx[i];
			int newCol = col + dy[i];

			if (newRow >= 0 && newCol >= 0 && newRow < r && newCol < c) {

				if (!duplicated[map[newRow][newCol] - 'A'] && !visited[newRow][newCol]) {

					dfs(newRow, newCol);
					max = Math.max(max, length);
					length--;

					duplicated[map[newRow][newCol] - 'A'] = false;
				}

			}
		}

		visited[row][col] = false;

	}

}
