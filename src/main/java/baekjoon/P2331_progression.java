package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P2331_progression {

    private static Map<Integer, Integer> map = new HashMap<>();

    private static int power;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int key = Integer.parseInt(input[0]);
        power = Integer.parseInt(input[1]);
        System.out.println(getResult(key, 1));
    }

    private static int getResult(int key, int index) {
        if (map.containsKey(key)) {
            return map.get(key) - 1;
        }
        map.put(key, index);
        return getResult(getNextKey(key), index + 1);
    }

    private static int getNextKey(int key) {
        int nextKey = 0;
        while (key != 0) {
            nextKey += (int) Math.pow(key % 10, power);
            key /= 10;
        }
        return nextKey;
    }

}
