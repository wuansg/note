package top.wuansg.note.leetcode;


import top.wuansg.note.leetcode.structure.TreeNode;

//如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
//
// 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
//
//
//
// 示例 1：
//
//
//
// 输入：[1,1,1,1,1,null,1]
//输出：true
//
//
// 示例 2：
//
//
//
// 输入：[2,2,2,5,2]
//输出：false
//
//
//
//
// 提示：
//
//
// 给定树的节点数范围是 [1, 100]。
// 每个节点的值都是整数，范围为 [0, 99] 。
//
public class Solution965 {

    public static void main(String[] args) {
        Solution965 solution965 = new Solution965();
    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        if (root.left != null && root.left.val != root.val) return false;
        if (root.right != null && root.right.val != root.val) return false;
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}
