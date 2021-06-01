package top.wuansg.note.leetcode;

/**
 * @author wunansheng
 * @since 2021/4/28
 */
public class Solution198 {
    public static void main(String[] args) {
        int result = rob(new int[]{2,7,9,3,1});
        System.out.println(result);
    }

    private static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[1], nums[0]);
        int a = 0, b = nums[0], c = nums[1];
        for (int i = 2; i < nums.length; i++) {
            int sum = Math.max(a + nums[i], b + nums[i]);
            a = b;
            b = c;
            c = sum;
        }
        return c;
    }
}
