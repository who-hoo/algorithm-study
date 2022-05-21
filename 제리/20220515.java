package Programmers.빛의경로사이클;

/*
	문제    : 프로그래머스 빛의 경로 사이클
    유형    : 구현
	난이도   : HARD(level 2)
	시간    : 90m
	uri    : https://programmers.co.kr/learn/courses/30/lessons/86052
    날짜    : 22.05.15(o)
    refer  :
*/


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

	int row;
	int col;
	boolean[][][] visited;
	int[] dx = {0, 0, -1, 1}; //상 하 좌 우
	int[] dy = {1, -1, 0, 0};

	public int[] solution(String[] grid) {
		//TODO: 2022/05/15
		// 상 하 좌 우 (노드에서 나가는 기준) visited를 각 위치별로 가지고 있어야 함
		// 0 1 2 3
		// 계속 돌다가 이미 visitied 곳을 지나가려고 하면 순환 -> 지나온 숫자를 answers에 저장
		// 다시 visited가 false인 곳을 찾아서 돌리기 시작

		List<Integer> answers = new ArrayList<>();

		row = grid.length;
		col = grid[0].length();

		visited = new boolean[row][col][4];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				for (int k = 0; k < 4; k++) {
					if (!visited[i][j][k]) {
						answers.add(findCircle(grid, i, j, k));
					}
				}
			}
		}

		Collections.sort(answers);

		return answers.stream()
			.mapToInt(Integer::intValue)
			.toArray();
	}

	private int findCircle(String[] grid, int i, int j, int k) {
		int count = 0;

		while (true) {
			if (visited[i][j][k]) {
				break;
			}
			count++;
			visited[i][j][k] = true;

			i += dx[k];
			j += dy[k];

			if (i >= row) {
				i = 0;
			}
			if (i < 0) {
				i = row - 1;
			}
			if (j >= col) {
				j = 0;
			}
			if (j < 0) {
				j = col - 1;
			}

			if (grid[i].charAt(j) == 'L') {
				switch (k) {
					case 0: //상
						k = 2; //좌
						break;
					case 1: //하
						k = 3; //우
						break;
					case 2: //좌
						k = 1; //하
						break;
					case 3: //우
						k = 0; //상
						break;
				}
			}

			if (grid[i].charAt(j) == 'R') {
				switch (k) {
					case 0: // 상
						k = 3; // 우
						break;
					case 1: // 하
						k = 2; // 좌
						break;
					case 2: //좌
						k = 0; // 상
						break;
					case 3: // 우
						k = 1; // 하
						break;
				}
			}

		}

		return count;
	}

}

