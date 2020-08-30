package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P2751_sort {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new ArrayList<>();
        int count = Integer.parseInt(br.readLine());
        while (count-- > 0) list.add(Integer.parseInt(br.readLine()));
        Collections.sort(list);

        for (Integer e : list) {
            bw.write(String.valueOf(e));
            bw.newLine();
            bw.flush();
        }
    }
}
