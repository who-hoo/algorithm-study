package beakjoon.main_1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
* 리모컨
* 골드5
* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] n = br.readLine().split("");
        int m = Integer.parseInt(br.readLine());

        int[] broken = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            broken[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(broken);

        

    }
}
