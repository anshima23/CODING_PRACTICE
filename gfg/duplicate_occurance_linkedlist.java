public class duplicate_occurance_linkedlist {
    
    public Node removeAllDuplicates(Node head) {
        if (head == null) return head;

        Node dummy = new Node(0);  
        dummy.next = head;
        Node prev = dummy;  
        Node temp = head;

        while (temp != null) {
            if (temp.next != null && temp.data == temp.next.data) {
                while (temp.next != null && temp.data == temp.next.data) {temp = temp.next;}
                prev.next = temp.next;
            } else {prev = prev.next;}
            temp = temp.next;
        }
        return dummy.next;
    }
}
