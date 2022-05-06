package Programmers.오픈채팅방;

/*
	문제    : 프로그래머스 오픈채팅방
    유형    : 구현
	난이도   : MEDIUM(level 2)
	시간    : 20m
	uri    : https://programmers.co.kr/learn/courses/30/lessons/42888
    날짜    : 22.05.06(o)
    refer  :
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public String[] solution(String[] record) {
		Map<String, String> user = new HashMap<>();
		List<String> commandLog = new ArrayList<>();
		List<String> idLog = new ArrayList<>();

		for (String s : record) {
			String[] split = s.split(" ");
			String command = split[0];

			if (!command.equals("Change")) {
				idLog.add(split[1]);
				commandLog.add(command);
			}

			if (command.equals("Leave")) {
				continue;
			}

			user.put(split[1], split[2]);
		}

		String[] answer = new String[idLog.size()];

		for (int i = 0; i < idLog.size(); i++) {
			String info = translateToKor(commandLog.get(i));
			answer[i] = user.get(idLog.get(i)) + info;
		}

		return answer;
	}

	private String translateToKor(String command) {
		if (command.equals("Enter")) {
			return "님이 들어왔습니다.";
		}
		return "님이 나갔습니다.";
	}

}

