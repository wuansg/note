package top.wuansg.note.leetcode;

import top.wuansg.note.util.Assertions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wunansheng
 * @since 2021/6/3
 */
public class Solution525 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0};
        Solution525 solution525 = new Solution525();
        Assertions.assertEquals(2, solution525.findMaxLength(nums));
        nums = new int[]{0,1,0,0,1,1};
        Assertions.assertEquals(6, solution525.findMaxLength(nums));
        nums = new int[]{1};
        Assertions.assertEquals(0, solution525.findMaxLength(nums));
        nums = new int[]{1,1,1,1,1,1,1,1};
        Assertions.assertEquals(0, solution525.findMaxLength(nums));
    }

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            count += nums[i] == 0 ? 1 : -1;
            if (map.containsKey(count)) {
                maxLength = Math.max(maxLength, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxLength;
    }
}
