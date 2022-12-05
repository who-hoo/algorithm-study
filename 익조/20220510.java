 import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static class MeetingRoom implements Comparable<MeetingRoom> {
        int startTime;
        int endTime;

        public MeetingRoom(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(MeetingRoom o) {
            if (o.endTime < endTime) {
                return 1;
            }
            else if (o.endTime > endTime) {
                return -1;
            }
            if (o.startTime < startTime) {
                return 1;
            }
            else if (o.startTime > startTime) {
                return -1;
            }
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<MeetingRoom> meetingRooms = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            meetingRooms.add(new MeetingRoom(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(meetingRooms);

        int count = 1, endTime = meetingRooms.get(0).endTime;
        for (int i = 1; i < n; i++) {
            if (endTime <= meetingRooms.get(i).startTime) {
                count++;
                endTime = meetingRooms.get(i).endTime;
            }
        }

        System.out.println(count);
    }

}
