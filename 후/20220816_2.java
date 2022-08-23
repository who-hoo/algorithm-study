import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(in.readLine()); // 이동하려고 하는 채널
		final int M = Integer.parseInt(in.readLine()); // 고장난 버튼의 개수

		boolean[] isBroken = new boolean[10];
		if (M > 0) {
			StringTokenizer tokenizer = new StringTokenizer(in.readLine());
			for (int i = 0; i < M; i++) {
				int brokenButton = Integer.parseInt(tokenizer.nextToken());
				isBroken[brokenButton] = true;
			}
		}
		in.close();

		if (N == 100) {
			System.out.println(0);
			return;
		}

		int answer = Math.abs(N - 100); // +, -로만 이동한 횟수로 초기화
		for (int i = 0; i <= 1000000; i++) { // 숫자 버튼으로 이동 가능한 모든 채널의 경우의 수를 체크
			int count = 0;
			String channel = String.valueOf(i);
			for (char c : channel.toCharArray()) {
				if (isBroken[c - '0']) { // 숫자 버튼으로 이동할 수 없음(버튼 고장)
					count = answer;
					break;
				}
				count++;
			}
			answer = Math.min(answer, count + Math.abs(i - N)); // 해당 채널에서(count) +, -로 N까지 이동한 횟수
		}

		System.out.println(answer);
	}
}
