package Baekjoon.num5639;

/*
	문제    : BOJ 이진 검색 트리
    유형    : 재귀, 그래프 탐색
	난이도   : EASY (G5)
	시간    : 10m
	uri    : https://www.acmicpc.net/problem/5639
    날짜    : 22.07.16(o)
    refer  :
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}

		void insertNode(int data) {
			if (this.data > data) {
				if (left == null) {
					left = new Node(data);
				} else {
					left.insertNode(data);
				}
			} else {
				if (right == null) {
					right = new Node(data);
				} else {
					right.insertNode(data);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node root = new Node(Integer.parseInt(br.readLine()));

		String line;
		while ((line = br.readLine()) != null) {
			root.insertNode(Integer.parseInt(line));
		}

		postOrder(root);

	}

	private static void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.data);

	}

}
