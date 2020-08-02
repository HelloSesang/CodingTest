import java.util.*;

public class Utility {

    public static void makeRandomNumber() {
        Random random = new Random();
        final int LIMIT = 10;
        int randomIndex = random.nextInt(LIMIT); // Range: 0 ~ LIMIT - 1
    }

    public static void addLists() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        result.addAll(list1);
        result.addAll(list2);
        result.addAll(list3);
    }

    public static void iterateMap() {
        Map<Integer, Integer> map = new TreeMap<>(); // TreeMap은 Key에 대해 오름차순 정렬된다.
        for (Integer e : map.keySet()) {
            int value = map.get(e);
        }
    }

}
