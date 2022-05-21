import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    
    static int[] dx = {0, 1, 0, -1}; // 하 우 상 좌
	static int[] dy = {1, 0, -1, 0};
	static int rowCount;
	static int colCount;

	public int[] solution(String[] grid) {
		rowCount = grid.length;
		colCount = grid[0].length();
		boolean[][][] visited = new boolean[rowCount][colCount][4];

		ArrayList<Integer> answer = new ArrayList<>();
		for (int row = 0; row < rowCount; row++) {
			for (int col = 0; col < colCount; col++) {
				for (int dir = 0; dir < 4; dir++) {
					if (!visited[row][col][dir]) {
						answer.add(beam(grid, visited, row, col, dir));
					}
				}
			}
		}

		return answer.stream()
			.mapToInt(Integer::intValue)
			.sorted()
			.toArray();
	}

	public int beam(String[] grid, boolean[][][] visited, int startRow, int startCol, int direction) {
		int currentRow = startRow;
		int currentCol = startCol;
		int currentDir = direction;
		int length = 0;
		while (true) {
			if (visited[currentRow][currentCol][currentDir]) {
				break;
			}

			int nextRow = currentRow + dy[currentDir];
			int nextCol = currentCol + dx[currentDir];
			if (nextRow >= rowCount) {
				nextRow = 0;
			}
			if (nextRow < 0) {
				nextRow = rowCount - 1;
			}
			if (nextCol >= colCount) {
				nextCol = 0;
			}
			if (nextCol < 0) {
				nextCol = colCount - 1;
			}

			visited[currentRow][currentCol][currentDir] = true;
			length++;
			char c = grid[nextRow].charAt(nextCol);
			switch (c) {
				case 'L':
					currentDir = (currentDir + 1) % 4;
					break;
				case 'R':
					currentDir = (currentDir + 3) % 4;
					break;
				default:
					break;
			}
			currentRow = nextRow;
			currentCol = nextCol;
		}

		return length;
	}
}
