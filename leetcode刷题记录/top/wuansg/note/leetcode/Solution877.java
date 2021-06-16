package top.wuansg.note.leetcode;


public class Solution877 {

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] f = new int[n + 2][n + 2];
        for (int len = 1; len <= n; len++) {
            for (int l = 1; l + len - 1 <= n; l++) {
                int r = l + len - 1;
                int a = piles[l-1] - f[l+1][r];
                int b = piles[r-1] - f[l][r-1];
                f[l][r] = Math.max(a, b);
            }
        }
        return f[1][n] > 0;
    }
}
