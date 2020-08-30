package experience.bcompany;

import java.util.List;

public class Problem4 {

    // Complete the maxInversions function below.
    static long maxInversions(List<Integer> prices) {
        long answer = 0;

        for (int i = 0, iLen = prices.size() - 2; i < iLen; i++) {
            int first = prices.get(i);

            for (int j = i + 1, jLen = prices.size() - 1; j < jLen; j++) {
                int second = prices.get(j);
                if (first < second) {
                    continue;
                }

                for (int k = j + 1, kLen = prices.size(); k < kLen; k++) {
                    int third = prices.get(k);
                    if (second > third) {
                        answer++;
                        System.out.println(first + " " + second + " " + third);
                    }
                }
            }
        }

        return answer;
    }

}
