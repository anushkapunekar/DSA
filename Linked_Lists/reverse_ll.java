import java.util.*;

class Node {
    int val;
    Node next;
    Node(int val) { this.val = val; }
}

public class reverse_ll {
    
    // BRUTE FORCE: Using a Stack
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public static Node reverseBruteForce(Node head) {
        if (head == null || head.next == null) return head;

        Stack<Integer> stack = new Stack<>();
        Node temp = head;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            temp.val = stack.pop();
            temp = temp.next;
        }
        return head;
    }

    // OPTIMAL: Pointer Manipulation
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static Node reverseOptimal(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create List: 10 -> 20 -> 30 -> 40
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        System.out.print("Original: ");
        printList(head);

        // To test Brute Force:
        // head = reverseBruteForce(head);
        
        // To test Optimal:
        head = reverseOptimal(head);

        System.out.print("Reversed: ");
        printList(head);
    }
}