package Baekjoon.num1916;

/*
	문제    : BOJ 최소비용 구하기
    유형    : 다익스트라
	난이도   : MEDIUM(G5)
	시간    : 50m
	uri    : https://www.acmicpc.net/problem/1916
    날짜    : 22.07.25(o)
    refer  : https://steady-coding.tistory.com/84
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static List<List<Node>> map;
	static int[] answer;

	static class Node implements Comparable<Node> {
		int index;
		int cost;

		public Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		map = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			map.add(new ArrayList<>());
		}
		answer = new int[n + 1];
		Arrays.fill(answer, 987654321);

		StringTokenizer st;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			map.get(start).add(new Node(end, Integer.parseInt(st.nextToken())));
		}

		st = new StringTokenizer(br.readLine());
		dijkstra(Integer.parseInt(st.nextToken()));
		System.out.println(answer[Integer.parseInt(st.nextToken())]);
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[n + 1];
		pq.add(new Node(start, 0));
		answer[start] = 0;

		while (!pq.isEmpty()) {
			Node now = pq.poll();

			if (!visited[now.index]) {
				visited[now.index] = true;

				for (Node node : map.get(now.index)) {
					if (!visited[node.index] && answer[now.index] + node.cost < answer[node.index]) {
						answer[node.index] = answer[now.index] + node.cost;
						pq.add(new Node(node.index, answer[node.index]));
					}
				}

			}

		}

	}
}
