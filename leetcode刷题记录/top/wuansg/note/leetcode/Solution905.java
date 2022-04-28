package top.wuansg.note.leetcode;

//给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。
//
// 返回满足此条件的 任一数组 作为答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [3,1,2,4]
//输出：[2,4,3,1]
//解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。
//
//
// 示例 2：
//
//
//输入：nums = [0]
//输出：[0]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 5000
// 0 <= nums[i] <= 5000
//
// Related Topics 数组 双指针 排序 👍 269 👎 0



import java.util.Arrays;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution905 {

    public static void main(String[] args) {
        int[] nums = new int[] {3};
        int[] result = new Solution905().sortArrayByParity(nums);
        System.out.println(Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }

    public int[] sortArrayByParity(int[] nums) {
        int l = 0, r = 0;
        while (r < nums.length) {
            while (l < nums.length && nums[l] % 2 == 0) {
                l++;
            };
            while (r < nums.length && (l > r || nums[r] % 2 != 0)) {
                r++;
            };
            if (l < nums.length && r < nums.length) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
                l++;
                r++;
            }
        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
