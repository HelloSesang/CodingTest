package experience.zcompany;

public class Problem3 {

    private static final int SIZE = 8;

    public static void main(String[] args) {
        Problem3 problem3 = new Problem3();
        String[] arr = {"D5", "E8", "G2"};
//		String[] arr = {"D5"};
        System.out.println(problem3.solution(arr));
    }

    public int solution(String[] bishops) {
        int answer = SIZE * SIZE;

        boolean[][] board = new boolean[SIZE][SIZE];

        for (int i = 0, len = bishops.length; i < len; i++) {
            int x = bishops[i].charAt(0) - 'A';
            int y = Character.getNumericValue(bishops[i].charAt(1) - 1);
            answer -= checkBoard(x, y, board);
        }
        return answer;
    }

    private int checkBoard(int xPos, int yPos, boolean[][] board) {
        int checkCount = 0;
        int x = xPos, y = yPos;
        if (!board[x][y]) {
            board[x][y] = true;
            checkCount++;
        }
        while (--x >= 0 && ++y < 8) {
            if (!board[x][y]) {
                board[x][y] = true;
                checkCount++;
            }
        }
        x = xPos;
        y = yPos;
        while (--x >= 0 && --y >= 0) {
            if (!board[x][y]) {
                board[x][y] = true;
                checkCount++;
            }
        }
        x = xPos;
        y = yPos;
        while (++x < SIZE && ++y < SIZE) {
            if (!board[x][y]) {
                board[x][y] = true;
                checkCount++;
            }
        }
        x = xPos;
        y = yPos;
        while (++x < SIZE && --y >= 0) {
            if (!board[x][y]) {
                board[x][y] = true;
                checkCount++;
            }
        }
        return checkCount;
    }
}