import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][3];
		int[][] dpMax = new int[n][3];
		int[][] dpMin = new int[n][3];

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
			map[i][2] = Integer.parseInt(st.nextToken());
		}

		dpMax[0][0] = map[0][0];
		dpMin[0][0] = map[0][0];
		dpMax[0][1] = map[0][1];
		dpMin[0][1] = map[0][1];
		dpMax[0][2] = map[0][2];
		dpMin[0][2] = map[0][2];

		for (int i = 1; i < n; i++) {
			dpMax[i][0] = Math.max(dpMax[i - 1][0], dpMax[i - 1][1]) + map[i][0];
			dpMax[i][1] = Math.max(Math.max(dpMax[i - 1][0], dpMax[i - 1][1]), dpMax[i -1][2]) + map[i][1];
			dpMax[i][2] = Math.max(dpMax[i - 1][1], dpMax[i - 1][2]) + map[i][2];

			dpMin[i][0] = Math.min(dpMin[i - 1][0], dpMin[i - 1][1]) + map[i][0];
			dpMin[i][1] = Math.min(Math.min(dpMin[i - 1][0], dpMin[i - 1][1]), dpMin[i -1][2]) + map[i][1];
			dpMin[i][2] = Math.min(dpMin[i - 1][1], dpMin[i - 1][2]) + map[i][2];
		}

		System.out.println(Math.max(Math.max(dpMax[n - 1][0], dpMax[n - 1][1]), dpMax[n -1][2])
			+ " " +
			Math.min(Math.min(dpMin[n - 1][0], dpMin[n - 1][1]), dpMin[n -1][2]));
	}

}
