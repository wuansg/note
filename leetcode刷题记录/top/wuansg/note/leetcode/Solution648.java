package top.wuansg.note.leetcode;

import java.util.List;

/**
 * @author wunansheng
 * @since 2021/9/17
 */
public class Solution648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        PrefixTree prefixTree = PrefixTree.of(dictionary);
        String[] words = sentence.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            stringBuilder
                    .append(' ')
                    .append(prefixTree.getPrefix(word));
        }
        stringBuilder.deleteCharAt(0);
        return stringBuilder.toString();
    }

    static class PrefixTree {
        Node root = new Node();

        public String getPrefix(String word) {
            Node current = root;
            for (char c : word.toCharArray()) {
                if (current.chilren[c - 'a'] == null) break;
                if (current.chilren[c - 'a'].leaf != null) return current.chilren[c - 'a'].leaf;
                current = current.chilren[c - 'a'];
            }
            return word;
        }

        public static PrefixTree of(List<String> stringList) {
            PrefixTree prefixTree = new PrefixTree();
            for (String s : stringList) {
                Node current = prefixTree.root;
                for (char c : s.toCharArray()) {
                    int index = c - 'a';
                    if (current.chilren[index] == null) current.chilren[index] = new Node();
                    current = current.chilren[index];
                }
                current.leaf = s;
            }
            return prefixTree;
        }
    }

    static class Node {
        String leaf;
        Node[] chilren;

        public Node() {this.chilren = new Node[26];}
        public Node(String value) {this(); this.leaf = value;}
    }
}
