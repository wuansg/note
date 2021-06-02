package top.wuansg.note.leetcode;

import java.util.Arrays;

/**
 * @author wunansheng
 * @since 2021/6/1
 */
public class Solution1744 {
    public static void main(String[] args) {
        int[] ints = new int[]{7,4,5,3,8};
        new Solution1744().canEat(ints, null);
    }

    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        long[] count = new long[candiesCount.length];
        count[0] = candiesCount[0];
        for (int i = 1; i < candiesCount.length; i++) {
            count[i] += count[i-1];
        }
        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int days = queries[i][1] + 1;
            result[i] = count[queries[i][0]] >= days && (queries[i][0] == 0 ? 0 : count[queries[i][0]-1]) < (long)days * (long)queries[i][2];
        }
        return result;
    }
}
