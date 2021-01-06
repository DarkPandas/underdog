package fkk;

import fkk.entity.ListNode;

import java.util.HashSet;

/**
 * Author: karl
 * Date: 2021/1/5 下午9:56
 * <p>
 * Desc:
 * 【环形链表】https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class LC141 {

    /**
     * 利用hashSet的唯一性
     */
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();

        while (head != null) {
            if (!hashSet.add(head)) {
                return true;
            }
            head = head.next;
        }

        return false;
    }

    /**
     * 快慢指针
     * 慢指针一次移动一步
     * 快指针一次移动两步，
     * 如果有循环，快慢指针有相遇的一天。
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
