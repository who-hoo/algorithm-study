import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    
    private static class Person {

		private int row;
		private int col;

		private Person(int row, int col) {
			this.row = row;
			this.col = col;
		}

		private int distance(Person other) {
			return Math.abs(this.row - other.row) + Math.abs(this.col - other.col);
		}

		private boolean isDistanceLoe2With(Person other) {
			return distance(other) <= 2;
		}

		private boolean isDistanceGoe2With(Person other) {
			return distance(other) >= 2;
		}
	}

	public int[] solution(String[][] places) {
		int[] answer = new int[5];
		for (int p = 0; p < 5; p++) {
			String[] place = places[p];
			List<Person> people = new ArrayList<>(25);
			extractPerson(place, people);
			answer[p] = checkPlace(place, people);
		}
		return answer;
	}

	private int checkPlace(String[] place, List<Person> people) {
		for (int i = 0; i < people.size(); i++) {
			for (int j = i + 1; j < people.size(); j++) {
				Person p1 = people.get(i);
				Person p2 = people.get(j);
				if (p1.isDistanceLoe2With(p2) && !isSafe(place, p1, p2)) {
					return 0;
				}
			}
		}
		return 1;
	}

	private boolean isSafe(String[] place, Person p1, Person p2) {
		// PXP
		if (p1.row == p2.row
			&& Math.abs(p1.col - p2.col) >= 2
			&& place[p1.row].charAt(Math.max(p1.col, p2.col) - 1) == 'X') {
			return true;
		}

		// P
		// X
		// P
		if (p1.col == p2.col
			&& Math.abs(p1.row - p2.row) >= 2
			&& place[Math.max(p1.row, p2.row) - 1].charAt(p1.col) == 'X') {
			return true;
		}

		if (p1.row != p2.row && p1.isDistanceGoe2With(p2)) {
			// PX
			// XP
			if (p1.col < p2.col
				&& place[p1.row].charAt(p1.col + 1) == 'X'
				&& place[p2.row].charAt(p2.col - 1) == 'X') {
				return true;
			}
			// XP
			// PX
			if (p1.col > p2.col
				&& place[p1.row].charAt(p1.col - 1) == 'X'
				&& place[p2.row].charAt(p2.col + 1) == 'X') {
				return true;
			}
		}
		return false;
	}

	private void extractPerson(String[] place, List<Person> people) {
		for (int r = 0; r < place.length; r++) {
			char[] col = place[r].toCharArray();
			for (int c = 0; c < col.length; c++) {
				if (col[c] == 'P') {
					people.add(new Person(r, c));
				}
			}
		}
	}
}
