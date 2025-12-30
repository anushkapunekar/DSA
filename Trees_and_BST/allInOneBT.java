package DSA.Trees_and_BST;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class allInOneBT {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    
    static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state; // 1: Pre, 2: In, 3: Post
        }
    }

    public static void allInOneTraversal(Node root) {
        if (root == null) return;

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));

        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();

        while (!st.isEmpty()) {
            Pair it = st.peek();

            // 1. Pre-order State
            // Action: Add to Pre, Increment State, Push Left Child
            if (it.state == 1) {
                preOrder.add(it.node.data);
                it.state++;

                if (it.node.left != null) {
                    st.push(new Pair(it.node.left, 1));
                }
            } 
            // 2. In-order State
            // Action: Add to In, Increment State, Push Right Child
            else if (it.state == 2) {
                inOrder.add(it.node.data);
                it.state++;

                if (it.node.right != null) {
                    st.push(new Pair(it.node.right, 1));
                }
            } 
            // 3. Post-order State
            // Action: Add to Post, Pop from Stack
            else {
                postOrder.add(it.node.data);
                st.pop();
            }
        }

        
        System.out.println("Pre-order : " + preOrder);
        System.out.println("In-order  : " + inOrder);
        System.out.println("Post-order: " + postOrder);
    }

    public static void main(String[] args) {
    
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);

        allInOneTraversal(root);
    }
}