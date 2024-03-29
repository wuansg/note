package top.wuansg.note.leetcode;

import top.wuansg.note.util.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。
//
// 区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。
//
// 返回一个由每个区间 i 的 右侧区间 的最小起始位置组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1 。
//
//
// 示例 1：
//
//
//输入：intervals = [[1,2]]
//输出：[-1]
//解释：集合中只有一个区间，所以输出-1。
//
//
// 示例 2：
//
//
//输入：intervals = [[3,4],[2,3],[1,2]]
//输出：[-1,0,1]
//解释：对于 [3,4] ，没有满足条件的“右侧”区间。
//对于 [2,3] ，区间[3,4]具有最小的“右”起点;
//对于 [1,2] ，区间[2,3]具有最小的“右”起点。
//
//
// 示例 3：
//
//
//输入：intervals = [[1,4],[2,3],[3,4]]
//输出：[-1,2,-1]
//解释：对于区间 [1,4] 和 [3,4] ，没有满足条件的“右侧”区间。
//对于 [2,3] ，区间 [3,4] 有最小的“右”起点。
//
//
//
//
// 提示：
//
//
// 1 <= intervals.length <= 2 * 10⁴
// intervals[i].length == 2
// -10⁶ <= starti <= endi <= 10⁶
// 每个间隔的起点都 不相同
//
public class Solution436 {

    public static void main(String[] args) {
        Solution436 solution436 = new Solution436();
        Assertions.assertEquals(new int[]{-1}, solution436.findRightInterval(new int[][]{{1,2}}));
        Assertions.assertEquals(new int[]{-1,0,1}, solution436.findRightInterval(new int[][]{{3,4},{2,3},{1,2}}));
        Assertions.assertEquals(new int[]{-1,2,-1}, solution436.findRightInterval(new int[][]{{1,4},{2,3},{3,4}}));
    }

    public int[] findRightInterval(int[][] intervals) {
        List<List<Integer>> map = new ArrayList<>(intervals.length);
        for (int i = 0; i < intervals.length; i++) {
            map.add(Arrays.asList(intervals[i][0], i));
        }
        map.sort(Comparator.comparingInt(o -> o.get(0)));
        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            res[i] = find(map, intervals[i][1]);
        }
        return res;
    }

    private int find(List<List<Integer>> map, int target) {
        int start = 0, end = map.size();
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (map.get(mid).get(0) > target) {
                end = mid;
            } else if (map.get(mid).get(0) < target) {
                start = mid + 1;
            } else {
                return map.get(mid).get(1);
            }
        }
        if (start >= map.size())
            return -1;
        if (map.get(start).get(0) > target)
            return map.get(start).get(1);
        if (start < map.size() - 1)
            return map.get(start+1).get(1);
        return -1;
    }
}
