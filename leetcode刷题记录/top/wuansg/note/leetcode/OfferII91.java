package top.wuansg.note.leetcode;

import top.wuansg.note.util.Assertions;

import java.time.LocalDateTime;

//假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
//
// 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的正整数矩阵
//costs 来表示的。
//
// 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。
//
// 请计算出粉刷完所有房子最少的花费成本。
//
//
//
// 示例 1：
//
//
//输入: costs = [[17,2,17],[16,16,5],[14,3,19]]
//输出: 10
//解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。
//     最少花费: 2 + 5 + 3 = 10。
//
//
// 示例 2：
//
//
//输入: costs = [[7,6,2]]
//输出: 2
//
//
//
//
// 提示:
//
//
// costs.length == n
// costs[i].length == 3
// 1 <= n <= 100
// 1 <= costs[i][j] <= 20
//
public class OfferII91 {

    public static void main(String[] args) {
        OfferII91 offerII91 = new OfferII91();
        System.out.println(LocalDateTime.now());
        Assertions.assertEquals(268, offerII91.minCost(new int[][]{{10,6,7},{19,9,8},{18,20,3},{17,8,13},{15,11,16},{11,20,10},{8,6,5},{5,19,5},{14,14,20},{6,6,1},{15,3,12},{17,7,5},{7,6,8},{19,5,6},{15,10,7},{19,4,12},{13,8,16},{3,14,12},{4,12,5},{19,20,3},{19,10,15},{1,7,17},{6,15,13},{11,6,20},{7,6,7},{14,13,15},{19,17,13},{5,11,8},{2,17,12},{12,13,4},{9,19,4},{20,5,6},{20,16,7},{17,18,3},{8,10,2},{6,19,16},{20,1,10}}));
        System.out.println(LocalDateTime.now());
    }

    public int minCost(int[][] costs) {
        int[][] dp = new int[2][costs[0].length];
        int index = 0;
        for (int[] cost : costs) {
            for (int i1 = 0; i1 < cost.length; i1++) {
                dp[(index + 1) % 2][i1] = minInArrays(dp[index % 2], i1) + cost[i1];
            }
            index++;
        }
        return minInArrays(dp[index%2], -1);
    }

    private int minInArrays(int[] costs, int exclusive) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < costs.length; i++) {
            if (i == exclusive) continue;
            min = Math.min(min, costs[i]);
        }
        return min;
    }
}
