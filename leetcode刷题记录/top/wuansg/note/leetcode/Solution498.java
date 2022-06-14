package top.wuansg.note.leetcode;


import java.util.Arrays;

//给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
//
//
//
// 示例 1：
//
//
//输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,4,7,5,3,6,8,9]
//
//
// 示例 2：
//
//
//输入：mat = [[1,2],[3,4]]
//输出：[1,2,3,4]
//
//
//
//
// 提示：
//
//
// m == mat.length
// n == mat[i].length
// 1 <= m, n <= 10⁴
// 1 <= m * n <= 10⁴
// -10⁵ <= mat[i][j] <= 10⁵
//
public class Solution498 {

    public static void main(String[] args) {
        Solution498 solution498 = new Solution498();
        System.out.println(Arrays.toString(solution498.findDiagonalOrder(new int[][]{{2,5}, {8,4}, {0,-1}})));
    }

    public int[] findDiagonalOrder(int[][] mat) {
        int[] res = new int[mat.length * mat[0].length];
        if (mat.length == 1) {
            return mat[0];
        }
        int index = 0;
        if (mat[0].length == 1) {
            while (index < mat.length) {
                res[index] = mat[index][0];
                index++;
            }
            return res;
        }
        boolean up = true;
        int row = 0;
        int col = 0;
        res[index++] = mat[0][0];
        while (index < mat.length * mat[0].length) {
            if (row >= mat.length - 1) {
                row = mat.length-1;
                col++;
            } else if (col >= mat[0].length - 1) {
                col = mat[0].length-1;
                row++;
            } else {
                row += (up ? 0 : 1);
                col += (up ? 1 : 0);
            }
            up = !up;
            if (up) {
                while (row != 0 && col <= mat[0].length-1 && index < mat.length * mat[0].length) {
                    res[index++] = mat[row][col];
                    row--;
                    col++;
                }
            } else {
                while (col != 0 && row <= mat.length-1 && index < mat.length * mat[0].length) {
                    res[index++] = mat[row][col];
                    row++;
                    col--;
                }
            }
            if (row > mat.length-1) {
                col++;
                continue;
            }
            if (col > mat[0].length-1) {
                row++;
                continue;
            }
            if (index >= mat.length * mat[0].length) {
                break;
            }
            res[index++] = mat[row][col];
        }
        return res;
    }
}
