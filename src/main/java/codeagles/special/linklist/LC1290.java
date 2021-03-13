package codeagles.special.linklist;

/**
 * Created with IntelliJ IDEA.
 * User: Codeagles
 * Date: 2021/1/19
 * Time: 下午5:23
 * <p>
 * Description:
 */
public class LC1290 {
    static class Node {
        public int value;
        public Node next;

        Node(int x) {
            value = x;
        }
    }


    public int getDecimalValue(Node head) {
        int r = 0;
        for(; head != null; head = head.next){
            r = (r << 1) | head.value;
        }
        return r;
    }

    public static void main(String[] args) {
        LC1290 lc = new LC1290();
        Node node = new Node(1);
        Node node1 = new Node(0);
        Node node2 = new Node(1);
        node.next = node1;
        node1.next = node2;
        System.out.println( lc.getDecimalValue(node));
    }
}
