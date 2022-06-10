import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		final int N = Integer.parseInt(st.nextToken()); // 수의 개수
		final int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수

		st = new StringTokenizer(br.readLine());
		int[] numbers = new int[N+1];
		for (int n = 1; n <= N; n++) {
			numbers[n] = Integer.parseInt(st.nextToken());
		}

		int[] memo = new int[N+1];
		int sum = 0;
		for (int n = 1; n <= N; n++) {
			sum += numbers[n];
			memo[n] = sum;
		}
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			bw.write((memo[j] - memo[i-1]) + "\n");
		}

		bw.close();
		br.close();
	}
}
