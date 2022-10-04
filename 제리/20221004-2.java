import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int d = Integer.valueOf(st.nextToken());
		int k = Integer.valueOf(st.nextToken());
		int c = Integer.valueOf(st.nextToken());
		int[] sushi = new int[n];

		for (int i = 0; i < n; i++) {
			sushi[i] = Integer.valueOf(br.readLine());
		}

		int[] ate = new int[d + 1];
		int count = 0;
		for (int i = 0; i < k; i++) {
			if (ate[sushi[i]] == 0) {
				count++;
			}

			ate[sushi[i]]++;
		}

		int maxLen = count;

		for (int i = 1; i < n; i++) {
			if (maxLen <= count) {
				if (ate[c] == 0) {
					maxLen = count + 1;
				} else {
					maxLen = count;
				}
			}

			int end = (i + k - 1) % n;
			if (ate[sushi[end]] == 0) {
				count++;
			}
			ate[sushi[end]]++;

			ate[sushi[i - 1]]--;
			if (ate[sushi[i - 1]] == 0) {
				count--;
			}
		}

		System.out.println(maxLen);
	}
}
