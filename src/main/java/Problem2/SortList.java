package Problem2;

public class SortList {
    private static final int SENTRY = Integer.MAX_VALUE;
    // DO NOT ADD ANY NEW MEMBER VARIABLE AND MEMBER FUNCTION

    // DO NOT CHANGE ANYTHING IN THIS FUNCTION
    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode mid = findMidAndBreak(head);
        return mergeLists(sortList(head), sortList(mid));
    }

    public static ListNode findMidAndBreak(ListNode head) {
        // homework
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fastNode = head;
        ListNode slowNode = head;
        ListNode prevSlow = head;
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            prevSlow = slowNode;
            slowNode = slowNode.next;
        }
        prevSlow.next = null;
        return slowNode;
    }

    public static ListNode mergeLists(ListNode list1, ListNode list2) {
        // homework
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = null;
        if (list1.val < list2.val) {
            head = list1;
            head.next = mergeLists(list1.next, list2);
        } else {
            head = list2;
            head.next = mergeLists(list1, list2.next);
        }
        return head;
    }
}
