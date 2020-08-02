import java.io.*;
import java.util.*;

class Temp {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello World");
    }

    public static void problem4(String input1, String input2) {
        String[] first = input1.split(" ");
        String[] second = input2.split(" ");
        int[] kim = Arrays.stream(first).mapToInt(Integer::parseInt).toArray();
        int[] yi = Arrays.stream(second).mapToInt(Integer::parseInt).toArray();
        int[] result = new int[input1.length()];

        int rest = 0;
        for (int i = 0, len = result.length; i < len; i++) {
            // 김토스가 이토스에게 줘야할 금액이 더 많거나 같은 경우
                // 이토스에게 안받은 돈이 없는 경우
                // 이토스에게 안받은 돈이 있는 경우
            // 이토스가 김토스에게 줘야할 금액이 더 많은 경우
            if (kim[i] >= yi[i]) {
                result[i] = kim[i] - yi[i];

                if (rest > 0 && rest < result[i]) {
                    result[i] -= rest;
                    rest = 0;
                } else {
                    rest -= result[i];
                    result[i] = 0;
                }

            } else {
                rest += yi[i] - kim[i];
                result[i] = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0, len = result.length; i < len; i++) {
            sb.append(result[i]);
            if (i != len -1) {
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());
    }

    public static void problem3(String input) {
        String stringArray[] = input.split(" ");
        List<String> list = new LinkedList<>();

        for (String arrayStr : stringArray) {
            for (int i = 0, len = list.size(); i < len; i++) {
                if (arrayStr.equals(list.get(i))) {
                    list.remove(i);
                    break;
                }
            }

            list.add(0, arrayStr);

            if (list.size() > 5) {
                list.remove(5);
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0, len = list.size(); i < len; i++) {
                sb.append(list.get(i));
                if (i != len -1) {
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString());
        }
    }

    public static boolean problem2(String input) {
        String stringArray[] = input.split(" ");
        TreeSet<Integer> sortedSet = new TreeSet<>();
        for (String str : stringArray) {
            sortedSet.add(Integer.parseInt(str));
        }

        if (sortedSet.size() != 6 || sortedSet.size() != stringArray.length) {
            return false;
        }

        if (sortedSet.last() > 45) {
            return false;
        }

        int index = 0;
        Iterator value = sortedSet.iterator();
        while (value.hasNext()) {
            int sortedNum = (Integer) value.next();
            int originNum = Integer.parseInt(stringArray[index]);
            if (sortedNum != originNum) {
                return false;
            }
            index++;
        }

        return true;
    }





    public static boolean problem1(String input) {
        for (int i = 0, len = input.length(); i < len; i++) {
            char current = input.charAt(i);

            if (current != '1' && current != '2') {
                return false;
            }

            if (i != 0) {
                if (input.charAt(i - 1) == '1' && current != '2') {
                    return false;
                }
            }

            if (i == len -1 && current == '1') {
                return false;
            }
        }

        return true;
    }
}