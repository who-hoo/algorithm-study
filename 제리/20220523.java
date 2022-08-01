package Baekjoon.num2468;

/*
	문제    : BOJ 안전 영역
    유형    : dfs
	난이도   : HARD(S1)
	시간    : 120m
	uri    : https://www.acmicpc.net/problem/2468
    날짜    : 22.05.23(o)
    refer  :
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int N;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static boolean[][] visited;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int max = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}

		int maxCount = 0;

		for (int height = 0; height <= max; height++) {
			int cnt = findCountOfIsland(height);
			maxCount = Math.max(maxCount, cnt);
		}
		System.out.println(maxCount);
	}

	private static int findCountOfIsland(int height) {
		int answer = 0;
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] > height) {
					answer += dfs(i, j, height);
				}
			}
		}
		return answer;
	}

	static int dfs(int x, int y, int height) {

		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
				continue;
			}

			if (!visited[nx][ny] && map[nx][ny] > height) {
				dfs(nx, ny, height);
			}

		}
		return 1;
	}
}
