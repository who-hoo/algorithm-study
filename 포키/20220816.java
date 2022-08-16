import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1107 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String destination = br.readLine();

        if (destination.equals("100")) {
            System.out.println(0);
            return;
        }

        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            System.out.println(destination.length());
            return;
        }

        boolean[] brokenNums = new boolean[10];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            brokenNums[Integer.parseInt(s[i])] = true;
        }

        int c;
        int r = 999999;
        for (int i = 0; i <= 999999; i++) {
            String num = String.valueOf(i);
            boolean status = false;
            for (int j = 0; j < num.length(); j++) {
                if (brokenNums[Character.getNumericValue(num.charAt(j))]) {
                    status = true;
                    break;
                }
            }
            if (!status) {
                c =
                    num.length() + Math.abs(Integer.parseInt(destination) - Integer.parseInt(num));
                r = Math.min(r, c);
            }
        }

        if (r < Math.abs(100 - n)) {
            System.out.println(r);
        } else {
            System.out.println(Math.abs(100 - n));
        }

    }
}
