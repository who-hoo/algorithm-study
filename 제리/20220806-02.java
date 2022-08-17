import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public int solution(int[][] maps) {
		int n = maps.length;
		int m = maps[0].length;

		boolean[][] visited = new boolean[n][m];
		int[] dx = new int[]{1, -1, 0, 0};
		int[] dy = new int[]{0, 0, 1, -1};

		Queue<int[]> q = new LinkedList<>();
		visited[0][0] = true;
		q.offer(new int[]{0, 0});

		while (!q.isEmpty()) {
			int[] points = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = points[0] + dx[i];
				int ny = points[1] + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
					continue;
				}

				if (!visited[nx][ny] && maps[nx][ny] == 1) {
					visited[nx][ny] = true;
					maps[nx][ny] += maps[points[0]][points[1]];
					q.offer(new int[]{nx, ny});
				}
			}
		}

		if (!visited[n - 1][m - 1]) {
			return -1;
		}
		return maps[n - 1][m - 1];
	}

}
