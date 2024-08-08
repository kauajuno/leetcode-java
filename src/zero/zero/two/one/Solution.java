package zero.zero.two.one;

public class Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return null;
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode walkingPointer = new ListNode();
        ListNode head = walkingPointer;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                walkingPointer.next = new ListNode(list1.val);
                walkingPointer = walkingPointer.next;
                list1 = list1.next;
            }else{
                walkingPointer.next = new ListNode(list2.val);
                walkingPointer = walkingPointer.next;
                list2 = list2.next;
            }
        }

        while(list1 != null){
            walkingPointer.next = new ListNode(list1.val);
            walkingPointer = walkingPointer.next;
            list1 = list1.next;
        }

        while(list2 != null){
            walkingPointer.next = new ListNode(list2.val);
            walkingPointer = walkingPointer.next;
            list2 = list2.next;
        }

        return head.next;
    }

}
