package baekjoon.main_3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //setup
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        boolean[] arr = new boolean[2_000_001];
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            max = Math.max(max, value);
            arr[value] = true;
        }
        int x = Integer.parseInt(br.readLine());


        //solving
        int pairCnt = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == true) {
                if (0 < x - i && arr[x - i] == true) {
                    pairCnt++;
                }
            }
        }
        System.out.println(pairCnt / 2);
    }
}
