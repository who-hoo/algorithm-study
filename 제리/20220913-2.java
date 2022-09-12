class Solution {
  
	public String solution(String p) {
		if (p.length() == 0) {
			return "";
		}
		if (isPerfect(p)) {
			return p;
		}

		return findAnswer(p);
	}

	private String findAnswer(String w) {
		if (w.length() == 0) {
			return "";
		}
		StringBuilder answer = new StringBuilder();

		StringBuilder u = new StringBuilder();
		String v = "";

		int c1 = 0;
		int c2 = 0;
		for (int i = 0; i < w.length(); i++) {
			char tmp = w.charAt(i);
			u.append(tmp);

			if (tmp == '(') {
				c1++;
			} else if (tmp == ')') {
				c2++;
			}

			if (c1 == c2) {
				v = w.substring(i + 1);
				break;
			}
		}

		if (isPerfect(u.toString())) {
			return answer.append(u) + findAnswer(v);
		} else {
			answer.append('(').append(findAnswer(v)).append(')');

			StringBuilder reverse = new StringBuilder();
			for (int i = 1; i < u.length() - 1; i++) {
				if (u.charAt(i) == '(') {
					reverse.append(')');
				} else {
					reverse.append('(');
				}
			}
			return answer.append(reverse).toString();
		}
	}

	private boolean isPerfect(String u) {
		int c1 = 0;
		int c2 = 0;
		for (int i = 0; i < u.length(); i++) {
			if (u.charAt(i) == '(') {
				c1++;
			} else if (u.charAt(i) == ')') {
				c2++;
			}
			if (c1 - c2 < 0) {
				return false;
			}
		}
		return true;
	}
}
