package 아더;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PRO_17678_셔틀버스 {

    public static void main(String[] args) {
        PRO_17678_셔틀버스 pro = new PRO_17678_셔틀버스();

        int[] n = {1, 2, 2, 1, 1, 10};
        int[] t = {1, 10, 1, 1, 1, 60};
        int[] m = {5, 2, 2, 5, 1, 45};
        String[][] timetable = {
            {"08:00", "08:01", "08:02", "08:03"},
            {"09:10", "09:09", "08:00"},
            {"09:00", "09:00", "09:00", "09:00"},
            {"00:01", "00:01", "00:01", "00:01", "00:01"},
            {"23:59"},
            {"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}
        };

        for (int i = 0; i < 6; i++) {
            System.out.println(pro.solution(n[i], t[i], m[i], timetable[i]));
        }
    }

    public String solution(int n, int t, int m, String[] timetable) {
        // 1. 도착 시간 정렬
        Arrays.sort(timetable);

        // 시간테이블을 초로 변환?
        Queue<Integer> timeSeconds = new LinkedList<>();
        for (String time : timetable) {
            timeSeconds.add(timeToSecond(time));
        }

        // 기본 출발 시간
        int startShuttleSecond = timeToSecond("09:00");
        // 잠 잘 시간
        int sleepSecond = timeToSecond("23:59");
        // 타야 할 시간
        int targetSecond = startShuttleSecond;


        // 2. 셔틀 횟수만큼 반복
        for (int i = 0; i < n; i++) {
            // 셔틀 출발 시간 구하기
            if (i > 0) {
                startShuttleSecond += (60 * t);
                targetSecond += (60 * t);
            }
            // 탑승 인원 초기화
            int maxBoardingCount = m;

            // 해당 회차 인원만큼 큐에서 사람빼기
            for (int j = 0; j < m; j++) {
                if (timeSeconds.isEmpty()) {
                    // 여기 출발 시간에 타면 된다.
                    targetSecond = startShuttleSecond;
                    break;
                }

                int second = timeSeconds.peek();

                // 23:59분이면 집가야 함
                if (second == sleepSecond || startShuttleSecond < second) {
                    continue;
                }

                // 탑승 가능 인원 감소
                maxBoardingCount--;
                timeSeconds.poll();

                // 타야하는지 판단(마지막 셔틀 && 자리 없음)
                if (i == n - 1 && maxBoardingCount == 0) {
                    targetSecond = second - 60;
                    break;
                }
            }
        }

        return secondToTime(targetSecond);
    }

    private String secondToTime(int targetSecond) {
        StringBuilder timeBuilder = new StringBuilder();

        int hour = targetSecond / 3600;
        int minute = (targetSecond % 3600) / 60;

        if (hour < 10) {
            timeBuilder.append("0");
        }
        timeBuilder.append(hour);
        timeBuilder.append(":");
        if (minute < 10) {
            timeBuilder.append("0");
        }
        timeBuilder.append(minute);

        return timeBuilder.toString();
    }

    private int timeToSecond(String time) {
        String[] timeSplit = time.split(":");
        int hours = parseHour(timeSplit[0]);
        int minutes = parseMinute(timeSplit[1]);

        return (hours * 60 * 60) + (minutes * 60);
    }

    private int parseHour(String hour) {
        return Integer.parseInt(hour);
    }

    private int parseMinute(String minute) {
        return Integer.parseInt(minute);
    }

}
