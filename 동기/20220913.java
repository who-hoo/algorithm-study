import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    int answer = 0;
    int[][] board;

    public int solution(int n, int c, int r) {
        board = makeBoard(n);
        search(n, c, r);
        return answer;
    }

    private void search(int n, int c, int r) {
        // 한칸씩 이동할때마다 해당 인덱스에 +1

        // 4등분 포인트 0부터 divideLength까지
        // divideLength부터 board.length까지

        int divideLength = 1;
        int base = 2;
        for (int i = 1; i < n; i++) {
            divideLength *= base;
        }

        // c, r 에 따라서 순회할 네모 선택
        // 3, 1
        if (c > divideLength) {
            answer += divideLength * divideLength * 2;
            c -= divideLength;
        }

        if (r > divideLength) {
            answer += divideLength * divideLength;
            r -= divideLength;
        }

        // z모양 순회 로직

        // 가로 +1, +3 순으로 증가
        // 세로 +2, +6 순으로 증가
        for (int i = 1; i <= c; i++) {
            if (i % 2 == 0) {
                answer += 6;
            } else {
                answer += 2;
            }
        }

        for (int i = 1; i <= r; i++) {
            if (i % 2 == 0) {
                answer += 3;
            } else {
                answer += 1;
            }
        }
    }

    private int[][] makeBoard(int n) {
        int base = 2;
        int board = 2;
        for (int i = 1; i < n; i++) {
            board *= base;
        }


        return new int[board][board];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        Solution s = new Solution();
        System.out.println(s.solution(n, c, r));
    }

}
