package top.wuansg.note.leetcode;

public class SolutionOffer098 {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[j+1] = dp[j] + dp[j+1];
            }
        }
        return dp[n];
    }
}
