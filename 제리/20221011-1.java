class Solution {

	public int[] solution(int rows, int columns, int[][] queries) {
		int[][] map = new int[rows][columns];
		int[] answer = new int[queries.length];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				map[i][j] = i * columns + j + 1;
			}
		}

		for (int i = 0; i < queries.length; i++) {
			int x1 = queries[i][0] - 1;
			int y1 = queries[i][1] - 1;
			int x2 = queries[i][2] - 1;
			int y2 = queries[i][3] - 1;

			int tmp = map[x1][y1];
			int min = tmp;

			for (int j = x1; j < x2; j++) {
				map[j][y1] = map[j + 1][y1];
				min = Math.min(map[j][y1], min);
			}
			for (int j = y1; j < y2; j++) {
				map[x2][j] = map[x2][j + 1];
				min = Math.min(map[x2][j], min);
			}
			for (int j = x2; j > x1; j--) {
				map[j][y2] = map[j - 1][y2];
				min = Math.min(map[j][y2], min);
			}
			for (int j = y2; j > y1; j--) {
				map[x1][j] = map[x1][j - 1];
				min = Math.min(map[x1][j], min);
			}
			map[x1][y1 + 1] = tmp;

			answer[i] = min;
		}

		return answer;
	}
}
