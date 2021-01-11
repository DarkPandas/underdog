package fkk;

import fkk.entity.ListNode;

import java.util.HashSet;

/**
 * Author: karl
 * Date: 2021/1/5 下午10:52
 * <p>
 * Desc:
 * 环形链表II https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class LC142 {

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();
        while (head != null) {
            if (!hashSet.add(head)) {
                return head;
            }
            head = head.next;
        }

        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }

            if (slow == fast) {
                ListNode step = head;
                while (slow != step) {
                    slow = slow.next;
                    step = step.next;
                }
                return step;
            }
        }

        return null;
    }
}
