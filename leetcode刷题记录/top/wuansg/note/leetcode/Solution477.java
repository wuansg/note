package top.wuansg.note.leetcode;

/**
 * @author wuansg
 * @since 2021/6/1
 */
public class Solution477 {

    private static Solution477 solution477;

    public static void main(String[] args) {
        System.out.println(15 & 1);
        int[] nums = new int[]{4, 14, 2};
        int result = getInstance().totalHammingDistance(nums);
        System.out.println(result);
    }

    public static Solution477 getInstance() {
        if (solution477 == null) {
            solution477 = new Solution477();
        }
        return solution477;
    }

    public int totalHammingDistance(int[] nums) {
        int totalDistance = 0;
        int tmp = 1;
        for (int i = 0; i < 32; i++) {
            int sizeOf1 = 0;
            for (int num : nums) {
                sizeOf1 += ((num & tmp) != 0 ? 1 : 0);
            }
            totalDistance += (nums.length - sizeOf1) * sizeOf1;
            tmp <<= 1;
        }
        return totalDistance;
    }
}
