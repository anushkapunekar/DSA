import java.util.*;

public class removenthnode {

    // BRUTE FORCE: Two passes (count length, then delete at length-n)
    // TC=>O(L + (L-n)) where L is length
    // SC=>O(1)
    public static ListNode removeNthBrute(ListNode head, int n) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        if (length == n) return head.next;

        int target = length - n;
        temp = head;
        for (int i = 1; i < target; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }

    // OPTIMAL: Two pointers (fast moves n steps ahead first)
    // TC=>O(N)
    // SC=>O(1)
    public static ListNode removeNthOptimal(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original: "); printList(head);
        head = removeNthOptimal(head, 2);
        System.out.print("After removing 2nd from end: "); printList(head);
    }
}