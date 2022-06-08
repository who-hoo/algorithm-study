import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        Set<Integer> frame = new HashSet<>();
        Map<Integer, Integer> recommend = new HashMap<>();

        String[] list = br.readLine().split(" ");
        for (int i = 0; i < list.length; i++) {
            int recommendedNumber = Integer.parseInt(list[i]);

            //저장
            if (recommend.containsKey(recommendedNumber)) {
                recommend.put(recommendedNumber, recommend.get(recommendedNumber) + 1);
            }else{
                recommend.put(recommendedNumber, 1);
            }

            if (frame.size() < n) {
                //가득 찬경우
                //추천값이 가장 작은 값을 찾아내서 제거.
                //가장 작은 값이 여러개면 가장 앞에 값을 삭제
            }else{
                //덜 찬 경우
                //frame에 넣기
            }
        }
        //최종 결과물 출력
    }
}
