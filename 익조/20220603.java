import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

    static class Student implements Comparable<Student> {
        int id;
        int score;
        int time;

        public Student(int id, int score, int time) {
            this.id = id;
            this.score = score;
            this.time = time;
        }

        @Override
        public int compareTo(Student target) {
            if (this.score == target.score) {
                return this.time - target.time;
            }
            return this.score - target.score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        Map<Integer, Student> frames = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Student> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int studentId = Integer.parseInt(st.nextToken());

            if (frames.containsKey(studentId)) {
                frames.get(studentId).score++;
            }
            else {
                if (list.size() == n) {
                    Student s = list.get(0);
                    list.remove(s);
                    frames.remove(s.id);
                }
                Student student = new Student(studentId, 1, i);
                frames.put(studentId, student);
                list.add(student);
            }

            Collections.sort(list);
        }

        List<Integer> result = new ArrayList<>();
        for (Student student : list) {
            result.add(student.id);
        }

        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        for (Integer integer : result) {
            sb.append(integer).append(" ");
        }

        System.out.println(sb);
    }
}
