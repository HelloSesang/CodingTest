package leetcode;

import java.util.*;

public class P1202_Smallest_String_With_Swaps {

    private int[] parent;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        // 집합을 나타내기 위한 배열
        parent = new int[s.length()];

        // 집합 초기화
        for (int i = 0, len = parent.length; i < len; i++) {
            parent[i] = i;
        }

        // 서로 교환 가능한 위치들은 같은 집합으로 만든다.
        for (List<Integer> pair : pairs) {
            union(Math.min(pair.get(0), pair.get(1)), Math.max(pair.get(0), pair.get(1)));
        }

        // 문자열의 각 문자를 집합별로 분류해서 우선순위 큐에 담는다.
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for (int i = 0, len = arr.length; i < len; i++) {
            int root = find(i);
            map.putIfAbsent(root, new PriorityQueue<>());
            map.get(root).add(arr[i]);
        }

        // 문자열의 각각의 인덱스에 소속 집합에서 사전순으로 가장 빠른 것부터 꺼내가며
        // 새로운 문자열을 생성한다.
        StringBuilder sb = new StringBuilder();
        for (int i = 0, len = parent.length; i < len; i++) {
            sb.append(map.get(parent[i]).poll());
        }

        // 생성된 결과를 반환한다.
        return sb.toString();
    }

    // 집합의 루트를 찾는 메서드
    public int find(int x) {
        // 현재가 집합의 루트인 경우
        if (x == parent[x]) {
            return x;
        }

        // 집합의 루트가 아닌 경우 find 메서드를 재귀적으로 호출해서 루트를 찾는다.
        int y = find(parent[x]);
        parent[x] = y;
        return y;
    }

    // 두 집합을 서로 합치는 메서드
    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        parent[y] = x;
    }
}
