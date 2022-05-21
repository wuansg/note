package top.wuansg.note.leetcode;

import top.wuansg.note.util.Assertions;

import java.util.HashMap;
import java.util.Map;

//给你一个整数数组 nums ，该数组具有以下属性：
//
//
//
//
// nums.length == 2 * n.
// nums 包含 n + 1 个 不同的 元素
// nums 中恰有一个元素重复 n 次
//
//
// 找出并返回重复了 n 次的那个元素。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3,3]
//输出：3
//
//
// 示例 2：
//
//
//输入：nums = [2,1,2,5,3,2]
//输出：2
//
//
// 示例 3：
//
//
//输入：nums = [5,1,5,2,5,3,5,4]
//输出：5
//
//
//
//
//
//
// 提示：
//
//
// 2 <= n <= 5000
// nums.length == 2 * n
// 0 <= nums[i] <= 10⁴
// nums 由 n + 1 个 不同的 元素组成，且其中一个元素恰好重复 n 次
//
public class Solution961 {

    public static void main(String[] args) {
        Solution961 solution961 = new Solution961();
        Assertions.assertEquals(3, solution961.repeatedNTimes(new int[]{1,2,3,3}));
        Assertions.assertEquals(2, solution961.repeatedNTimes(new int[]{2,1,2,5,3,2}));
        Assertions.assertEquals(5, solution961.repeatedNTimes(new int[]{5,1,5,2,5,3,5,4}));
    }

    public int repeatedNTimes(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.getOrDefault(num, 0) + 1 == nums.length / 2) return num;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return -1;
    }
}
