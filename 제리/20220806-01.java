import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] map = new int[n];
		for (int i = 0; i < n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}

		int answer = Integer.MAX_VALUE;
		int startPoint = 0;
		int endPoint = 0;

		int sum = map[0];

		while (endPoint < n) {
			//todo
			// 합이 s보다 크다면
			// 앞 포인트 이동 -> sum 감소
			// 이동 하기 전에 startpoint, endpoint 같은지 확인
			// 만약 같다면 최소의 길이가 1이므로 answer = 1, break;
			// endpoint - startpoint 로 answer 갱신
			// 합이 s보다 작다면
			// 뒤 포인트 이동 -> sum 증가
			System.out.println("sum: " + sum + " start: " + startPoint + " end: " + endPoint);

			if (sum >= s) {
				if (startPoint == endPoint) {
					answer = 1;
					break;
				}
				sum -= map[startPoint];
				answer = Math.min(answer, endPoint - startPoint + 1);
				startPoint++;
			} else {
				endPoint++;
				if (endPoint == n) {
					break;
				}
				sum += map[endPoint];
			}
		}

		if (answer == Integer.MAX_VALUE) {
			answer = 0;
		}
		System.out.println(answer);
	}

}
