import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(stringTokenizer.nextToken());
		int M = Integer.parseInt(stringTokenizer.nextToken());

		int[] gameBoard = new int[101];
		boolean[] visited = new boolean[101];
		int[] count = new int[101];

		for (int i = 0; i < N + M; i++) {
			stringTokenizer = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(stringTokenizer.nextToken());
			int v = Integer.parseInt(stringTokenizer.nextToken());

			gameBoard[u] = v;
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		count[1] = 0;
		visited[1] = true;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			if (now == 100) {
				System.out.println(count[now]);
				break;
			}

			for (int i = 1; i <= 6; i++) {
				int next = now + i;

				if (100 < next || visited[next]) {
					continue;
				}

				if (gameBoard[next] != 0) {
					if (!visited[gameBoard[next]]) {
						visited[gameBoard[next]] = true;
						count[gameBoard[next]] = count[now] + 1;
						queue.offer(gameBoard[next]);
					}
				} else {
					visited[next] = true;
					count[next] = count[now] + 1;
					queue.offer(next);
				}
			}
		}
	}
}
