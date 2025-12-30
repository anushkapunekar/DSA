package DSA.Trees_and_BST;

public class postorderBT {
    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root;

    public postorderBT() {
        root = null;
    }

    void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        postOrderTraversal(node.left); 
        postOrderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        postorderBT tree = new postorderBT();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Post-order traversal results:");
        tree.postOrderTraversal(tree.root);
        // Expected Output: 4 5 2 3 1 
    }
}
