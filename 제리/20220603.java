package Baekjoon.num1713;

/*
	문제    : BOJ 후보 추천하기
    유형    : 구현
	난이도   : MEDIUM (S2)
	시간    : 60m
	uri    : https://www.acmicpc.net/problem/1713
    날짜    : 22.06.03(o)
    refer  :
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Student implements Comparable<Student> {

		int studentId;
		int countOfRecommend;
		int sequence;

		public Student(int studentId, int countOfRecommend, int sequence) {
			this.studentId = studentId;
			this.countOfRecommend = countOfRecommend;
			this.sequence = sequence;
		}

		@Override
		public int compareTo(Student s) {
			if (this.countOfRecommend == s.countOfRecommend) {
				return this.sequence - s.sequence;
			}
			return this.countOfRecommend - s.countOfRecommend;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int countOfFrame = Integer.parseInt(br.readLine());
		int repeat = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		List<Student> frame = new ArrayList<>();

		//todo
		// Frame 이 모두 차 있지 않고
		//       만약 Frame에 있으면 리스트에 있는 값에 추천 수를 1 더함
		//                  없으면 그냥 리스트에 넣음
		// Frame 이 모두 다 차 있고
		//       만약 Frame에 있으면 리스트에 있는 값에 추천 수를 1 더함
		//                  없으면 리스트를 정렬한 후에 첫번째 인덱스를 제거하고 리스트에 넣음

		for (int i = 0; i < repeat; i++) {
			int recommendedStudent = Integer.parseInt(st.nextToken());

			boolean isExist = frame.stream()
				.anyMatch(s -> s.studentId == recommendedStudent);

			if (isExist) {
				Student student = frame.stream().filter(s -> s.studentId == recommendedStudent)
					.findAny().get();
				student.countOfRecommend++;
				continue;
			}

			if (frame.size() < countOfFrame) {
				frame.add(new Student(recommendedStudent, 1, i));
				continue;
			}

			Collections.sort(frame);
			frame.remove(0);
			frame.add(new Student(recommendedStudent, 1, i));

		}

		frame.stream()
			.sorted((o1, o2) -> o1.studentId - o2.studentId)
			.forEach(s -> System.out.print(s.studentId + " "));

	}

}
