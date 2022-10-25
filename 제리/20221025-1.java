import java.util.HashSet;
import java.util.Set;

class Solution {

	public int solution(String dirs) {
		Set<String> set = new HashSet<>();

		int len = dirs.length();

		int nowX = 0;
		int nowY = 0;

		for (int i = 0; i < len; i++) {
			int nextX = nowX;
			int nextY = nowY;
			String road = "";

			if (dirs.charAt(i) == 'U') {
				nextY++;
				road += nowX;
				road += nowY;
				road += nextX;
				road += nextY;
			}
			else if (dirs.charAt(i) == 'D') {
				nextY--;
				road += nextX;
				road += nextY;
				road += nowX;
				road += nowY;
			}
			else if (dirs.charAt(i) == 'R') {
				nextX++;
				road += nowX;
				road += nowY;
				road += nextX;
				road += nextY;
			}
			else if (dirs.charAt(i) == 'L') {
				nextX--;
				road += nextX;
				road += nextY;
				road += nowX;
				road += nowY;
			}

			//범위 벗어나면 무시
			if (nextX < -5 || nextY < -5 || nextX > 5 || nextY > 5) {
				continue;
			}

			set.add(road);
			nowX = nextX;
			nowY = nextY;
		}
		return set.size();
	}

}
