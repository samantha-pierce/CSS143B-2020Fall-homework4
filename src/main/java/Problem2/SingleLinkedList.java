package Problem2;

public class SingleLinkedList {
    private ListNode head;
    private int size;

    public ListNode getHead() {
        return head;
    }

    public SingleLinkedList() {
        head = new ListNode();  // dummy node
    }

    public SingleLinkedList(int[] data) {
        this();
        if (data == null || data.length == 0) {
            return;
        }
        ListNode ptr = head;
        for (int datum : data) {
            ptr.next = new ListNode(datum);
            ptr = ptr.next;
            size++;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode ptr = head.next;
        while (ptr != null) {
            builder.append(ptr.val).append(ptr.next == null ? " -> end " : " -> ");
            ptr = ptr.next;
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof SingleLinkedList)) {
            return false;
        }

        SingleLinkedList otherList = (SingleLinkedList) obj;

        if (this.size != otherList.size) {
            return false;
        }
        ListNode n1 = head.next;
        ListNode n2 = otherList.head.next;
        while (n1 != null && n2 != null) {
            if (n1.val != n2.val) {
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return (n1 == null && n2 == null);
    }

    public int getSize() {
        return size;
    }

    // reverse the linked list RECURSIVELY
    public void reverse() {
        // homework
        if (head.next != null) {
            ListNode newHead = reverse(head.next);
            head.next = newHead;
        }
    }

    // helper method
    private static ListNode reverse(ListNode node) {
        // base case
        if (node.next == null) {
            return node;
        }
        ListNode head = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return head;
    }
}

// credit to https://www.youtube.com/watch?v=S92RuTtt9EE for help explaining how to
// recursively reverse linked list
