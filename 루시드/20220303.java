package AlgorithmStudy.boj11403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dist = new int[N][N];

        String[] row;
        for (int i = 0; i < N; i++) {
            row = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                dist[i][j] = Integer.parseInt(row[j]);
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (dist[i][k] == 1 && dist[k][j] == 1)
                        dist[i][j] = 1;
                }
            }
        }

        for (int[] ints : dist) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
