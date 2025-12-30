package DSA.Trees_and_BST;

import java.util.Stack;

public class iterative_inorder {
    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root;

    void iterativePreOrder(Node node) {
        if (node == null) return;

        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            // Pop the node and print it
            Node curr = stack.pop();
            System.out.print(curr.data + " ");

            // Push Right first so Left is processed first (LIFO)
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
    }

public static void main(String[] args) {
        iterative_inorder tree = new iterative_inorder();

       
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Iterative Pre-order results:");
        tree.iterativePreOrder(tree.root);
        // Expected Output: 1 2 4 5 3
    }}

    //TC=O(N):
    //SC=o(h);