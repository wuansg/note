package top.wuansg.note.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wunansheng
 * @since 2021/5/11
 */
public class Solution872 {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        TreeNode root2 = new TreeNode(2);
        root2.right = new TreeNode(2);
        System.out.println(new Solution872().leafSimilar(root1, root2));
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> val1 = new ArrayList<>();
        dfs(root1, val1);
        List<Integer> val2 = new ArrayList<>();
        dfs(root2, val2);
        if (val1.size() != val2.size()) {
            return false;
        }
        for (int i = 0; i < val1.size(); i++) {
            if (!val1.get(i).equals(val2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private void dfs(TreeNode node, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
            if (treeNode.left == null && treeNode.right == null) {
                list.add(treeNode.val);
            }
        }
    }
}
