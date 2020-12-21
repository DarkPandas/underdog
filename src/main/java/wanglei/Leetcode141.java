package wanglei;

import wanglei.struc.ListNode;

/**
 * @author wanglei
 * @version 1.0
 * @date 2020-12-20 7:32 下午
 */
public class Leetcode141 {

    /**
     *
     * 给定一个链表，判断链表中是否有环。
     *
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环
     * 如果链表中存在环，则返回 true 。 否则，返回 false 。
     *
     */

    /**
     * 判断是否有环 通常解题步骤：快慢指针
     * 慢指针一次移动一位 快指针一次移动两位，如果快指针不为空并且当快指针等于慢指针时，代表链表存在环
     * 当快指针先于慢指针进入环中，此时快指针一直在环中循环，慢指针进入环中以后总会出现一个时刻使得快指针与慢指针相同
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode slowNode = head;
        ListNode fastNode = head.next;
        while (slowNode != fastNode) {
            if (fastNode == null || fastNode.next == null) {
                return false;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return true;
    }
}
