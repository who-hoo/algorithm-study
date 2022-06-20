import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class Programmers72411 {

	public static Map<String, Integer> courseCandidate;
	public static Set<String> duplicateCheck;

	public static void combine(int n, char[] chars, boolean[] selected, StringBuilder candidate) {
		selected[n] = true;
		candidate.append(chars[n]);
		char[] cur = candidate.toString().toCharArray();
		Arrays.sort(cur);
		String s = String.copyValueOf(cur);
		if (duplicateCheck.add(s)) {
			if (courseCandidate.containsKey(s)) {
				courseCandidate.replace(s, courseCandidate.get(s) + 1);
			} else {
				courseCandidate.put(s, 1);
			}
		}
		for (int i = 0; i < chars.length; i++) {
			if (!selected[i]) {
				combine(i, chars, selected, candidate);
			}
		}
		selected[n] = false;
		candidate.deleteCharAt(candidate.length() -1);
	}

	public String[] solution(String[] orders, int[] course) {
		courseCandidate = new HashMap<>();
		for (String order : orders) {
			duplicateCheck = new HashSet<>();
			char[] chars = order.toCharArray();
			boolean[] selected = new boolean[chars.length];
			combine(0, chars, selected, new StringBuilder());
		}
		courseCandidate.forEach((k, v) -> {
			System.out.println("k = " + k + ", v = " + v);
		});
		System.out.println("=============================");

		ArrayList<String> answer = new ArrayList<>();
		for (int i : course) {
			int max = courseCandidate.entrySet().stream()
				.filter(entry -> entry.getKey().length() == i)
				.map(Entry::getValue)
				.max(Integer::compareTo).orElse(0);
			System.out.println("max = " + max);
			if (max == 0) {
				continue;
			}
			List<String> candidate = courseCandidate.entrySet().stream()
				.filter(entry -> entry.getKey().length() == i)
				.filter(entry -> entry.getValue() == max)
				.map(Entry::getKey)
				.collect(Collectors.toList());
			System.out.println("i = " + i);
			System.out.println("candidate = " + candidate);
			answer.addAll(candidate);
		}
		return answer.toArray(new String[0]);
	}

	public static void main(String[] args) {
		Programmers72411 sol = new Programmers72411();
		String[][] ordersList = new String[][]{
			{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},
			{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"},
			{"XYZ", "XWY", "WXA"}
		};
		int[][] courseList = new int[][]{
			{2, 3, 4},
			{2, 3, 5},
			{2, 3, 4}
		};
		System.out.println(Arrays.toString(sol.solution(ordersList[0], courseList[0])));
	}
}
