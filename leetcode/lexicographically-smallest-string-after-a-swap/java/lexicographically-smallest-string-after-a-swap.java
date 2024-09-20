class Solution {
    public String getSmallestString(String s) {
        int sLen = s.length();
        int[] sIntArr = new int[sLen];
        String res = s;

        for (int i=1; i<sLen; i++) {
            char now = s.charAt(i);
            char prev = s.charAt(i-1);
            if ((now % 2 == 0) == (prev % 2 == 0) && now < prev) {
                StringBuilder sb = new StringBuilder(s);
                sb.setCharAt(i-1, now);
                sb.setCharAt(i, prev);

                res = sb.toString();
                break;
            }
        }

        return res;
    }
}