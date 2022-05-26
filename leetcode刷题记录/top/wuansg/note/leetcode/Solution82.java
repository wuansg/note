package top.wuansg.note.leetcode;

//给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
//
//
// 示例 2：
//
//
//输入：head = [1,1,1,2,3]
//输出：[2,3]
//
//
//
//
// 提示：
//
//
// 链表中节点数目在范围 [0, 300] 内
// -100 <= Node.val <= 100
// 题目数据保证链表已经按升序 排列
//

import top.wuansg.note.leetcode.structure.ListNode;

public class Solution82 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode();
        ListNode l1 = newHead, l2 = head;
        while (l2 != null) {
            if (l2.next == null || l2.val != l2.next.val) {
                l1.next = l2;
                l1 = l1.next;
                l2 = l2.next;
                continue;
            }
            int val = l2.val;
            while (l2 != null && l2.val == val) {
                l2 = l2.next;
            }
        }
        l1.next = null;

        return newHead.next;
    }
}
