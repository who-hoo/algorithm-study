import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<String> channels = new ArrayList<>();
	static int numbersIdx;
	static char[] numChar;
	static char[] numbers;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int n = Integer.parseInt(input);
		int m = Integer.parseInt(br.readLine());

		if (m == 10) {
			System.out.println(Math.abs(n - 100));
			return;
		}

		boolean[] disableNumbers = new boolean[10];

		if (m != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				disableNumbers[Integer.parseInt(st.nextToken())] = true;
			}
		}

		numbersIdx = 10 - m;
		numbers = new char[numbersIdx];

		int index = 0;
		for (int i = 0; i < 10; i++) {
			if (!disableNumbers[i]) {
				numbers[index++] = Character.forDigit(i, 10);
			}
		}

		//todo
		// 백트래킹으로 조합 다 구함 -> input의 자리수보다 1개 작은거 && 1개 큰거까지 총 3번 돌아야 함
		// 숫자들 누른 횟수 + 기대 값에서 뺸 값
		// 기존의 100 위치에서 + - 눌러서 갈 수 있는 값

		if (input.length() != 1) {
			numChar = new char[input.length() - 1];
			dfs(0, input.length() - 1);
		}
		numChar = new char[input.length()];
		dfs(0, input.length());
		if (input.length() != 6) {
			numChar = new char[input.length() + 1];
			dfs(0, input.length() + 1);
		}

		int channel = 100;

		int buttonCount = Math.abs(n - channel);
		int min = buttonCount;

		for (String channelNumber : channels) {
			buttonCount = Math.abs(n - Integer.parseInt(channelNumber)) + channelNumber.length();
			min = Math.min(buttonCount, min);
		}

		System.out.println(min);
	}

	private static void dfs(int depth, int maxDepth) {
		if (depth == maxDepth) {
			channels.add(String.valueOf(numChar));
			return;
		}

		for (int i = 0; i < numbersIdx; i++) {
			numChar[depth] = numbers[i];
			dfs(depth + 1, maxDepth);
		}

	}
}
