package experience.zcompany;

public class Problem3_retry {

	public int solution(String[] bishops) {
		int answer = 0;
		// 체스판 자료구조를 생성한다.
		boolean[][] board = new boolean[8][8];

		// bishops 배열에 순차 접근한다.
		for (String str : bishops) {
			// bishop의 위치를 계산
			char[] pos = str.toCharArray();
			int row = pos[0]  - 'A';
			int col = Character.getNumericValue(pos[1]) - 1;

			// 보드에 설정한다.
			board[row][col] = true;

			// 비숍이 한번에 이동할 수 있는 위치를 전부 체크한다.
			int up = row - 1;
			int down = row + 1;
			int left = col - 1;
			int right = col + 1;
			while (up >= 0 || down < 8 || left >= 0 || right < 8) {
				if (up >= 0 && left >= 0) {
					board[up][left] = true;
				}
				if (up >= 0 && right < 8) {
					board[up][right] = true;
				}
				if (down < 8 && left >= 0) {
					board[down][left] = true;
				}
				if (down < 8 && right < 8) {
					board[down][right] = true;
				}
				up--;
				down++;
				left--;
				right++;
			}
		}

		// answer에 체스판 중 아직 false인 것의 갯수를 세서 저장한다.
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (!board[i][j]) {
					answer++;
				}
			}
		}

		// 최종 결과를 반환한다.
		return answer;
	}
}
