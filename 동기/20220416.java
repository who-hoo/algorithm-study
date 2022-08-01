import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());	// 나무의 수 N
		int m = Integer.parseInt(st.nextToken());    // 집으로 가져가려는 나무의 길이 M
		int[] heights = new int[n];
		int max = -1;

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			heights[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, heights[i]);
		}

		int min = 0;
		while (min < max) {
			int mid = (min + max) / 2;

			long sum = 0;
			for (int i = 0; i < n; i++) {

				if (heights[i] - mid > 0) {
					sum += (heights[i] - mid);
				}
			}

			if (sum < m) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		System.out.println(min - 1);
	}

}
