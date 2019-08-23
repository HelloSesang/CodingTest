package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P10825_sort {

	private static List<Student> list = new ArrayList<>();

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		int studentCnt = Integer.parseInt(br.readLine());
		getStudent(studentCnt);
		list.sort((o1, o2) -> {
			if (o1.getKor() != o2.getKor()) return o2.getKor() - o1.getKor();
			if (o1.getEng() != o2.getEng()) return o1.getEng() - o2.getEng();
			if (o1.getMath() != o2.getMath()) return o2.getMath() - o1.getMath();
			for (int i = 0, len = Math.min(o1.getName().length(), o2.getName().length()); i < len; i++) {
				char ch1 = o1.getName().charAt(i);
				char ch2 = o2.getName().charAt(i);
				if (ch1 != ch2) return ch1 - ch2;
			}
			return o1.getName().length() <= o2.getName().length() ? -1 : 1;
		});
		for (Student e : list) {
			System.out.println(e.getName());
		}
	}

	private static void getStudent(int studentCnt) throws Exception {
		while (studentCnt-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			Student student = new Student(name, kor, eng, math);
			list.add(student);
		}
	}

	static class Student {

		private String name;

		private int kor;

		private int eng;

		private int math;

		public Student(String name, int kor, int eng, int math) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getKor() {
			return kor;
		}

		public void setKor(int kor) {
			this.kor = kor;
		}

		public int getEng() {
			return eng;
		}

		public void setEng(int eng) {
			this.eng = eng;
		}

		public int getMath() {
			return math;
		}

		public void setMath(int math) {
			this.math = math;
		}

		@Override
		public String toString() {
			return "student{" +
					"name='" + name + '\'' +
					", kor=" + kor +
					", eng=" + eng +
					", math=" + math +
					'}';
		}
	}
}