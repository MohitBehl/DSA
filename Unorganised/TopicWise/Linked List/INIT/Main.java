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
    
    
    // Floyd Cycle : Remove loop in Linked List , GFG
        /*
        class Node
        {
            int data;
            Node next;
        }
        */
    public static void removeLoop(Node head){
        // find node just before head of cycle & then break the loop 
        ListNode slow = head;
        ListNode fast = head;

        boolean hasCycle = false;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                hasCycle = true;
                break;
            }
        }
        if(! hasCycle) return; // no cycle

        ListNode curr = head;
        while(curr != slow){
            prev = slow;
            slow = slow.next;
            curr = curr.next;
        }
        // curr will be at start of loop & prev just before it
        prev.next != null; 
    }


    // Floyd Cycle : Find length of Loop , GFG
    /*
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    */
    public Node getStartOfCycle(Node head) {
        Node slow = head;
        Node fast = head;

        Node hasCycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                hasCycle = true;
                break;
            }
        }
        if(! hasCycle) return null; // no cycle

        Node tmp = head;
        while(tmp != slow){
            slow = slow.next;
            tmp = tmp.next;
        }

        return slow; // head of cycle
    }
    static int countNodesinLoop(Node head){
        Node startNode = getStartOfCycle(head);
        if(startNode == null) return 0;
        int count = 0;
        Node tmp = startNode;
        while(true){
            tmp = tmp.next;
            count++;
            if(tmp == startNode) return count;
        }
    }
}