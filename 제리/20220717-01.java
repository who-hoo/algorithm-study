package Baekjoon.num14889;

/*
	문제    : BOJ 스타트와 링크
    유형    : 백트래킹
	난이도   : HARD(S2)
	시간    : 60m
	uri    : https://www.acmicpc.net/problem/14889
    날짜    : 22.07.14(o)
    refer  :
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

	static List<List<Integer>> combi = new ArrayList<>();
	static int n;
	static int[][] s;
	static int min = 987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		s = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				s[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// combi에 0 1 / 0 2 / 1 2
		// 위와 같이 가능한 조합을 구한 후 나중에 구한 플레이어 팀의 조합에서 사용함
		dfs(0, 0, n / 2, 2, new int[2]);

		// 플레이어 팀의 조합을 구한 후 combi에 넣은 값들을 기반으로 경우의 수에 맞게 모두 더함
		dfs2(0, 0, n, n / 2, new int[n / 2]);

		System.out.println(min);

	}

	private static void dfs(int d, int start, int n, int depth, int[] answer) {
		if (d == depth) {
			combi.add(Arrays.stream(answer).boxed().collect(Collectors.toList()));
			return;
		}

		for (int i = start; i < n; i++) {
			answer[d] = i;
			dfs(d + 1, i + 1, n, depth, answer);
		}
	}

	private static void dfs2(int d, int start, int n, int depth, int[] answer) {
		if (d == depth) {
			int team1 = 0;
			int team2 = 0;

			for (List<Integer> list : combi) {
				int tmp1 = list.get(0);
				int tmp2 = list.get(1);
				team1 += s[answer[tmp1]][answer[tmp2]] + s[answer[tmp2]][answer[tmp1]];
			}

			int[] answer2 = new int[n / 2];
			int index = 0;
			for (int i = 0; i < n; i++) {
				int tmp = i;
				if (Arrays.stream(answer).anyMatch(a -> a == tmp)) {
					continue;
				}
				answer2[index++] = i;
			}

			for (List<Integer> list : combi) {
				int tmp1 = list.get(0);
				int tmp2 = list.get(1);
				team2 += s[answer2[tmp1]][answer2[tmp2]] + s[answer2[tmp2]][answer2[tmp1]];
			}

			if (team1 - team2 == 0) {
				System.out.println(0);
				System.exit(0);
			}

			min = Math.min(Math.abs(team1 - team2), min);

			return;
		}

		for (int i = start; i < n; i++) {
			answer[d] = i;
			dfs2(d + 1, i + 1, n, depth, answer);
		}
	}

}
