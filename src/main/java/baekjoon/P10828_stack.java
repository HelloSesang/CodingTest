package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P10828_stack {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		int[] stack = new int[count];
		int index = -1;
		while (count-- > 0) {
			String[] input = br.readLine().split(" ");
			String cmd = input[0];
			switch(cmd) {
				case "push":
					int value = Integer.parseInt(input[1]);
					stack[++index] = value;
					break;
				case "pop":
					int poped = index > -1 ? stack[index--] : -1;
					System.out.println(poped);
					break;
				case "size":
					System.out.println(index + 1);
					break;
				case "empty":
					int emptyYn = index > -1 ? 0 : 1;
					System.out.println(emptyYn);
					break;
				case "top":
					int top = index > -1 ? stack[index] : -1;
					System.out.println(top);
					break;
			}
		}
	}

}
