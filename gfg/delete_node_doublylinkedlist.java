class Node {
    int data;
    Node prev, next;

    Node(int d) { data = d; }
}

public class delete_node_doublylinkedlist {
     public Node deleteNode(Node head, int x) {
        if (head == null) // If the list is empty
            return null;
        
        // Special case: If head needs to be removed
        if (x == 1) {
            head = head.next;
            if (head != null)
                head.prev = null;
            return head;
        }
        
        Node current = head;
        int count = 1;
        
        // Traverse to the node at position x
        while (current != null && count < x) {
            current = current.next;
            count++;
        }
        
        // If x is out of bounds
        if (current == null)
            return head;
        
        // Remove current node
        if (current.prev != null)
            current.prev.next = current.next;
        if (current.next != null)
            current.next.prev = current.prev;
        
        return head;
    }
}
