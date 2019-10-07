package real.ncompany;

/*
	queue 자료구조를 만든다.
	queue 내부 아이템의 빈도수가 가장 높은 수부터 먼저 반환하는 규칙이 있는 queue
	enqueue(x) : 양의 정수 x를 입력받아 FQ에 저장
	dequeue() : 빈도수가 가장 높은 수 중 가장 먼저 enqueue 된 수를 반환하고 제거(빈도수와 순서)
	            큐가 비어있는 경우 -1 반환
	인큐 디큐 명령을 받아서 그 결과를 출력하라
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Problem2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 명령행의 개수
		int commandCount = Integer.parseInt(br.readLine());

		// enqueue한 값을 담을 queue
		Deque<Integer> queue = new ArrayDeque<>();
		// 타겟이 아닌 값을 잠시 옮겨 담아놓을 queue
		Deque<Integer> temp = new ArrayDeque<>();
		// 입력값 별 빈도수를 저장할 HashMap
		Map<Integer, Integer> map = new HashMap<>();

		// 명령행의 수만큼 반복한다.
		while (commandCount-- > 0) {
			// 명령을 입력 받는다.
			String[] input = br.readLine().split(" ");

			if (input[0].equals("enqueue")) {
				// enqueue 명령인 경우
				int number = Integer.parseInt(input[1]);

				// 큐에 삽입한다.
				queue.offerLast(number);

				// map에 빈도수를 카운팅한다.
				int count = map.getOrDefault(number, 0);
				map.put(number, count + 1);
			} else {
				// dequeue 명령인 경우

				// queue가 비어있다면 -1를 출력하고 명령을 종료한다.
				if (queue.size() <= 0) {
					System.out.println(-1);
					continue;
				}

				// 가장 높은 빈도수가 몇인지 찾는다.
				int max = 0;
				for (Integer e : map.keySet()) {
					if (max < map.get(e)) {
						max = map.get(e);
					}
				}

				// 빈도수가 가장 높은 것을 찾아서 제거할 때까지 반복한다.
				boolean flag = false;
				while (!flag) {
					if (map.get(queue.peek()) == max) {
						// 현재 queue의 가장 앞에 있는 수가 빈도수가 가장 높은 경우
						// queue에서 제거하고 출력한다.
						int target = queue.pollFirst();
						System.out.print(target);
						System.out.print(" ");

						// 제거한 대로 빈도수를 재조정한다.
						int count = map.get(target);
						map.put(target, count - 1);
						flag = true;
					} else {
						// 빈도수가 가장 높은 것이 아닌 경우 temp로 잠시 옮겨놓는다.
						temp.offerLast(queue.pollFirst());
					}
				}

				// 임시로 옮겨놨던 값을 다시 queue로 돌려놓는다.
				while (temp.size() != 0) {
					queue.offerFirst(temp.pollLast());
				}
			}
		}
	}

}
