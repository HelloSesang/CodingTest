import java.util.ArrayDeque;
import java.util.Deque;

public class URLify {

	public static void main(String[] args) {
		Deque<Character> queue = new ArrayDeque<>();
		char[] org = {'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'S', 'm', 'i', 't', 'h'};
		for (int i = 0; i < org.length; i++) {
			if (org[i] == ' ') {
				queue.offerLast('%');
				queue.offerLast('2');
				queue.offerLast('0');
			} else {
				queue.offerLast(org[i]);
			}
		}
		StringBuilder sb = new StringBuilder();
		while (queue.size() > 0) {
			sb.append(queue.pollFirst());
		}
		System.out.println(sb.toString());
	}

}
