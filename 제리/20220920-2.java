import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

	public String solution(int n, int t, int m, String[] timetable) {

		List<List<Integer>> buses = new ArrayList<>();
		for (int i = 0 ; i < n; i++) {
			buses.add(new ArrayList<>());
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (String time : timetable) {
			String[] hhmm = time.split(":");
			int minute = Integer.parseInt(hhmm[0]) * 60 + Integer.parseInt(hhmm[1]);
			pq.add(minute);
		}

		int busTime = 9 * 60;
		int answer = 0;

		for (int i = 0; i < n; i++) {
			while(!pq.isEmpty()) {
				int crew = pq.poll();
				if (crew <= busTime && buses.get(i).size() < m) {
					buses.get(i).add(crew);
					answer = crew - 1;
				} else {
					pq.offer(crew);
					break;
				}
			}
			busTime = busTime + t;
		}

		if (buses.get(n - 1).size() < m) {
			answer = busTime - t;
		}

		int hh = answer / 60;
		int mm = answer % 60;

		return (hh < 10 ? "0" + hh : hh + "") + ":" + (mm < 10 ? "0" + mm : mm + "");
	}
}
