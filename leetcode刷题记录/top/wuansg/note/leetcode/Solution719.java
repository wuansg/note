package top.wuansg.note.leetcode;

import top.wuansg.note.util.Assertions;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

//数对 (a,b) 由整数 a 和 b 组成，其数对距离定义为 a 和 b 的绝对差值。
//
// 给你一个整数数组 nums 和一个整数 k ，数对由 nums[i] 和 nums[j] 组成且满足 0 <= i < j < nums.length 。
//返回 所有数对距离中 第 k 小的数对距离。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,3,1], k = 1
//输出：0
//解释：数对和对应的距离如下：
//(1,3) -> 2
//(1,1) -> 0
//(3,1) -> 2
//距离第 1 小的数对是 (1,1) ，距离为 0 。
//
//
// 示例 2：
//
//
//输入：nums = [1,1,1], k = 2
//输出：0
//
//
// 示例 3：
//
//
//输入：nums = [1,6,1], k = 3
//输出：5
//
// 提示：
//
//
// n == nums.length
// 2 <= n <= 10⁴
// 0 <= nums[i] <= 10⁶
// 1 <= k <= n * (n - 1) / 2
//
public class Solution719 {

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().plusSeconds(100).until(LocalDateTime.now(), ChronoUnit.SECONDS));
        Solution719 solution719 = new Solution719();
        Assertions.assertEquals(58, solution719.smallestDistancePair(new int[]{62,100,4}, 2));
    }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int[] res = new int[nums.length];
        res[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            res[i] = i * (i+1) / 2;
        }
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (res[mid] == k) {
                return nums[mid] - nums[mid-1];
            }
            if (res[mid] > k) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return nums[left] - nums[k - res[left-1]];
    }
}
