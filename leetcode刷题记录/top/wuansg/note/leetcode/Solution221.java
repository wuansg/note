package top.wuansg.note.leetcode;

/**
 * @author wunansheng
 * @since 2021/4/29
 */
public class Solution221 {

    public static void main(String[] args) {
        char[][] input = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(new Solution221().maximalSquare(input));
    }

    public int maximalSquare(char[][] matrix) {
        int[][] dia = new int[matrix.length + 1][matrix[0].length + 1];
        int[][] row = new int[matrix.length + 1][matrix[0].length + 1];
        int[][] col = new int[matrix.length + 1][matrix[0].length + 1];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                char c = matrix[i][j];
                if (c == '0') {
                    dia[i+1][j+1] = 0;
                    row[i+1][j+1] = 0;
                    col[i+1][j+1] = 0;
                } else {
                    dia[i+1][j+1] = Math.min(dia[i][j], Math.min(row[i][j+1], col[i+1][j])) + 1;
                    row[i+1][j+1] = row[i][j+1] + 1;
                    col[i+1][j+1] = col[i+1][j] + 1;
                    max = Math.max(dia[i+1][j+1], max);
                }
            }
        }

        return max * max;
    }
}
