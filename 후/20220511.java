import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static class Conference implements Comparable<Conference> {

        int start;
        int end;

        public Conference(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Conference o) {
            if (this.end < o.end) {
                return -1;
            } else if (this.end == o.end) {
                return Integer.compare(this.start, o.start);
            } else {
                return 1;
            }
        }

        @Override
        public String toString() {
            return "Conference{" +
                "start=" + start +
                ", end=" + end +
                '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 회의의 수
        ArrayList<Conference> conferences = new ArrayList<>(N);
        while (N-- > 0) {
            String[] times = br.readLine().split(" ");
            int startTime = Integer.parseInt(times[0]);
            int endTime = Integer.parseInt(times[1]);
            conferences.add(new Conference(startTime, endTime));
        }
        br.close();

        Collections.sort(conferences);

        int answer = 0;
        int time = 0;
        for (Conference conference : conferences) {
            if (conference.start >= time) {
                answer++;
                time = conference.end;
            }
        }

        System.out.println(answer);
    }
}
