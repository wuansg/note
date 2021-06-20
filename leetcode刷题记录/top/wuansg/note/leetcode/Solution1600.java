package top.wuansg.note.leetcode;

import java.util.*;

public class Solution1600 {

    public static void main(String[] args) {
        ThroneInheritance throneInheritance = new ThroneInheritance("king");
        throneInheritance.birth("king", "andy");
        throneInheritance.birth("king", "bob");
        throneInheritance.birth("king", "catherine");
        throneInheritance.birth("andy", "matthew");
        throneInheritance.birth("bob", "alex");
        throneInheritance.birth("bob", "asha");
        throneInheritance.getInheritanceOrder();
        throneInheritance.death("bob");
        throneInheritance.getInheritanceOrder();
    }
}

class ThroneInheritance {

    private Tree tree;
    private Map<String, Tree> map;

    public ThroneInheritance(String kingName) {
        Tree king = new Tree();
        king.name = kingName;
        tree = king;
        map = new HashMap<>();
        map.put(kingName, king);
    }

    public void birth(String parentName, String childName) {
        Tree parent = map.get(parentName);
        Tree child = new Tree();
        child.name = childName;
        if (parent.children == null) {
            parent.children = new ArrayList<>();
        }
        parent.children.add(child);
        map.put(childName, child);
    }

    public void death(String name) {
        Tree tree = map.get(name);
        tree.isDead = true;
    }

    public List<String> getInheritanceOrder() {
        return getChildren(tree);
    }

    private List<String> getChildren(Tree parent) {
        List<String> children = new ArrayList<>();
        if (!parent.isDead) {
            children.add(parent.name);
        }
        if (parent.children != null) {
            parent.children.stream()
                    .forEach(tree1 -> {
                        children.addAll(getChildren(tree1));
                    });
        }
        return children;
    }
}

class Tree {
    boolean isDead;
    String name;
    List<Tree> children;
}