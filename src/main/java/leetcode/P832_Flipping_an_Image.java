package leetcode;

/*
	horizontally : 배열의 요소를 수평으로 뒤집는다.
	invert : 1은 0으로 0은 1로 변환한다.
*/

public class P832_Flipping_an_Image {

	public int[][] flipAndInvertImage(int[][] A) {
		// 배열 내 요소를 수평으로 뒤집는 메소드
		flip(A);
		// 요소의 값을 변환하는 메소드
		invert(A);

		// 결과를 반환한다.
		return A;
	}

	private void flip(int[][] a) {
		// 2차원 배열의 외부 요소에 순차 접근
		for (int i = 0, len = a.length; i < len; i++) {
			// 2차원 배열의 내부 요소의 값을 뒤집기 위한 left, right, temp 변수 선언
			int left = 0;
			int right = a[i].length - 1;
			int temp = 0;

			// 값을 전부 뒤집을 때까지 반복
			while(left <= right) {
				// 각 배열 요소의 맨 처음과 맨 끝부터 서로 교환해나간다.
				temp = a[i][left];
				a[i][left] = a[i][right];
				a[i][right] = temp;

				// 다음 인덱스를 처리하기 위해 인덱스 수정
				left++;
				right--;
			}
		}
	}

	private void invert(int[][] a) {
		// 2차원 배열의 외부 요소에 순차 접근
		for (int[] e : a) {
			// 2차원 배열의 내부 요소에 순차 접근
			for (int i = 0, len = e.length; i < len; i++) {
				// 내부 요소가 0인 경우 1로 변환하고 1인 경우는 0으로 변환한다.
				e[i] = e[i] == 0 ? 1 : 0;
			}
		}
	}

}
