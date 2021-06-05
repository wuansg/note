package top.wuansg.note.util;

import top.wuansg.note.leetcode.structure.ListNode;

public class ArrayUtils {

    public static int[] trans2IntArray(ListNode head) {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        int[] intArray = new int[count];
        current = head;
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = current.val;
            current = current.next;
        }
        return intArray;
    }
}
