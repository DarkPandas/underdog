package wanglei;

import wanglei.struc.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanglei
 * @version 1.0
 * @date 2020-12-13 9:45 下午
 */
public class Leetcode206 {

    /**
     * 反转一个单链表。
     *
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
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
        ListNode reHead = reverseNodeByRecursive(head);
        System.out.println("data:--->" + reHead.val);
    }

    // 从前往后 记录当前节点 该节点后一个节点 该节点前一个节点 替换位置即可。
    public static ListNode reverseNodeByIter(ListNode head){
        ListNode dummyNode = null;
        ListNode currentNode = head;
        while (currentNode != null){
            ListNode nextNode = currentNode.next;
            currentNode.next = dummyNode;
            dummyNode = currentNode;
            currentNode = nextNode;
        }
        return dummyNode;
    }

    //递归 除非 head 本身为null 或者 next 是 null，否则首先会一直执行递归方法，因此第一个递归返回的结果就是头节点，然后再不断的往该节点上添加值。
    public static ListNode reverseNodeByRecursive(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode reversedH = reverseNodeByRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return reversedH;
    }
}
