package Baekjoon.num11659;

/*
	문제    : BOJ 구간 합 구하기 4
    유형    : 구간 합
	난이도   : EASY (S3)
	시간    : 10m
	uri    : https://www.acmicpc.net/problem/11659
    날짜    : 22.06.07(o)
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
		
		int[] sumArr = new int[N + 1];
		int sum = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			sum += Integer.parseInt(st.nextToken());
			sumArr[i] = sum;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append(sumArr[end] - sumArr[start - 1]).append('\n');
		}

		System.out.println(sb);
		
	}

}
