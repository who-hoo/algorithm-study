import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Conference> list = new ArrayList<>();

        while (N-- > 0) {
            String[] s = br.readLine().split(" ");
            list.add(new Conference(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
        }

        list.sort((o1, o2) -> {
            if (o1.endTime != o2.endTime) {
                return o1.endTime - o2.endTime;
            }
            return o1.startTime - o2.startTime;
        });

        int endTime = list.get(0).endTime;
        int count = 1;
        
        for (int i = 1; i < list.size(); i++) {
            Conference tmp = list.get(i);
            if (tmp.startTime < endTime) {
                continue;
            }
            endTime = tmp.endTime;
            count++;
        }
        System.out.println(count);
    }

    static class Conference {
        int startTime;
        int endTime;

        public Conference(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}
