package top.wuansg.note.leetcode;

/**
 * @author wunansheng
 * @since 2021/5/18
 */
public class Solution1442 {

    public int countTriplets(int[] arr) {
        int[] xors = new int[arr.length + 1];
        xors[0] = 0;
        for (int i = 0; i < arr.length; i++) {
            xors[i+1] = xors[i] ^ arr[i];
        }

        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int k = i+1; k < arr.length; k++) {
                if ((xors[k+1] ^ xors[i]) == 0) {
                    count += (k - i);
                }
            }
        }
        return count;
    }
}
