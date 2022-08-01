package Programmers.튜플;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {

	/**
	 셀 수 있는 수량의 순서있는 열거 또는 어떤 순서를 따르는 요소들의 모음을 튜플이라고 한다.
	 n 개의 요소를 가진 튜플을 n-튜플이라고 한다. (a1, a2, a3, ..., an)

	 튜플은 다음과 같은 성질을 가지고 있다.
	 1. 중복된 원소가 있을 수 있다. ex) 2, 3, 1, 2
	 2. 원소에 정해진 순서가 있으며, 원소의 순서가 다르면 서로 다른 튜플이다. ex) (1, 2, 3,) != (1, 3, 2)
	 3. 튜플의 원소 개수는 유한하다.

	 튜플 : (2, 1, 3, 4)
	 - {{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}
	 - {{2, 1, 3, 4}, {2}, {2, 1, 3}, {2, 1}}
	 - {{1, 2, 3}, {2, 1}, {1, 2, 4, 3}, {2}}
	 는 모두 같은 튜플 (2, 1, 3, 4)를 나타낸다.


	 */

	public static int[] solution(String s) {
		int[] answer = {};

		Map<Integer, Integer> arr = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {

			if (Character.isDigit(s.charAt(i))) {
				int numericValue = Character.getNumericValue(s.charAt(i));
//				System.out.println(numericValue);

				arr.put(numericValue, 0);
				Integer integer = arr.get(numericValue) + 1;
				System.out.println(integer);
				arr.put(numericValue, integer++);

			}
		}

		List<Entry<Integer, Integer>> list = new ArrayList<>(arr.entrySet());
		list.sort(Entry.comparingByValue());
		list.forEach(System.out::println);

		return answer;
	}

	public static void main(String[] args) {
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		System.out.println(Arrays.toString(solution(s)));
	}
}
