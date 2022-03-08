import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] cardArray = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            cardArray[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cardArray);


        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {

            if (myBinarySearch(cardArray, Integer.parseInt(st.nextToken()))) {
                sb.append(1 + " ");
            } else {
                sb.append(0 + " ");
            }
        }
        System.out.println(sb);
    }

    private static boolean myBinarySearch(int[] cardArray, int target) {
        int left = 0;
        int right = cardArray.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;

            if (cardArray[mid] > target) {
                right = mid - 1;
            } else if (cardArray[mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
