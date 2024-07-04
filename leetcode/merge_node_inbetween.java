public class merge_node_inbetween {
    public ListNode mergeNodes(ListNode head) {
        // Skip the initial zero node
        head = head.next;

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        int sum = 0;

        while (head != null) {
            if (head.val != 0) {
                sum += head.val;
            } else {
                temp.next = new ListNode(sum);
                temp = temp.next;
                sum = 0;
            }
            head = head.next;
        }

        return dummy.next;
    }
}
