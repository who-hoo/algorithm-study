import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        long T = Long.parseLong(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            long[] values = new long[N];
            ArrayList<Info> infos = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int value = Integer.parseInt(st.nextToken());
                values[i] = value;
                infos.add(new Info(i, value));
            }

            Collections.sort(infos);
            long cnt = 0; // 보유 주식 수
            long amt = 0; // 투자 금액
            long answer = 0;
            ListIterator<Info> infoListIterator = infos.listIterator();
            Info dDay = infoListIterator.next(); // 제일 최고점
            for (int i = 0; i < N; i++) {
                // 제일최고점이면,
                if (i == dDay.day && values[i] == dDay.value) {
                    // 전량매도
                    answer += (dDay.value * cnt) - amt;
                    cnt = 0;
                    amt = 0;
                    // 다음 최고점
                    while (dDay.day <= i && infoListIterator.hasNext()) {
                        dDay = infoListIterator.next();
                    }
                } else if (values[i] < dDay.value) { // 아니면 매수
                    cnt += 1;
                    amt += values[i];
                }
            }
            sb.append(answer).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

class Info implements Comparable<Info> {

    long day;
    long value;

    public Info(long day, long value) {
        this.day = day;
        this.value = value;
    }

    @Override
    public int compareTo(Info o) {
        if (this.value > o.value) {
            return -1;
        }
        if (this.value == o.value) {
            return 0;
        }
        return 1;
    }
}
