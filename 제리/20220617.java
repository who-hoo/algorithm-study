package Programmers.메뉴리뉴얼;

/*
	문제    : 메뉴리뉴얼
    유형    : 백트래킹
	난이도   : HARD (level 2)
	시간    : 100m
	uri    : https://programmers.co.kr/learn/courses/30/lessons/72411
    날짜    : 22.06.17(o)
    refer  :
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {

	Map<String, Integer> menuMap = new HashMap<>();
	Map<Integer, Integer> maxOrderMap = new HashMap<>();
	boolean[] visited = new boolean[10];

	public String[] solution(String[] orders, int[] course) {

		for (String order : orders) {
			char[] menus = order.toCharArray();
			Arrays.sort(menus);
			extractMenu(menus, course);
		}

		List<String> answer = new ArrayList<>();
		for (Entry<String, Integer> entry : menuMap.entrySet()) {
			for (int i : course) {
				if (maxOrderMap.getOrDefault(i, 1) == 1) {
					continue;
				}
				if (entry.getKey().length() == i && entry.getValue() == maxOrderMap.get(i)) {
					answer.add(entry.getKey());
				}
			}
		}
		Collections.sort(answer);
		return answer.toArray(new String[0]);
	}

	private void extractMenu(char[] menus, int[] course) {
		for (int i : course) {
			dfs(menus, 0, 0, i);
		}
	}

	private void dfs(char[] menus, int index, int depth, int course) {
		if (depth == course) {
			String answer = "";
			for (int i = 0; i < menus.length; i++) {
				if(visited[i]) {
					answer += menus[i];
				}
			}
			menuMap.put(answer, menuMap.getOrDefault(answer, 0) + 1);
			int max = Math.max(menuMap.get(answer), maxOrderMap.getOrDefault(course, 0));
			maxOrderMap.put(course, max);
			return;
		}

		for (int i = index; i < menus.length; i++) {
			visited[i] = true;
			dfs(menus, i + 1, depth + 1, course);
			visited[i] = false;
		}
	}

}
