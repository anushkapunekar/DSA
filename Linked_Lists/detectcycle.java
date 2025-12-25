import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class detectcycle {

    // BRUTE FORCE: Using a HashSet to store visited nodes
    // TC=>O(N)
    // SC=>O(N)
    public static boolean hasCycleBrute(ListNode head) {
        HashSet<ListNode> visited = new HashSet<>();
        ListNode temp = head;
        while (temp != null) {
            if (visited.contains(temp)) return true;
            visited.add(temp);
            temp = temp.next;
        }
        return false;
    }

    // OPTIMAL: Floyd's Tortoise and Hare (Slow & Fast Pointers)
    // TC=>O(N)
    // SC=>O(1)
    public static boolean hasCycleOptimal(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head.next; 

        boolean result = hasCycleOptimal(head);
        System.out.println("Cycle detected: " + result);
    }
}