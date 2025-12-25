import java.util.*;

public class addtwonumbers {

    // OPTIMAL: Iterative sum with carry
    // TC=>O(max(N, M))
    // SC=>O(max(N, M)) - for the new list
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            sum += carry;
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
        }
        return dummy.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // List 1: 2 -> 4 -> 3 (342)
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // List 2: 5 -> 6 -> 4 (465)
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.print("Num 1: "); printList(l1);
        System.out.print("Num 2: "); printList(l2);

        ListNode result = addTwoNumbers(l1, l2);
        System.out.print("Sum: "); printList(result); 
    }
}