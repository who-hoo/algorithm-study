import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		final String str1 = in.readLine();
		final String str2 = in.readLine();
		in.close();

		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();

		// 각 문자의 비교가 끝났을 때, 해당 위치에서 가질 수 있는 LCS의 값을 저장(이전 문자 참고를 위해 패딩 +1)
		int[][] memo = new int[arr1.length + 1][arr2.length + 1];
		for (int i = 1; i <= arr1.length; i++) {
			for (int j = 1; j <= arr2.length; j++) {
				if (arr1[i - 1] == arr2[j - 1]) { // 두 문자가 같은 경우
					// 대각선의 값을 참고하여 +1
					memo[i][j] = memo[i - 1][j - 1] + 1;
				} else { // 두 문자가 다른 경우
					// 각 문자열의 이전 문자 중 최대 LCS 값 선택
					memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
				}
			}
		}

		// 최종으로 탐색한 위치가 최대값
		System.out.println(memo[arr1.length][arr2.length]);
	}
}
