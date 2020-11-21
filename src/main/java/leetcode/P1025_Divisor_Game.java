package leetcode;

public class P1025_Divisor_Game {

	public boolean divisorGame(int N) {
		Player player = Player.Alice;

		int moveCount = 0;
		while ((moveCount = isMovePossible(N)) > 0) {
			N = N - moveCount;
			player = player == Player.Alice ? Player.Bob : Player.Alice;
		}

		return player == Player.Bob;
	}

	private int isMovePossible(int N) {
		for (int x = 1; x < N; x++) {
			if (N % x == 0) {
				return x;
			}
		}
		return 0;
	}

}

enum Player {
	Alice(),
	Bob
}
