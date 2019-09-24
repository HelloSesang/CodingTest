package programmers;

public class 정수_제곱근_판별 {

	public long solution(long n) {
		long square = (long) Math.sqrt(n);
		if (square * square != n) {
			return -1;
		}
		return (long) Math.pow(square + 1, 2);
	}

}
