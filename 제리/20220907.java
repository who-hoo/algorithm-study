import java.util.ArrayList;
import java.util.List;

class Solution {
	public int solution(String str1, String str2) {
		List<String> listA = createList(str1);
		List<String> listB = createList(str2);

		int intersection = 0;

		for (String s : listA) {
			if (listB.contains(s)) {
				intersection++;
				listB.remove(s);
			}
		}

		int sum = listA.size() + listB.size();

		if (sum == 0) {
			return 65536;
		}

		return (int) Math.floor(((double) intersection / sum) * 65536);
	}

	private List<String> createList(String input) {

		List<String> list = new ArrayList<>();

		for (int i = 0; i < input.length() - 1; i++) {
			String sub = input.substring(i, i + 2);

			if (sub.chars().allMatch(Character::isLetter)) {
				list.add(sub.toLowerCase());
			}
		}
		return list;
	}
}
