package Programmers.영어끝말잇기;

/*
	문제    : 프로그래머스 영어 끝말잇기
    유형    : 구현
	난이도   : EASY (level 2)
	시간    : 30m
	uri    : https://programmers.co.kr/learn/courses/30/lessons/42583
    날짜    : 22.06.09(o)
    refer  :
*/

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public int[] solution(int n, String[] words) {
		Set<String> usedWords = new HashSet<>();
		boolean isGameOver = false;

		int number = 0;

		String before = words[0];
		String now;
		usedWords.add(before);

		for (int i = 1; i < words.length; i++) {
			now = words[i];
			if (!usedWords.add(now) || before.charAt(before.length() - 1) != now.charAt(0)) {
				isGameOver = true;
				number = i + 1;
				break;
			}
			before = now;
		}

		if (!isGameOver) {
			return new int[]{0, 0};
		}
		return new int[]{(number % n)  == 0 ? n : number % n, (number % n) == 0 ? number / n : number / n + 1};
	}

}
