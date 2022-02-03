package top.wuansg.note.leetcode;

public class Solution1725 {

    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0;
        int count = 0;
        for (int[] rectangle : rectangles) {
            int min = Math.min(rectangle[0], rectangle[1]);
            if (maxLen == min) {
                count++;
            } else if (maxLen < min) {
                count = 1;
                maxLen = min;
            }
        }
        return count;
    }
}
