import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 셔틀버스 {

    public String solution(int n, int t, int m, String[] timetable) {

        List<List<Integer>> buses = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            buses.add(new ArrayList<>());
        }

        for (String time : timetable) {
            String[] splitTime = time.split(":");
            int minute = Integer.parseInt(splitTime[0]) * 60 + Integer.parseInt(splitTime[1]);
            queue.add(minute);
        }

        int busTime = 9 * 60;
        int answer = 0;

        for (int i = 0; i < n; i++) {

            while (!queue.isEmpty()) {
                List<Integer> bus = buses.get(i);
                int crew = queue.poll();

                if (crew <= busTime && bus.size() < m) {
                    bus.add(crew);
                    answer = crew - 1;
                }else{
                    queue.offer(crew);
                    break;
                }
            }

            busTime += t;
        }

        if (buses.get(n - 1).size() < m) {
            answer = busTime - t;
        }

        return String.format("%02d:%02d", answer / 60, answer % 60);
    }
}