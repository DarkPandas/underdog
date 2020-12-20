package wanglei;

import wanglei.struc.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode24 {


    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
     */

    public static void main(String[] args) {
        List<ListNode> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ListNode node = new ListNode(i);
            list.add(node);
        }
        for (int i = 0; i < 4; i++) {
            ListNode current = list.get(i);
            current.next = list.get(i+1);
        }
        list.get(4).next = null;
        ListNode head = list.get(0);
        ListNode reHead = swapPairsByIter(head);
        System.out.println("data:--->" + reHead.val);
    }

    //该题类似交换链表 只是对交换的内容加上了限制-即两两交换，同样可以通过递归和循环的方式求解
    public static ListNode swapPairsByIter(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode current = dummyHead;
        while (current.next != null && current.next.next != null) {
            ListNode node1 = current.next;
            ListNode node2 = current.next.next;
            current.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            current = node1;
        }
        return dummyHead.next;
    }

    public static ListNode swapPairsByRecursive(ListNode head){
        //递归终止条件
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairsByRecursive(newHead.next);

        //递归之后的处理 -指针重新赋值
        newHead.next = head;
        return newHead;
    }

}
