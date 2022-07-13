class Solution {
	int answer;
	char[] friends;
	char[] current;
	boolean[] visited;

	public int solution(int n, String[] data) {
		init();
		search(0, data);
		return answer;
	}

	private void init() {
		answer = 0;
		friends = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
		current = new char[8];
		visited = new boolean[8];
	}

	private void search(int cnt, String[] conditions) {
		if (cnt == 8) {
			if (isValid(conditions)) {
				answer++;
			}
			return;
		}

		for (int i = 0; i < 8; i++) {
			if (!visited[i]) {
				visited[i] = true;
				current[cnt] = friends[i];
				search(cnt + 1, conditions);
				visited[i] = false;
			}
		}
	}

	private boolean isValid(String[] conditions) {
		for (String condition : conditions) {
			char from = condition.charAt(0);
			char to = condition.charAt(2);
			char operator = condition.charAt(3);
			int interval = condition.charAt(4) - '0';

			int distance = Math.abs(String.valueOf(current).indexOf(from) - String.valueOf(current).indexOf(to)) - 1;
			switch (operator) {
				case '=':
					if (distance != interval) {
						return false;
					}
					break;
				case '<':
					if (distance >= interval) {
						return false;
					}
					break;
				case '>':
					if (distance <= interval) {
						return false;
					}
					break;
				default:
					break;
			}
		}
		return true;
	}
}
