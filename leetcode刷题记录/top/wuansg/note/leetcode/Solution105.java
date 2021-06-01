package top.wuansg.note.leetcode;

/**
 * @author wunansheng
 * @since 2021/4/27
 */
public class Solution105 {
    public static void main(String[] args) {
        new Solution105().buildTree(new int[]{1,2,3}, new int[]{3,2,1});
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        buildTree(preorder, inorder, root, 0, preorder.length, 0);
        return root;
    }

    private void buildTree(int[] preorder, int[] inorder, TreeNode node, int start, int end, int index) {
        if (start > end) {
            return;
        }
        int partingIndex = findIndex(inorder, preorder[index], start, end);
        if (partingIndex != -1 && partingIndex > start) {
            node.left = new TreeNode(preorder[index+1]);
            buildTree(preorder, inorder, node.left, start, partingIndex, index+1);
        }
        index = index + (partingIndex - start) + 1;
        if (index < preorder.length) {
            node.right = new TreeNode(preorder[index]);
            buildTree(preorder, inorder, node.right, partingIndex+1, end, index);
        }
    }

    private int findIndex(int[] nums, int target, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
    }
}
