public class Solution {
	public static int solution(String s) {
		int answer = 1000;
		int len = s.length();

		if (len == 1) {
			return 1;
		}

		// i 개 만큼 압축한다. 압축은 length / 2 까지 가능하다
		for (int i = 1; i < s.length() / 2; i++) {

			String str = "";
			String compStr = s.substring(0, i);
			int count = 1;

			for (int j = i; j < len; j += i) {

				if (count > 1) {
					str += count + compStr;
				} else {
					str += compStr;
				}
				compStr = s.substring(j);
				count = 1;
				continue;
			}
		}
	}

	public static void main(String[] args) {
		// ababcdcdababcdcd -> 2ab2cd2ab2cd
		// aabbaccc -> 2a2ba3c
		// ababcdcdababcdcd -> 2ababcdcd
		// abcabcdede -> 2abcdede
		// abcabcabcabcdededededede -> 2abcabc2dedede
		// xababcdcdababcdcd -> xababcdcdababcdcd

		String s = "aabbaccc";	// 7
//		2a2ba3c
		System.out.println(solution(s));
	}
}
