package Baekjoon.num1238;

/*
	문제    : BOJ 파티
    유형    : 플로이드 와샬, 다익스트라(다익스트라 풀이 실패)
	난이도   : 플로이드 와샬 -> MEDIUM / 다익스트라 -> HARD (G3)
	시간    : 90m
	uri    : https://www.acmicpc.net/problem/1238
    날짜    : 22.05.11(o)
    refer  :
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		int[][] map = new int[N + 1][N + 1];

		int INF = 987654321;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) {
					continue;
				}
				map[i][j] = INF;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());

			map[start][end] = Math.min(map[start][end], t);
		}

		//TODO: 2022/05/11
		// 각각의 노드에서 X까지 가는 데 필요한 최소 시간을 구하고 -> 플로이드 와샬?
		// X에서 각각의 노드에 가는 데 필요한 최소 시간을 구한 뒤 -> 다익스트라 알고리즘
		// 두 개의 최소 시간을 노드별로 더해서 최대값을 찾아 출력하면 된다.
		// 각각의 노드에서 X까지 가는 데 필요한 최소 시간은 어떻게 구할까?

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}

		int answer = 0;
		for (int i = 1; i <= N; i++) {
			answer = Math.max(answer, map[i][X] + map[X][i]);
		}

		System.out.println(answer);

	}

}

