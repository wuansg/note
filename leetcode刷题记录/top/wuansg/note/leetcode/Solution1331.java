package top.wuansg.note.leetcode;

import java.util.*;

//给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。
//
// 序号代表了一个元素有多大。序号编号的规则如下：
//
//
// 序号从 1 开始编号。
// 一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
// 每个数字的序号都应该尽可能地小。
//
//
//
//
// 示例 1：
//
// 输入：arr = [40,10,20,30]
//输出：[4,1,2,3]
//解释：40 是最大的元素。 10 是最小的元素。 20 是第二小的数字。 30 是第三小的数字。
//
// 示例 2：
//
// 输入：arr = [100,100,100]
//输出：[1,1,1]
//解释：所有元素有相同的序号。
//
//
// 示例 3：
//
// 输入：arr = [37,12,28,9,100,56,80,5,12]
//输出：[5,3,4,2,8,6,7,1,3]
//
//
//
//
// 提示：
//
//
// 0 <= arr.length <= 10⁵
// -10⁹ <= arr[i] <= 10⁹
//
public class Solution1331 {

    public static void main(String[] args) {
        Solution1331 solution1331 = new Solution1331();
        System.out.println(Arrays.toString(solution1331.arrayRankTransform(new int[]{40,10,20,30})));
        System.out.println(Arrays.toString(solution1331.arrayRankTransform(new int[]{100,100,100})));
        System.out.println(Arrays.toString(solution1331.arrayRankTransform(new int[]{37,12,28,9,100,56,80,5,12})));
    }

    public int[] arrayRankTransform(int[] arr) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            if (!set.contains(i)) {
                set.add(i);
                list.add(i);
            }
        }
        list.sort(Comparator.comparingInt(o -> o));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = midSearch(list, arr[i]);
        }
        return arr;
    }

    private int midSearch(List<Integer> list, int target) {
        int l = 0, r = list.size() - 1;
        int mid;
        while (l <= r) {
            mid = l + (r - l)/2;
            if (list.get(mid) == target) return mid + 1;
            else if (list.get(mid) > target) r = mid-1;
            else l = mid+1;
        }
        return 0;
    }
}
