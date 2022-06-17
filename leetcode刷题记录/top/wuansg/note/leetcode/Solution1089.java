package top.wuansg.note.leetcode;

import java.util.Arrays;

//给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
//
// 注意：请不要在超过该数组长度的位置写入元素。
//
// 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
//
//
//
// 示例 1：
//
// 输入：[1,0,2,3,0,4,5,0]
//输出：null
//解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
//
//
// 示例 2：
//
// 输入：[1,2,3]
//输出：null
//解释：调用函数后，输入的数组将被修改为：[1,2,3]
//
//
//
//
// 提示：
//
//
// 1 <= arr.length <= 10000
// 0 <= arr[i] <= 9
//
public class Solution1089 {

    public static void main(String[] args) {
        Solution1089 solution1089 = new Solution1089();
        int[] input = new int[]{0,0,0};
        solution1089.duplicateZeros(input);
        System.out.println(Arrays.toString(input));
    }

    public void duplicateZeros(int[] arr) {
        int i = 0, j = 0;
        boolean justOne = false;
        while (j < arr.length) {
            if (arr[i] == 0) j++;
            if (j >= arr.length) {
                justOne = arr[i] == 0;
                i++;
                break;
            }
            i++;
            j++;
        }
        j--;
        i--;
        if (arr[i] == 0 && justOne) {
            arr[j] = 0;
            i--;
            j--;
        }
        while (i >= 0) {
            if (arr[i] == 0) {
                arr[j] = 0;
                arr[j-1] = 0;
                j = j - 2;
            } else {
                arr[j] = arr[i];
                j--;
            }
            i--;
        }
    }

}
