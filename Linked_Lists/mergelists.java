import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class mergelists {

    // BRUTE FORCE: Using an external list and sorting  
    // TC=>O((N+M) + (N+M)log(N+M))
    // SC=>O(N+M)
    public static ListNode mergeBruteForce(ListNode l1, ListNode l2) {
        List<Integer> nodes = new ArrayList<>();
        
        while (l1 != null) {
            nodes.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            nodes.add(l2.val);
            l2 = l2.next;
        }
        
        Collections.sort(nodes);
        
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        for (int value : nodes) {
            temp.next = new ListNode(value);
            temp = temp.next;
        }
        return dummy.next;
    }

    
    // OPTIMAL: In-place pointer manipulation
    // TC=>O(N+M)
    // SC=>O(1)
    public static ListNode mergeOptimal(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        
        if (l1 != null) temp.next = l1;
        else temp.next = l2;

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
        // List 1: 1 -> 3 -> 5
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        // List 2: 2 -> 4 -> 6
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        System.out.print("List 1: "); printList(l1);
        System.out.print("List 2: "); printList(l2);

        // Test Optimal
        ListNode merged = mergeOptimal(l1, l2);
        
        System.out.print("Merged List: ");
        printList(merged);
    }
}