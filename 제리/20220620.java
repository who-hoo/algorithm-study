package Programmers.피로도;

/*
	문제    : 프로그래머스 피로도
    유형    : 백트래킹(조합)
	난이도   : MEDIUM (level 2)
	시간    : 40m
	uri    : https://programmers.co.kr/learn/courses/30/lessons/87946
    날짜    : 22.06.20(o)
    refer  :
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {

	List<int[]> dungeonSequences = new ArrayList<>();
	boolean[] visited = new boolean[8];
	int[] combi;

	public int solution(int k, int[][] dungeons) {
		int result = 0;

		//todo
		// 던전의 순서를 조합 ex) 1 2 3 4, 1 3 2 4, 1 4 2 3 ...
		// 조합된 순서를 int[]에 담음
		// 조합된 경우의 수를 List<int[]>에 담음
		// k에 따라서
		// 만약 모두 다 돌게 되면 바로 리턴 왜? 어차피 최대 던전의 개수만큼 돈 거니까.

		int dungeonSize = dungeons.length;
		combi = new int[dungeonSize];

		combination(0, dungeonSize);

		for (int[] dungeonSequence : dungeonSequences) {
			int energy = k;
			int count = 0;
			for (int dungeonIndex : dungeonSequence) {
				if (energy >= dungeons[dungeonIndex][0]) {
					energy -= dungeons[dungeonIndex][1];
					count++;
				}
			}
			result = Math.max(result, count);
			if (count == dungeonSize) {
				break;
			}
		}
		return result;
	}

	private void combination(int depth, int dungeonSize) {
		if (dungeonSize == depth) {
			int[] tmp = new int[dungeonSize];
			System.arraycopy(combi, 0, tmp, 0, dungeonSize);
			dungeonSequences.add(tmp);
			return;
		}

		for (int i = 0; i < dungeonSize; i++) {
			if (!visited[i]) {
				visited[i] = true;
				combi[depth] = i;
				combination(depth + 1, dungeonSize);
				visited[i] = false;
			}
		}

	}
  
}
