package top.wuansg.note.leetcode;

/**
 * @author wunansheng
 * @since 2021/9/17
 */
public class Solution80 {
    public int removeDuplicates(int[] nums) {
        boolean duplicate = false;
        int newIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1] && duplicate) continue;
            else if (nums[i] == nums[i-1]) { nums[newIndex++] = nums[i]; duplicate = true; }
            else { nums[newIndex++] = nums[i]; duplicate = false; }
        }
        return newIndex;
    }
}
