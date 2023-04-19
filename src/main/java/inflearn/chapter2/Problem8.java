package inflearn.chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Problem8 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int scoreCount = in.nextInt();
        in.nextLine();
        List<Integer> scores = Arrays.stream(in.nextLine().split(" "))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        Map<Integer, List<Integer>> numberIndexInfo = new TreeMap<>((o1, o2) -> o2 - o1);
        for (int index = 0; index < scores.size(); index++) {
            Integer currentNumber = scores.get(index);
            if (numberIndexInfo.containsKey(currentNumber)) {
                numberIndexInfo.get(currentNumber).add(index);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(index);
                numberIndexInfo.put(currentNumber, list);
            }
        }

        int[] result = new int[scores.size()];
        AtomicInteger rank = new AtomicInteger(1);
        numberIndexInfo.forEach((key, indexs) -> {
            indexs.stream().forEach(integer -> result[integer] = rank.get());
            rank.set(rank.get() + indexs.size());
        });

        for(int number : result) {
            System.out.print(number);
            System.out.print(" ");
        }
    }
}
