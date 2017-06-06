package lc;

/**
 * Created by zguo on 3/29/17.
 * *
 Difficulty: Medium
 Contributor: LeetCode
 You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8

 */
public class a002_Add_Two_Numbers {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode r = new ListNode(-1);
        ListNode c = r;
        while (l1 != null || l2 != null || carry != 0) {
            int total = carry;
            if (l1 != null) {
                total += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                total += l2.val;
                l2 = l2.next;
            }
            if (total >= 10) {
                total = total - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            c.next = new ListNode(total);
            c = c.next;
        }
        return r.next;
    }
}
