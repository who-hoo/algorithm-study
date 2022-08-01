import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] meetingTime = new int[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			meetingTime[i][0] = Integer.parseInt(st.nextToken());	// 시작 시간
			meetingTime[i][1] = Integer.parseInt(st.nextToken());	// 종료 시간
		}

		Arrays.sort(meetingTime, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {

				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});

		int prevEndTime = 0;
		int count = 0;

		for (int i = 0; i < n; i++) {
			// 회의 시작 시간이 이전 회의 종료시간보다 크거나 같으면
			if (prevEndTime <= meetingTime[i][0]) {
				prevEndTime = meetingTime[i][1];
				count++;
			}
		}
		System.out.println(count);
	}

}
