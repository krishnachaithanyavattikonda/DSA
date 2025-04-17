package MostAsked.LinkedList;

import java.util.Stack;

public class PalindromeLinkedList {
    class Solution {
        //T: O(N) S:O(N)
        public boolean isPalindrome(ListNode head) {
            Stack<Integer> stack = new Stack();
            ListNode curr = head;
            while(curr != null) {
                stack.push(curr.val);
                curr = curr.next;
            }
            curr = head;
            while(curr != null && curr.val == stack.pop()) {
                curr = curr.next;
            }
            return curr == null;
        }

            //T:O(N) S:O(1)
            public boolean isPalindrome1(ListNode head) {
                ListNode slow = head, fast = head, prev, temp;
                while (fast != null && fast.next != null) {
                    slow = slow.next;
                    fast = fast.next.next;
                }
                prev = slow;
                slow = slow.next;
                prev.next = null;
                while (slow != null) {
                    temp = slow.next;
                    slow.next = prev;
                    prev = slow;
                    slow = temp;
                }
                fast = head;
                slow = prev;
                while (slow != null) {
                    if (fast.val != slow.val) return false;
                    fast = fast.next;
                    slow = slow.next;
                }
                return true;
            }
        }
    }
