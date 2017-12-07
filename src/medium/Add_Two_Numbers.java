package medium;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode resultNode = new ListNode(0);
        ListNode loopNode = resultNode;
        int carry = 0;

        while (p != null || q != null) {
            int x = p == null ? 0 : p.val;//如果位数不同，则置0
            int y = q == null ? 0 : q.val;
            int sum = x + y + carry;
            carry = sum / 10;
            loopNode.next = new ListNode(sum % 10);
            loopNode = loopNode.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (carry != 0) {
            loopNode.next = new ListNode(carry);
        }

        return resultNode.next;

    }

    public class ListNode {
        int val;//链表结点
        ListNode next;//下一个结点指针

        ListNode(int x) {
            val = x;
        }
    }
}
