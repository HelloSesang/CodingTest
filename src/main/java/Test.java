public class Test {

	private int addNumbers(int first, int second) {
		if (first > 42) {
			throw new IllegalArgumentException();
		}
		return 0;
	}

	public static void main(String[] args) {
		Test test = new Test();
		test.addNumbers(1000, 50);
	}
}