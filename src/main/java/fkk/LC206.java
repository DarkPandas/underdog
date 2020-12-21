package fkk;

import fkk.entity.ListNode;

/**
 * 反转链表 https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class LC206 {

    /**
     * 迭代
     */
    public ListNode reverseList(ListNode head) {
        ListNode node = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = node;
            node = head;
            head = temp;
        }
        return node;
    }

    /**
     * 递归
     */
    public ListNode reverseList2(ListNode head) {
        return reverse(head, null);
    }

    private ListNode reverse(ListNode head, ListNode node) {
        if (head == null) {
            return node;
        }
        ListNode next = head.next;
        head.next = node;
        node = head;
        head = next;
        return reverse(head, node);
    }
}
