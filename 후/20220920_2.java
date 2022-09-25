import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    
    private int runningCount;
    private int runningInterval;
    private int capableCount;
    private List<List<Integer>> buses;
    
    public String solution(int n, int t, int m, String[] timetable) {
        init(n, t, m);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (String time : timetable) {
            pq.add(timeToMinute(time));
        }

        int answer = 0;
        int busTime = 9 * 60;
        for (int i = 0; i < n; i++) {
            while(!pq.isEmpty()) {
                int crew = pq.poll();
                if (isArrived(crew, busTime) && isCapableBus(i)) {
                    ride(crew,i);
                    answer = crew - 1;
                } else {
                    pq.offer(crew);
                    break;
                }
            }
            busTime += runningInterval;
        }

        if (buses.get(runningCount - 1).size() < capableCount) {
            answer = busTime - runningInterval;
        }

        return minuteToHHMM(answer);
    }

    private void init(int runningCount, int runningInterval, int capableCount) {
        this.runningCount = runningCount;
        this.runningInterval = runningInterval;
        this.capableCount = capableCount;
        this.buses = new ArrayList<>();
        for (int i = 0; i < runningCount; i++) {
            this.buses.add(new ArrayList<>());
        }
    }

    private int timeToMinute(String time) {
        String[] splitTime = time.split(":");
        return Integer.parseInt(splitTime[0]) * 60 + Integer.parseInt(splitTime[1]);
    }

    private String minuteToHHMM(int minute) {
        int hh = minute / 60;
        int mm = minute % 60;

        return (hh < 10 ? "0" + hh : hh + "") + ":" + (mm < 10 ? "0" + mm : mm + "");
    }

    private boolean isArrived(int crewArrivedTime, int busTime) {
        return crewArrivedTime <= busTime;
    }

    private boolean isCapableBus(int busIdx) {
        return buses.get(busIdx).size() < capableCount;
    }

    private void ride(int crew, int busIdx) {
        buses.get(busIdx).add(crew);
    }
}
