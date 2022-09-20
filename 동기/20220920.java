package com.example.algover2.programmers.lv2.셔틀버스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        boolean[] times = new boolean[1500];
        int lastTime = 540 + (n - 1) * t;

        // 이것은 사람들이 탈 시간 아으
        // 분으로 바꿔서 오름차순 ArrayList
        List<Integer> arr = new ArrayList<>();

        for (String s : timetable) {
            String[] split = s.split(":");
            int time = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
//            times[time] = true;
            arr.add(time);
        }
        Collections.sort(arr);
        // 480 481 482 483
        // 마지막 셔틀 버스에 탄 사람에 대해 알고싶다.
        int lastPerson = arr.get(arr.size() - 1); // 483
        int lastBus = 0;
        for (int i = 540; i < n - 1; i += t) {
            lastBus = i;
            for (int j = 0; j < m; j++) {
                Integer integer = arr.get(j);
                if (lastBus >= integer) {
                    arr.remove(integer);
                }
            }
        }


        return answer;
    }
}
