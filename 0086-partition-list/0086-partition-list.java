class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0, head);
        ListNode temp = dummy; // Tracks the end of the "< x" partition
        
        // Advance temp past any nodes at the start that are already < x
        while (temp.next != null && temp.next.val < x) {
            temp = temp.next;
        }

        ListNode prev = temp;
        ListNode curr = temp.next;

        while (curr != null) {
            ListNode forward = curr.next; // Safely compute forward inside the loop
            if (curr.val < x) {
                // 1. Detach curr from its current position
                prev.next = forward;
                // 2. Insert curr right after temp
                curr.next = temp.next;
                temp.next = curr;
                // 3. Advance temp
                temp = curr;
            } else {
                // Only advance prev when curr stays in place
                prev = curr;
            }
            curr = forward;
        }

        return dummy.next;
    }
}
