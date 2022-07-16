package Programmers.단체사진찍기;

/*
	문제    : 단체사진 찍기
    유형    : 구현
	난이도   : HARD (level 2)
	시간    : 60m
	uri    : https://school.programmers.co.kr/learn/courses/30/lessons/1835
    날짜    : 22.07.08(o)
    refer  : 
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {

	List<String> sequences = new ArrayList<>();
	char[] names = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
	boolean[] visited = new boolean[8];

	public int solution(int n, String[] data) {

		dfs("");

		int count = 0;
		for (String sequence : sequences) {
			if (valid(sequence, data)) {
				count++;
			}
		}
		return count;
	}

	private void dfs(String sequence) {
		if (sequence.length() == 8) {
			sequences.add(sequence);
			return;
		}

		for (int i = 0; i < 8; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(sequence + names[i]);
				visited[i] = false;
			}
		}

	}

	private boolean valid(String sequence, String[] data) {
		for (String datum : data) {
			char p1 = datum.charAt(0);
			char p2 = datum.charAt(2);
			char cond = datum.charAt(3);
			int gap = Integer.parseInt(datum.charAt(4) + "");
			if (cond == '=') {
				if (!(Math.abs(sequence.indexOf(p1) - sequence.indexOf(p2)) - 1 == gap)) {
					return false;
				}
			} else if (cond == '>') {
				if (!(Math.abs(sequence.indexOf(p1) - sequence.indexOf(p2)) - 1 > gap)) {
					return false;
				}
			} else if (cond == '<') {
				if (!(Math.abs(sequence.indexOf(p1) - sequence.indexOf(p2)) - 1 < gap)) {
					return false;
				}
			}
		}
		return true;
	}

}
