package Baekjoon.num2178;

/*
	문제    : BOJ 미로 탐색
    유형    : bfs
	난이도   : MEDIUM (S1)
	시간    : 40m
	uri    : https://www.acmicpc.net/problem/2178
    날짜    : 22.06.14(o)
    refer  :
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		boolean[][] visited = new boolean[n][m];
		int[][] minPath = new int[n][m];
		minPath[0][0] = 1;

		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] {0, 0});
		visited[0][0] = true;

		while (!q.isEmpty()) {
			int[] position = q.poll();
			int x = position[0];
			int y = position[1];

			for (int i = 0; i < 4; i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];

				if (newX < 0 || newX >= n || newY < 0 || newY >= m) {
					continue;
				}

				if (map[newX][newY] == 1 && !visited[newX][newY]) {
					q.add(new int[] {newX, newY});
					minPath[newX][newY] = minPath[x][y] + 1;
					visited[newX][newY] = true;
				}
			}
		}

		System.out.println(minPath[n - 1][m - 1]);

	}

}
