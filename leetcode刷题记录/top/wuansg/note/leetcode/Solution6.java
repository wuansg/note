package top.wuansg.note.leetcode;

/**
 * @author wunansheng
 * @since 2021/5/14
 */
public class Solution6 {
    public static void main(String[] args) {
        System.out.println(new Solution6().convert("ABC", 2));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int[][] dp = new int[numRows][2];
        for (int i = 0; i < numRows; i++) {
            dp[i][0] = (numRows - i - 1) * 2;
            dp[i][1] = (numRows - 1) * 2 - dp[i][0];
        }
        char[] con = new char[s.length()];
        int length = s.length();
        int index = 0;
        for (int i = 0; i < numRows; i++) {
            int start = i;
            if (start < length) {
                con[index++] = s.charAt(start);
            }
            while (start < length) {
                if (dp[i][0] != 0) {
                    start += dp[i][0];
                    if (start < length) {
                        con[index++] = s.charAt(start);
                    }
                }
                if (dp[i][1] != 0) {
                    start += dp[i][1];
                    if (start < length) {
                        con[index++] = s.charAt(start);
                    }
                }
            }
        }
        return new String(con);
    }
}
