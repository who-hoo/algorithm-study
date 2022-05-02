import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		int[] cnt = new int[10001];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		br.close();

		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			cnt[num]++;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cnt.length; i++) {

			if (cnt[i] != 0) {
				for (int j = 0; j < cnt[i]; j++) {
					sb.append(i).append("\n");
				}
			}
		}

		System.out.println(sb);

	}

}
