import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class ShippingInfo {

        int from;
        int to;
        int boxCount;

        public ShippingInfo(int from, int to, int boxCount) {
            this.from = from;
            this.to = to;
            this.boxCount = boxCount;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        final int N = Integer.parseInt(tokenizer.nextToken()); // 마을 수
        final int C = Integer.parseInt(tokenizer.nextToken()); // 트럭의 용량
        final int M = Integer.parseInt(in.readLine()); // 보내는 박스 정보의 개수
        final List<ShippingInfo> shippingInfos = new ArrayList<>(M);
        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(tokenizer.nextToken());
            int to = Integer.parseInt(tokenizer.nextToken());
            int boxCount = Integer.parseInt(tokenizer.nextToken());
            shippingInfos.add(new ShippingInfo(from, to, boxCount));
        }
        in.close();
    }
}
