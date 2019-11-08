package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10828_스택 {

	private Commands commands;

	private Stack stack;

	public static void main(String[] args) throws IOException {
		P10828_스택 obj = new P10828_스택();
		obj.getInputValue();
		obj.processCommands();
	}

	private void getInputValue() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int commandCount = Integer.parseInt(br.readLine());

		commands = new Commands(commandCount);
		for (int i = 0; i < commandCount; i++) {
			String input = br.readLine();
			commands.addCommand(input);
		}
	}

	private void processCommands() {
		Stack stack = new Stack(commands.getCommandCount());
		stack.processCommands(commands);
	}

	class Commands {

		private int commandCount;

		private String[] commandType;

		private int[] numbers;

		private int index = 0;

		public Commands(int length) {
			this.commandCount = length;
			this.commandType = new String[length];
			this.numbers = new int[length];
		}

		public void addCommand(String input) {
			String[] splitResult = input.split(" ");
			commandType[index] = splitResult[0];

			if (splitResult[0].equals("push")) {
				numbers[index] = Integer.parseInt(splitResult[1]);
			}
			index++;
		}

		public int getCommandCount() {
			return commandCount;
		}

		public String getCommandType(int index) {
			return commandType[index];
		}

		public int getNumbers(int index) {
			return numbers[index];
		}
	}

	class Stack {

		private int[] stack;

		private int index = 0;

		public Stack(int length) {
			this.stack = new int[length];
		}

		public void processCommands(Commands commands) {
			int commandCount = commands.commandCount;
			for (int i = 0; i < commandCount; i++) {
				branchOffCommand(commands.getCommandType(i), commands.getNumbers(i));
			}
		}

		private void branchOffCommand(String commandType, int number) {
			if (commandType.equals("push")) {
				push(number);
			}

			if (commandType.equals("pop")) {
				pop();
			}

			if (commandType.equals("size")) {
				size();
			}

			if (commandType.equals("empty")) {
				empty();
			}

			if (commandType.equals("top")) {
				top();
			}
		}

		private void top() {
			if (index == 0) {
				System.out.println(-1);
			} else {
				System.out.println(stack[index - 1]);
			}
		}

		private void empty() {
			if (index == 0) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}

		private void size() {
			System.out.println(index);
		}

		private void pop() {
			if (index != 0) {
				System.out.println(stack[index - 1]);
				index--;
			} else {
				System.out.println(-1);
			}
		}

		private void push(int number) {
			stack[index] = number;
			index++;
		}
	}
}
