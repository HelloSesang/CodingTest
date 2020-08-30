package experience.bcompany;

public class Problem2 {

    public static int programmerStrings(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }

        int leftEndIndex = findLeftProgrammerStringEndIndex(s);
        int rightStartIndex = findRightProgrammerStringStartIndex(s);

        int betweenCharCount = rightStartIndex - leftEndIndex - 1;

        if (betweenCharCount < 0) {
            return 0;
        }

        return betweenCharCount;
    }

    static int findLeftProgrammerStringEndIndex(String s) {
        Condition condition = new Condition();

        for (int i = 0, len = s.length(); i < len; i++) {
            if (condition.isSatisfy(s.charAt(i))) {
                return i;
            }
        }

        return 0;
    }

    static int findRightProgrammerStringStartIndex(String s) {
        Condition condition = new Condition();

        for (int i = s.length() - 1; i >= 0; i--) {
            if (condition.isSatisfy(s.charAt(i))) {
                return i;
            }
        }

        return 0;
    }

    static class Condition {

        private int pCount = 1;
        private int rCount = 3;
        private int oCount = 1;
        private int gCount = 1;
        private int aCount = 1;
        private int mCount = 2;
        private int eCount = 1;
        private int totalCount = 10;

        public boolean isSatisfy(char ch) {
            if (ch == 'p' && pCount > 0) {
                pCount--;
                totalCount--;
            } else if (ch == 'r' && rCount > 0) {
                rCount--;
                totalCount--;
            } else if (ch == 'o' && oCount > 0) {
                oCount--;
                totalCount--;
            } else if (ch == 'g' && gCount > 0) {
                gCount--;
                totalCount--;
            } else if (ch == 'a' && aCount > 0) {
                aCount--;
                totalCount--;
            } else if (ch == 'm' && mCount > 0) {
                mCount--;
                totalCount--;
            } else if (ch == 'e' && eCount > 0) {
                eCount--;
                totalCount--;
            }

            return totalCount <= 0;
        }
    }
}