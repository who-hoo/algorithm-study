import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
	static class Point {

		int row;
		int col;

		Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	static int[] dRow = {-1, 1, 0, 0}; // 상, 하, 좌, 우
	static int[] dCol = {0, 0, -1, 1}; // 상, 하, 좌, 우

	public int solution(int[][] maps) {
		maps[maps.length - 1][maps[0].length - 1] = -1;
		boolean[][] visited = new boolean[maps.length][maps[0].length];
		bfs(visited, maps, 0, 0);
		return maps[maps.length - 1][maps[0].length - 1];
	}

	public void bfs(boolean[][] visited, int[][] maps, int row, int col) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(row, col));
		visited[row][col] = true;

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextRow = p.row + dRow[i];
				int nextCol = p.col + dCol[i];

				if (0 <= nextRow && nextRow < maps.length &&
					0 <= nextCol && nextCol < maps[0].length &&
					!visited[nextRow][nextCol] && maps[nextRow][nextCol] != 0) {
					queue.offer(new Point(nextRow, nextCol));
					visited[nextRow][nextCol] = true;
					maps[nextRow][nextCol] = maps[p.row][p.col] + 1;
				}
			}
		}
	}
}
