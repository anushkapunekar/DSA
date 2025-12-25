import java.util.*;

public class intersectionlist {

    // BRUTE FORCE: Using a HashSet
    // TC=>O(N+M)
    // SC=>O(N) or O(M)
    public static ListNode getIntersectionBrute(ListNode headA, ListNode headB) {
        HashSet<ListNode> nodes = new HashSet<>();
        while (headA != null) {
            nodes.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (nodes.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }

    // OPTIMAL: Difference of length or Two-Pointer reset
    // TC=>O(N+M)
    // SC=>O(1)
    public static ListNode getIntersectionOptimal(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        ListNode a = headA;
        ListNode b = headB;
        
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;
    }

    public static void main(String[] args) {
        ListNode common = new ListNode(8);
        common.next = new ListNode(10);

        ListNode h1 = new ListNode(4);
        h1.next = new ListNode(1);
        h1.next.next = common;

        ListNode h2 = new ListNode(5);
        h2.next = new ListNode(6);
        h2.next.next = new ListNode(1);
        h2.next.next.next = common;

        ListNode intersect = getIntersectionOptimal(h1, h2);
        System.out.println("Intersection at node with value: " + (intersect != null ? intersect.val : "None"));
    }
}