package MostAsked.LinkedList;

import java.util.Arrays;
import java.util.Collections;

public class ReverseSingleLinkedList {
    public static ListNode reverseList(ListNode head) {
        return reverseListInt(head, null);
    }

    public static ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }

    public static void main(String[] args) {
        ListNode ls=new ListNode(0,new ListNode());
        ls.next.val=1;

    }
}
