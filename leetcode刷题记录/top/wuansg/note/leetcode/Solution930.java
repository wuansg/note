package top.wuansg.note.leetcode;

import top.wuansg.note.util.Assertions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wunansheng
 * @since 2021/7/8
 */
public class Solution930 {

    public static void main(String[] args) {
        Solution930 solution930 = new Solution930();
        int[] nums = new int[]{1,0,1,0,1};
        Assertions.assertEquals(4, solution930.numSubarraysWithSum(nums, 2));
        nums = new int[]{0,0,0,0,0};
        Assertions.assertEquals(15, solution930.numSubarraysWithSum(nums, 0));
        nums = new int[]{0,1,1,1,1};
        Assertions.assertEquals(3, solution930.numSubarraysWithSum(nums, 3));
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        int size = Arrays.stream(nums).sum();
        int[] cache = new int[size+1];
        cache[0] = 1;
        int count = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            count += sum - goal >= 0 ? cache[sum - goal] : 0;
            cache[sum]++;
        }
        return count;
    }
}
