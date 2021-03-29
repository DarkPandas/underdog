package fkk;

import fkk.entity.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: karl
 * Date: 2021/3/13 下午9:53
 * <p>
 * Desc:
 */
public class LC02 {

    /**
     * v2
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = null, stepNode = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int count = n1 + n2 + carry;
            if (head == null) {
                head = stepNode = new ListNode(count % 10);
            } else {
                stepNode.next = new ListNode(count % 10);
                stepNode = stepNode.next;
            }
            carry = count / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            stepNode.next = new ListNode(carry);
        }

        return head;
    }

    /**
     * v1
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int step = 0;
        List<Integer> list = new ArrayList<>();
        while (l1 != null || l2 != null) {
            int count;
            if (l1 == null) {
                count = l2.val + step;
                l2 = l2.next;
            } else if (l2 == null) {
                count = l1.val + step;
                l1 = l1.next;
            } else {
                count = l1.val + l2.val + step;
                l1 = l1.next;
                l2 = l2.next;
            }

            list.add(count % 10);
            step = count / 10;
        }

        if (step == 1) {
            list.add(1);
        }

        ListNode node = null;
        for (int i = list.size() - 1; i >= 0; i--) {
            ListNode temp = new ListNode(list.get(i));
            temp.next = node;
            node = temp;
        }

        return node;

    }
}

