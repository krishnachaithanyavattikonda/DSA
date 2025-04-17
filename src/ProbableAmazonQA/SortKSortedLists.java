package ProbableAmazonQA;

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    // Utility method for easy printing
    @Override
    public String toString() {
        return val + (next != null ? " -> " + next.toString() : "");
    }
}

public class SortKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode node : lists) {
            if (node != null) {
                heap.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            curr.next = node;
            curr = curr.next;

            if (node.next != null) {
                heap.offer(node.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Creating test case: [[1->4->5], [1->3->4], [2->6]]
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = new ListNode[]{l1, l2, l3};

        SortKSortedLists sol = new SortKSortedLists();
        ListNode result = sol.mergeKLists(lists);

        // Print merged list
        System.out.println("Merged List: " + result);
    }
}
