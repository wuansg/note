package top.wuansg.note.leetcode;

import top.wuansg.note.leetcode.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
//
// 假设二叉树中至少有一个节点。
//
//
//
// 示例 1:
//
//
//
//
//输入: root = [2,1,3]
//输出: 1
//
//
// 示例 2:
//
//
//
//
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
//
//
//
//
// 提示:
//
//
// 二叉树的节点个数的范围是 [1,10⁴]
// -2³¹ <= Node.val <= 2³¹ - 1
//
public class Solution513 {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode newLine = new TreeNode();
        queue.add(root);
        queue.add(newLine);
        boolean isNewLine = true;
        int res = root.val;
        while (queue.size() > 1) {
            TreeNode node = queue.poll();
            if (isNewLine) { res = node.val; isNewLine = false;}
            if (node == newLine) {isNewLine = true; queue.add(newLine);}
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return res;
    }
}
