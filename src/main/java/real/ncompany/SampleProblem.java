package real.ncompany;

/*
	회전수의 부호는 가장 바깥 테두리의 회전 방향을 결정
	회전수가 양수일 때 시계 방향, 음수일 때 반시계 방향
	인접한 두 테두리의 회전방향은 서로 반대
	회전수의 절댓값만큼 원소들이 이동
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SampleProblem {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 사용자 입력
		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]); // 행렬의 크기
		int w = Integer.parseInt(input[1]); // 회전수

		// 전광판 자료구조 구현
		String[][] display = new String[n][n];

		// 전광판 처음 상태 구현
		for (int i = 0; i < n; i++) {
			display[i] = br.readLine().split(" ");
		}

		// 방향 설정을 위한 변수 direction
		// 가장 외곽 테두리의 회전 방향 w가 양수인 경우 시계 방향
		boolean direction = true;
		// w가 음수인 경우 반시계 방향
		if (w < 0) {
			direction = false;
		}

		// n이 1인 경우 그냥 출력
		if (n <= 1) {
			for (String[] e : display) {
				System.out.println(Arrays.toString(e));
			}
		}

		// 회전하는 테두리의 갯수
		int borderCount = n / 2;

		// 회전하는 테두리마다 접근해서 w만큼 회전시키기
		for (int i = 0; i < borderCount; i++) {
			if (direction) {
				// 시계 방향으로 w만큼 회전
			} else {
				// 반시계 방향으로 w만큼 회전
			}
			direction = !direction;
		}

	}

}
