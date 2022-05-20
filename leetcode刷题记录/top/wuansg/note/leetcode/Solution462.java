package top.wuansg.note.leetcode;

import top.wuansg.note.util.Assertions;

import java.util.Arrays;

//给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最少移动数。
//
// 在一步操作中，你可以使数组中的一个元素加 1 或者减 1 。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：2
//解释：
//只需要两步操作（每步操作指南使一个元素加 1 或减 1）：
//[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
//
//
// 示例 2：
//
//
//输入：nums = [1,10,2,9]
//输出：16
//
//
//
//
// 提示：
//
//
// n == nums.length
// 1 <= nums.length <= 10⁵
// -10⁹ <= nums[i] <= 10⁹
//
public class Solution462 {

    public static void main(String[] args) {
        Solution462 solution462 = new Solution462();
        Assertions.assertEquals(2, solution462.minMoves2(new int[]{1,2,3}));
        Assertions.assertEquals(16, solution462.minMoves2(new int[]{1,10,2,9}));
        Assertions.assertEquals(4705, solution462.minMoves2(new int[]{1,2,3,34,4554,123}));
    }

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int avg = nums[(nums.length-1) / 2];
        return Arrays.stream(nums)
                .map(i -> Math.abs(i - avg))
                .sum();
    }
}
