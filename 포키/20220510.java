import java.util.*;

public class 20220510 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Time> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            list.add(new Time(sc.nextInt(), sc.nextInt()));
        }

        list.sort(Comparator.comparingInt(Time::getEnd).thenComparingInt(Time::getStart));

        int count = 1;

        int endTime = list.get(0).getEnd();
        for (int i = 1; i < list.size(); i++) {
            Time t = list.get(i);
            int start = t.getStart();
            if (endTime <= start) {
                count++;
                endTime = t.getEnd();
            }
        }
        System.out.println(count);
    }

    static class Time {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
}
