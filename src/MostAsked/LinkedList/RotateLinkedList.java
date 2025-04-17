package MostAsked.LinkedList;

public class RotateLinkedList {
//    Input: head = [1,2,3,4,5], k = 2
//    Output: [4,5,1,2,3]

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int length = 1;
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }
        temp.next = head;
        k = k % length;
        k = length - k;
        while (k-- > 0) {
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }
}
