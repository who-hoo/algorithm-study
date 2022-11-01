import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ8980 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        List<Info> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            StringTokenizer l = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(l.nextToken());
            int target = Integer.parseInt(l.nextToken());
            int size = Integer.parseInt(l.nextToken());
            list.add(new Info(start, target, size));
        }



    }

    static class Info{
        int start;
        int target;
        int size;

        public Info(int start, int target, int size) {
            this.start = start;
            this.target = target;
            this.size = size;
        }
    }

}
