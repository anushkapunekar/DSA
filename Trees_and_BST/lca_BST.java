package DSA.Trees_and_BST;

class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        left = right = null;
    }
}

public class lca_BST {

    public Node findLCA(Node root, int p, int q) {
        if (root == null) {
            return null;
        }

       
        if (p < root.val && q < root.val) {
            return findLCA(root.left, p, q);
        }

       
        if (p > root.val && q > root.val) {
            return findLCA(root.right, p, q);
        }

        
        return root;
    }

    public static void main(String[] args) {
        lca_BST solution = new lca_BST();

        /*
                 6
               /   \
              2     8
             / \   / \
            0   4 7   9
               / \
              3   5
        */
        Node root = new Node(6);
        root.left = new Node(2);
        root.right = new Node(8);
        root.left.left = new Node(0);
        root.left.right = new Node(4);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        root.left.right.left = new Node(3);
        root.left.right.right = new Node(5);

        int p = 2, q = 8;
        Node lca1 = solution.findLCA(root, p, q);
        System.out.println("LCA of " + p + " and " + q + " is: " + lca1.val); // Output: 6

        int p2 = 2, q2 = 4;
        Node lca2 = solution.findLCA(root, p2, q2);
        System.out.println("LCA of " + p2 + " and " + q2 + " is: " + lca2.val); // Output: 2
    }
}