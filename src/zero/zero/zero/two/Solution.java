package zero.zero.zero.two;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, sum;
        ListNode walkingPointer = new ListNode();
        ListNode head = walkingPointer;

        while(l1 != null && l2 != null){
            sum = l1.val + l2.val + carry;
            carry = (sum > 9) ? 1 : 0;
            walkingPointer.next = new ListNode(sum % 10);
            walkingPointer = walkingPointer.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            sum = l1.val + carry;
            carry = (sum > 9) ? 1 : 0;
            walkingPointer.next = new ListNode(sum % 10);
            walkingPointer = walkingPointer.next;
            l1 = l1.next;
        }

        while(l2 != null){
            sum = l2.val + carry;
            carry = (sum > 9) ? 1 : 0;
            walkingPointer.next = new ListNode(sum % 10);
            walkingPointer = walkingPointer.next;
            l2 = l2.next;
        }

        if(carry == 1){
            walkingPointer.next = new ListNode(1);
        }

        return head.next;
    }
}