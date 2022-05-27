public class Main{
    // Floyd Cycle : Check If Circular Linked List , GFG
    boolean isCircular(Node head)
    {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }


    // Floyd Cycle : 141. Linked List Cycle , LeetCode
        /**
        * Definition for singly-linked list.
        * class ListNode {
        *     int val;
        *     ListNode next;
        *     ListNode(int x) {
        *         val = x;
        *         next = null;
        *     }
        * }
        */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }


    // Floyd Cycle : 142. Linked List Cycle II , LeetCode
        /**
        * Definition for singly-linked list.
        * class ListNode {
        *     int val;
        *     ListNode next;
        *     ListNode(int x) {
        *         val = x;
        *         next = null;
        *     }
        * }
        */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        boolean hasCycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                hasCycle = true;
                break;
            }
        }
        if(! hasCycle) return null; // no cycle

        ListNode tmp = head;
        while(tmp != slow){
            slow = slow.next;
            tmp = tmp.next;
        }

        return slow; // head of cycle
    }
    
}