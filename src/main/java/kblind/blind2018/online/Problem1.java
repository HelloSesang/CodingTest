package kblind.blind2018.online;

import java.util.*;

class Problem1 {

    public static void main(String[] args) {
        Problem1 solution2 = new Problem1();
        String[] arr = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution2.solution(arr)));
    }

    public String[] solution(String[] record) {
        Map<String, String> userInfo = new HashMap<>();
        for (String e : record) {
            String[] input = e.split(" ");
            if (input[0].equals("Enter") || input[0].equals("Change")) {
                userInfo.put(input[1], input[2]);
            }
        }

        List<String> list = new ArrayList<>();
        for (String e : record) {
            String[] input = e.split(" ");
            String nickName = userInfo.get(input[1]);
            if (input[0].equals("Enter")) {
                list.add(nickName + "님이 들어왔습니다.");
            } else if (input[0].equals("Leave")) {
                list.add(nickName + "님이 나갔습니다.");
            }
        }

        String[] answer = new String[list.size()];
        for (int i = 0, len = list.size(); i < len; i++) {
            answer[i] = list.get(i);
        }

        return list.toArray(new String[list.size()]);
    }
}