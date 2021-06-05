package top.wuansg.note.leetcode;

import top.wuansg.note.leetcode.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wunansheng
 * @since 2021/5/17
 */
public class Solution993 {

    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode NL = new TreeNode(-1);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(NL);
        while (queue.size() > 1) {
            boolean findX = false, findY = false;
            TreeNode cur = queue.poll();
            while (cur != null && cur.val != -1) {
                if (findX == findY && findX) {
                    return true;
                }
                findX = cur.val == x || findX;
                findY = cur.val == y || findY;
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                cur = queue.poll();
            }
            queue.add(NL);
        }
        return false;
    }
}
