package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 문자열_내_마음대로_정렬하기 {

    public static void main(String[] args) {
        문자열_내_마음대로_정렬하기 obj = new 문자열_내_마음대로_정렬하기();
        String[] arr = {"abce", "abcd", "cdx"};
        String[] answer = obj.solution(arr, 2);
        System.out.println(Arrays.toString(answer));
    }

    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings);
        List<String> list = new ArrayList<>(Arrays.asList(strings));
        Collections.sort(list, (o1, o2) -> o1.charAt(n) - o2.charAt(n));
        return list.toArray(new String[list.size()]);
    }

}
