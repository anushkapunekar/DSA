package DSA.Trees_and_BST;

class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        left = right = null;
    }
}

public class leastCommonAncestorBT {

    public Node findLCA(Node root, int p, int q) {
       
        if (root == null || root.val == p || root.val == q) {
            return root;
        }

        // Look for p and q in the left and right subtrees
        Node leftSearch = findLCA(root.left, p, q);
        Node rightSearch = findLCA(root.right, p, q);

        // If leftSearch and rightSearch are both non-null, 
        // it means p is in one subtree and q is in the other.
        // Therefore, this current node is the Lowest Common Ancestor.
        if (leftSearch != null && rightSearch != null) {
            return root;
        }

        // If one side is null, it means both nodes (or the LCA itself) 
        // are located in the non-null subtree.
        return (leftSearch != null) ? leftSearch : rightSearch;
    }

    public static void main(String[] args) {
        leastCommonAncestorBT solution = new leastCommonAncestorBT();

        /*
                 3
               /   \
              5     1
             / \   / \
            6   2 0   8
               / \
              7   4
        */
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.right.left = new Node(0);
        root.right.right = new Node(8);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);

        int p = 5, q = 1;
        Node lca1 = solution.findLCA(root, p, q);
        System.out.println("LCA of " + p + " and " + q + " is: " + lca1.val); // Output: 3

        int p2 = 5, q2 = 4;
        Node lca2 = solution.findLCA(root, p2, q2);
        System.out.println("LCA of " + p2 + " and " + q2 + " is: " + lca2.val); // Output: 5
    }
}