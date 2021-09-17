package top.wuansg.note.leetcode;

/**
 * @author wunansheng
 * @since 2021/9/17
 */
public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row;
        int l = 0, r = matrix.length - 1;
        int mid;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (matrix[mid][0] == target) return true;
            else if (matrix[mid][0] > target) r = mid - 1;
            else l = mid + 1;
        }
        row = matrix[l][0] > target ? l - 1 : l;
        if (row < 0) return false;
        l = 0;
        r = matrix[row].length -1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (matrix[row][mid] == target) return true;
            else if (matrix[row][mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return false;
    }
}
