package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P10430_math {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int first = Integer.parseInt(st.nextToken());
		int second = Integer.parseInt(st.nextToken());
		int third = Integer.parseInt(st.nextToken());

		bw.write(String.valueOf((first + second) % third));
		bw.newLine();
		bw.write(String.valueOf(((first % third) + (second % third)) % third));
		bw.newLine();
		bw.write(String.valueOf((first * second) % third));
		bw.newLine();
		bw.write(String.valueOf(((first % third) * (second % third)) % third));
		bw.flush();
	}

}
