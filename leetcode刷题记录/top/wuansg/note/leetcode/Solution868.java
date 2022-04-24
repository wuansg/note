package top.wuansg.note.leetcode;

public class Solution868 {

    public int binaryGap(int n) {
        int max = 0;
        int last = -1;
        int index = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                max = last == -1 ? 0 : Math.max(max, index - last);
                last = index;
            }
            index++;
            n = n >> 1;
        }
        return max;
    }
}
