package top.wuansg.note.leetcode;

import top.wuansg.note.leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
//
//
//
// 示例1：
//
//
//
//
//输入: root = [1,3,2,5,3,null,9]
//输出: [1,3,9]
//
//
// 示例2：
//
//
//输入: root = [1,2,3]
//输出: [1,3]
//
//
//
//
// 提示：
//
//
// 二叉树的节点个数的范围是 [0,10⁴]
// -2³¹ <= Node.val <= 2³¹ - 1
//
//
//
public class Solution515 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        int max = Integer.MIN_VALUE;
        boolean hasRemind = false;
        TreeNode newLine = new TreeNode();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(newLine);
        while (queue.size() > 1) {
            TreeNode node = queue.poll();
            if (node == newLine) {
                res.add(max);
                max = Integer.MIN_VALUE;
                queue.add(newLine);
                hasRemind = false;
                continue;
            }
            hasRemind = true;
            max = Math.max(max, node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        if (hasRemind) res.add(max);
        return res;
    }
}
