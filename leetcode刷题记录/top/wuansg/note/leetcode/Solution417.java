package top.wuansg.note.leetcode;
//有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
//
// 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上
//单元格 高于海平面的高度 。
//
// 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。
//
// 返回 网格坐标 result 的 2D列表 ，其中 result[i] = [ri, ci] 表示雨水可以从单元格 (ri, ci) 流向 太平洋和大西洋
// 。
//
//
//
// 示例 1：
//
//
//
//
//输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
//输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
//
//
// 示例 2：
//
//
//输入: heights = [[2,1],[1,2]]
//输出: [[0,0],[0,1],[1,0],[1,1]]
//
//
//
//
// 提示：
//
//
// m == heights.length
// n == heights[r].length
// 1 <= m, n <= 200
// 0 <= heights[r][c] <= 10⁵
//
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 384 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution417 {
    private static boolean canRiverToLT = false;
    private static boolean canRiverToRB = false;
    private static boolean[][] path;

    public static void main(String[] args) {
        int[][] heights = new int[][] {
                { 8,13,11,18,14,16,16, 4, 4, 8,10,11, 1,19, 7},
                { 2, 9,15,16,14, 5, 8,15, 9, 5,14, 6,10,15, 5},
                {15,16,17,10, 3, 6, 3, 4, 2,17, 0,12, 4, 1, 3},
                {13, 6,13,15,15,16, 4,10, 7, 4,19,19, 4, 9,13},
                { 7, 1, 9,14, 9,11, 5, 4,15,19, 6, 0, 0,13, 5},
                { 9, 9,15,12,15, 5, 1, 1,18, 1, 2,16,15,18, 9},
                {13, 0, 4,18,12, 0,11, 0, 1,15, 1,15, 4, 2, 0},
                {11,13,12,16, 9,18, 6, 8,18, 1, 5,12,17,13, 5},
                { 7,17, 2, 5, 0,17, 9,18, 4,13, 6,13, 7, 2, 1},
                { 2, 3, 9, 0,19, 6, 6,15,14, 4, 8, 1,19, 5, 9},
                { 3,10, 5,11, 7,14, 1, 5, 3,19,12, 5, 2,13,16},
                { 0, 8,10,18,17, 5, 5, 8, 2,11, 5,16, 4, 9,14},
                {15, 9,16,18, 9, 5, 2, 5,13, 3,10,19, 9,14, 3},
                {12,11,16, 1,10,12, 6,18, 6, 6,18,10, 9, 5, 2},
                {17, 9, 6, 6,14, 9, 2, 2,13,13,15,17,15, 3,14},
                {18,14,12, 6,18,16, 4,10,19, 5, 6, 8, 9, 1, 6}
        };
        List<List<Integer>> lists = new Solution417().pacificAtlantic(heights);
        System.out.println(lists);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        for (int x = 0; x < heights.length; x++) {
            for (int y = 0; y < heights[x].length; y++) {
                if (canRiver(heights, x, y)) {
                    result.add(Arrays.asList(x, y));
                }
            }
        }
        return result;
    }

    private boolean canRiver(int[][] map, int x, int y) {
        init(map);
        riverToLTByLT(map, x, y, map[x][y]);
        if (!canRiverToLT) return false;
        riverToRBByRB(map, x, y, map[x][y]);
        return canRiverToRB && canRiverToLT;
    }

    private void init(int[][] map) {
        canRiverToLT = false;
        canRiverToRB = false;
        path = new boolean[map.length][map[0].length];
    }

    private void riverToLTByLT(int[][] map, int x, int y, int level) {
        if (x == -1 || y == -1 || canRiverToLT) {
            canRiverToLT = true;
            return;
        }
        if (x == map.length || y == map[0].length || path[x][y]) return;
        if (map[x][y] > level) return;
        path[x][y] = true;
        riverToLTByLT(map, x-1, y, map[x][y]);
        riverToLTByLT(map, x, y-1, map[x][y]);
        riverToLTByLT(map, x+1, y, map[x][y]);
        riverToLTByLT(map, x, y+1, map[x][y]);
        path[x][y] = false;
    }

    private void riverToRBByRB(int[][] map, int x, int y, int level) {
        if (x >= map.length || y >= map[0].length || canRiverToRB) {
            canRiverToRB = true;
            return;
        }
        if (x == -1 || y == -1 || path[x][y]) return;
        if (map[x][y] > level) return;
        path[x][y] = true;
        riverToRBByRB(map, x-1, y, map[x][y]);
        riverToRBByRB(map, x, y-1, map[x][y]);
        riverToRBByRB(map, x+1, y, map[x][y]);
        riverToRBByRB(map, x, y+1, map[x][y]);
        path[x][y] = false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

