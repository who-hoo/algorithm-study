import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ9019 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        final int T = Integer.parseInt(in.readLine()); // 테스트 케이스 개수
        for (int testCase = 0; testCase < T; testCase++) {
            String[] inputs = in.readLine().split(" ");
            final int A = Integer.parseInt(inputs[0]); // 레지스터의 초기 값
            final int B = Integer.parseInt(inputs[1]); // 최종 값

            // A에서 B로 변환하기 위해 필요한 최소한의 명령어 나열
        }

        out.close();
        in.close();
    }
}
