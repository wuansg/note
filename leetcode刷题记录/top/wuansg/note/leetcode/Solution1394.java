package top.wuansg.note.leetcode;

/**
 * @author wunansheng
 * @since 2021/6/2
 */
public class Solution1394 {

    public static void main(String[] args) {
        byte b = 127;
        System.out.println(++b);
        System.out.println(-123);
        int[] input = new int[]{1,2,2,3,3,3};
        System.out.println(new Solution1394().findLucky(input));
    }

    public int findLucky(int[] arr) {
        short[] nums = new short[arr.length];
        for (int i : arr) {
            if (i > arr.length) continue;
            nums[i-1]++;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == i+1) {
                return i+1;
            }
        }
        return -1;
    }
}
