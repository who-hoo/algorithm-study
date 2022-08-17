import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[m];
        if (m != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
        }
        Main main = new Main();
        System.out.println(main.solution(n, m, arr));
    }

    public int solution(int n, int m, int[] arr) {
        // 티비를 켰을 때의 채널은 100번이기 때문에 고장난 번호가 1, 0, 9여서 근접한 번호인 88부터 + 버튼으로 100까지 도달
        // 하는 것보단 100번에서 - 버튼 하나로 99번으로 이동하는 것이 최소값이 된다
        boolean[] 고장난번호 = new boolean[10];
        for (int i = 0; i < arr.length; i++) {
            고장난번호[arr[i]] = true;
        }
        // 완전탐색 i의 숫자 중에 고장난 번호가 있으면 안쪽 포문의 탐색을 멈추고 다음 숫자를 체크한다
        // 고장난 번호가 없으면 기준점까지 + 혹은 - 버튼을 얼만큼 사용해서 도달해야하는지 값을 찾고
        // 고장나지 않은 번호로 이동하고자 하는 번호와 가장 근접한 번호로 이동 할 때 누른 번호를 더한다
        // 최소값을 갱신한다
        int min = Math.abs(n - 100);
        for (int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            boolean isBroken = false;
            for (int j = 0; j < str.length(); j++) {
                isBroken = 고장난번호[str.charAt(j) - '0'];
                if (isBroken) {
                    break;
                }
            }
            if (!isBroken) {
                int result = Math.abs(n - i) + str.length();
                min = Math.min(result, min);
            }
        }
        return min;
    }
}
