package fkk;

import fkk.entity.ListNode;

/**
 * Author: karl
 * Date: 2020/12/22 下午10:50
 * <p>
 * Desc: 两两交换链表中的节点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 */
public class LC24 {

    /**
     * 迭代法
     * 1. 补充一个前置节点，用来存放head
     * 2. 设置一个指针节点，用来存每一段待处理ListNode的前置节点
     * 3. 指针节点初始等于前置节点，后续两个节点为待交换，交换结束指针节点移动两步
     * 4. 终止条件，指针节点指向的后续节点不存在或者只存在一个
     */
    public static ListNode swapPairs2(ListNode head) {
        ListNode preNode = new ListNode(-1, head);
        ListNode step = preNode;

        while (step.next != null && step.next.next != null) {
            ListNode h1 = step.next;
            ListNode h2 = step.next.next;
            step.next = h2;
            h1.next = h2.next;
            h2.next = h1;
            step = h1;
        }

        return preNode.next;

    }

    /**
     * 递归法
     * 1. 递归处理两个要素：终止条件和递归范围选取
     * 2. 终止条件，可以考虑极端情况，head只有一个或者无元素，这时候直接返回
     * 3. 两个节点为一组进行交换，第一个节点要指向后续整段ListNode，所以需要对后续整段ListNode进行处理
     * 4. 后续整段ListNode重复条件3，直到满足条件2，向上回归，每一组原一个节点所指向的后续节点已满足为更新后的
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = head.next;
        head.next = swapPairs(node.next);
        node.next = head;
        return node;
    }


    public static void main(String[] args) {

    }
}
