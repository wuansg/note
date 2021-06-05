package top.wuansg.note.util;

import top.wuansg.note.leetcode.structure.ListNode;

public class ListUtils {

    public static ListNode generateFromArray(int[] values) {
        Assertions.assertNotNull(values);
        ListNode head = new ListNode(-1, null);
        ListNode current = head;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }

        return head.next;
    }
}
