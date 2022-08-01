package Baekjoon.num2606;

/*
	문제    : BOJ 바이러스
    유형    : bfs, dfs
	난이도   : EASY (S3)
	시간    : 10m
	uri    : https://www.acmicpc.net/problem/2606
    날짜    : 22.06.23(o)
    refer  :
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		int connection = Integer.parseInt(br.readLine());

		boolean[][] map = new boolean[total][total];
		boolean[] visited = new boolean[total];

		for (int i = 0; i < connection; i++) {
			String[] input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]) - 1;
			int end = Integer.parseInt(input[1]) - 1;

			map[start][end] = true;
			map[end][start] = true;
		}

		int count = 0;

		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		visited[0] = true;

		while (!q.isEmpty()) {
			int computer = q.poll();
			for (int i = 0; i < total; i++) {
				if (map[computer][i] && !visited[i]) {
					q.add(i);
					visited[i] = true;
					count++;
				}
			}
		}

		System.out.println(count);

	}

}
