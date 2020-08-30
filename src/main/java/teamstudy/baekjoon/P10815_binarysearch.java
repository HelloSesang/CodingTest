package teamstudy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P10815_binarysearch {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cardCount = Integer.parseInt(br.readLine());
        Set<Integer> cards = new HashSet<>();
        Arrays.stream(br.readLine().split(" ")).forEach(s -> cards.add(Integer.parseInt(s)));
        int numberCount = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringBuilder sb = new StringBuilder();
        for (int e : numbers) {
            sb.append((cards.contains(e) ? 1 : 0) + " ");
        }
        System.out.println(sb);
    }

}
