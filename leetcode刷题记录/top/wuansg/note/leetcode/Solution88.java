package top.wuansg.note.leetcode;

import top.wuansg.note.util.Assertions;

/**
 * @author wunansheng
 * @since 2021/6/28
 */
public class Solution88 {

    public static void main(String[] args) {
        Solution88 solution88 = new Solution88();
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[1];
        solution88.merge(nums2, 0, nums1, 1);
        for (int i : nums1) {
            System.out.println(i);
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int sum = m + n;
        while (m > 0 && n > 0) {
            if (nums1[m-1] > nums2[n-1]) {
                nums1[m+n-1] = nums1[m-1];
                m--;
            } else {
                nums1[sum-1] = nums2[n-1];
                n--;
            }
            sum--;
        }
        while (n > 0) {
            nums1[--sum] = nums2[--n];
        }
    }
}
