import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    public String solution(int n, int t, int m, String[] timetable) {
        Arrays.sort(timetable);
        PriorityQueue<Integer> minuteTimeTable = new PriorityQueue<>();
        for (String time : timetable) {
            String[] split = time.split(":");
            int minute = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            minuteTimeTable.add(minute);
        }

        int currentBusTime = 540;
        int answer = 0;
        int index = 0;
        
        for (int i = 0; i < n; i++) {
            index = 0;
            while (!minuteTimeTable.isEmpty()) {
                int crew = minuteTimeTable.poll();
                if (crew <= currentBusTime && index < m) {
                    index++;
                    answer = crew - 1;
                } else {
                    minuteTimeTable.offer(crew);
                    break;
                }
            }
            currentBusTime += t;
        }

        if (index < m) {
            answer = currentBusTime - t;
        }

        int hour = answer / 60;
        int minute = answer % 60;
        return (hour < 10 ? "0" + hour : hour + "") + ":" +
            (minute < 10 ? "0" + minute : minute + "");
    }
}
