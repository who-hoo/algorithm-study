import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n];

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) { // O(N)
            cards[i] = Integer.parseInt(st1.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] results = new int[m];

        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) { // O(M)
            map.put(Integer.parseInt(st2.nextToken()), i);
        }

        for (int card : cards) { // O(N)
            if (map.containsKey(card))
                results[map.get(card)] = 1;
        }

        for (int result : results) { // O(M)
            bw.write(result + " ");
        }
        bw.flush();
        bw.close();
    }
}
