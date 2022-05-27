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
    
    public static void main(String[] args) {
        
    }
}