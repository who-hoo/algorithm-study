import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    static class Bus {
        LocalTime startTime;
        int capacity;
        List<LocalTime> boardCrews;

        public Bus(LocalTime startTime, int capacity) {
            this.startTime = startTime;
            this.capacity = capacity;
            this.boardCrews = new ArrayList<>();
        }

        public boolean board(LocalTime crewTime) {
            if (boardCrews.size() < capacity && (crewTime.isBefore(startTime) || crewTime.equals(startTime))) {
                boardCrews.add(crewTime);
                return true;
            }

            return false;
        }

        public String getLastBoard() {
            if (boardCrews.size() < capacity) {
                return startTime.toString();
            }

            return boardCrews.get(capacity - 1).minusMinutes(1L).toString();
        }
    }

    public String solution(int n, int t, int m, String[] timetable) {
        Arrays.sort(timetable);

        LocalTime firstBusTime = LocalTime.parse("09:00");
        LocalTime lastBusTime = firstBusTime.plusMinutes((long) (n - 1) * t);
        LocalTime firstCrewTime = LocalTime.parse(timetable[0]);

        if (firstCrewTime.isAfter(lastBusTime)) { // 가장 먼저 도착한 크루가 마지막 버스 도착 시간 이후에 도착한 경우
            return lastBusTime.toString(); // 콘은 마지막 버스 도착 시간에 맞춰서 도착한다
        }

        List<Bus> buses = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            buses.add(new Bus(firstBusTime.plusMinutes((long) i * t), m));
        }

        int busIndex = 0;
        for (String time : timetable) {
            Bus bus = buses.get(busIndex);
            LocalTime crew = LocalTime.parse(time);
            if (!bus.board(crew)) { // 크루가 버스에 탑승하지 못한 경우
                while (busIndex + 1 < n) { // 다음에 탈 수 있는 버스가 있으면
                    if (buses.get(++busIndex).board(crew)) {
                        break; // 이 크루 포함 이후의 크루들 모두 셔틀 버스를 영영 탈 수 없다.
                    }
                }
            }
        }

        return buses.get(n - 1).getLastBoard();
    }
}
