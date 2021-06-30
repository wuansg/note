package top.wuansg.note.leetcode;

import top.wuansg.note.leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wunansheng
 * @since 2021/6/30
 */
public class SolutionOffer37 {

    public static void main(String[] args) {
        Codec codec = new Codec();
        String input = "[1,2,3,null,null,4,5,6,7]";
        TreeNode root = codec.deserialize(input);
        System.out.println(codec.serialize(root));
    }
}

class Codec {
    TreeNode EMPTY = new TreeNode(-1);
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        List<String> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == EMPTY) {
                list.add("null");
                continue;
            }
            list.add(String.valueOf(node.val));
            queue.add(node.left == null ? EMPTY : node.left);
            queue.add(node.right == null ? EMPTY : node.right);
        }
        for (int i = list.size()-1; i >= 0; i--) {
            if (!"null".equals(list.get(i)))
                break;
            if ("null".equals(list.get(i))) {
                list.remove(i);
            }
        }
        return "[" + String.join(",", list) + "]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.substring(1, data.length() - 1);
        if (!data.isBlank()) {
            String[] nodes = data.split(",");
            TreeNode treeNode = new TreeNode();
            Queue<TreeNode> queue = new LinkedList<>();
            if (nodes.length > 0) {
                treeNode.val = Integer.parseInt(nodes[0]);
                queue.add(treeNode);
                int index = 1;
                while (!queue.isEmpty()) {
                    TreeNode node = queue.poll();
                    if (index < nodes.length && !"null".equals(nodes[index])) {
                        node.left = new TreeNode(Integer.parseInt(nodes[index]));
                        queue.add(node.left);
                    }
                    index++;
                    if (index < nodes.length && !"null".equals(nodes[index])) {
                        node.right = new TreeNode(Integer.parseInt(nodes[index]));
                        queue.add(node.right);
                    }
                    index++;
                }
            }
            return treeNode;
        }
        return null;
    }
}