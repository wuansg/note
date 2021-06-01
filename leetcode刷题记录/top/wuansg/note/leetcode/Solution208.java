package top.wuansg.note.leetcode;

/**
 * @author wunansheng
 * @since 2021/4/28
 */
public class Solution208 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println(trie.startsWith("a"));
    }
}

class Trie {
    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node(' ', false, new Node[26]);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new Node(c, false, new Node[26]);
            }
            if (i == word.length() - 1) {
                current.children[c - 'a'].isLeaf = true;
            }
            current = current.children[c - 'a'];
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = root;
        for (int i = 0; i < word.length() && cur != null; i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] != null && i == word.length() - 1 && cur.children[c - 'a'].isLeaf) {
                return true;
            }
            cur = cur.children[c - 'a'];
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = root;
        int i = 0;
        while (i < prefix.length() && cur != null) {
            char c = prefix.charAt(i);
            cur = cur.children[c - 'a'];
            i++;
        }
        return i == prefix.length() && cur != null;
    }

    static class Node {
        char c;
        boolean isLeaf;
        Node[] children;

        Node(char c, boolean isLeaf, Node[] children) {
            this.c = c;
            this.isLeaf = isLeaf;
            this.children = children;
        }
    }
}
