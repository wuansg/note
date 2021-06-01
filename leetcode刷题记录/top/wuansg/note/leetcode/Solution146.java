package top.wuansg.note.leetcode;

/**
 * @author wunansheng
 * @since 2021/4/28
 */
public class Solution146 {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        System.out.println(lruCache.get(2));
        lruCache.put(2,6);
        lruCache.get(1);
        lruCache.put(1,5);
        lruCache.put(1,2);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }
}

class LRUCache {
    private Node[] map;
    private Node root;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        this.map = new Node[capacity];
        this.root = new Node();
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        int index = key % capacity;
        int count = capacity;
        while (map[index] != null && map[index].key != key && count-- > 0) {
            index = ++index % capacity;
        }
        if (map[index] != null && map[index].key == key) {
            active(map[index].key);
            return map[index].value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (size == capacity) {
            int count = size;
            Node current = root;
            while (count-- > 1 && current != null) {
                if (current.key == key) {
                    break;
                }
                current = current.next;
            }
            if (current != null && current.next != null && current.key != key) {
                remove(current.next.key);
                current.next = null;
                --size;
            }
        }
        System.out.println("key: " + key + ", value: " + value);
        Node newNode = new Node(key, value);
        int index = key % capacity;
        while (map[index] != null && map[index].key != key) {
            index = ++index % capacity;
        }
        boolean updated = map[index] != null;
        map[index] = newNode;

        if (updated) {
            active(key);
        } else {
            newNode.next = root.next;
            root.next = newNode;
            ++size;
        }
    }

    private void active(int key) {
        Node prev = null;
        Node cur = root;
        while (cur != null && cur.key != key) {
            prev = cur;
            cur = cur.next;
        }
        if (cur != null && prev != null) {
            prev.next = cur.next;
            cur.next = root.next;
            root.next = cur;
        }
    }

    public void remove(int key) {
        int index = key % capacity;
        int count = 0;
        while (map[index] != null && map[index].key != key && count < capacity) {
            index = ++index % capacity;
            ++count;
        }
        if (count < capacity) {
            map[index] = null;
        }
    }

    static class Node {
        int key;
        int value;
        Node next;

        Node() {
        }

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
