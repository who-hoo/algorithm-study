import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        // 1. 벨트의 임의의 한 위치부터 k개의 접시를 연속해서 먹을 경우 할인된 정액 가격으로 제공
        // 2. 각 고객에게 초밥의 종류 하나가 쓰인 쿠폰을 발행,
        //    1번 행사에 참가할 경우 쿠폰에 적혀진 종류의 초밥 하나를 추가 무료 제공
        //    초밥이 벨트 위에 없을 경우, 새로 만들어 제공
        // -> 손님이 먹을 수 있는 초밥 가짓수의 최댓값
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = in.readLine().split(" ");
        final int N = Integer.parseInt(inputs[0]); // 회전 초밥 벨트에 놓인 접시의 수
        final int d = Integer.parseInt(inputs[1]); // 초밥의 가짓수
        final int k = Integer.parseInt(inputs[2]); // 연속해서 먹는 접시의 수
        final int c = Integer.parseInt(inputs[3]); // 쿠폰 번호

        int[] belt = new int[N];
        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(in.readLine());
        }
        in.close();

        Set<Integer> sushi = new HashSet<>();
        int maxTypeCount = 0;
        for (int startIndex = 0; startIndex < belt.length; startIndex++) {
            sushi.add(c);
            for (int i = 0; i < k; i++) {
                sushi.add(belt[(startIndex + i) % N]);
            }
            maxTypeCount = Math.max(maxTypeCount, sushi.size());
            sushi.clear();
        }

        System.out.println(maxTypeCount);
    }
}
