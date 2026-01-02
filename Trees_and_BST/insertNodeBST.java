package DSA.Trees_and_BST;

class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        left = right = null;
    }
}

public class insertNodeBST {

    // Solution 1: Recursive TC=O(H)  SC=O(H)
    public Node insertIntoBSTRecursive(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        if (val < root.val) {
            root.left = insertIntoBSTRecursive(root.left, val);
        } else {
            root.right = insertIntoBSTRecursive(root.right, val);
        }

        return root;
    }

    // Solution 2: Iterative   TC=O(H)  SC=O(1)
    public Node insertIntoBSTIterative(Node root, int val) {
        if (root == null) return new Node(val);

        Node curr = root;
        while (true) {
            if (val < curr.val) {
                if (curr.left == null) {
                    curr.left = new Node(val);
                    break;
                }
                curr = curr.left;
            } else {
                if (curr.right == null) {
                    curr.right = new Node(val);
                    break;
                }
                curr = curr.right;
            }
        }
        return root;
    }

    // Helper method to print tree (In-order)
    public void printInOrder(Node root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.val + " ");
            printInOrder(root.right);
        }
    }

    public static void main(String[] args) {
        insertNodeBST solution = new insertNodeBST();
        Node root = null;

        // Using Recursive Insertion
        root = solution.insertIntoBSTRecursive(root, 4);
        solution.insertIntoBSTRecursive(root, 2);
        solution.insertIntoBSTRecursive(root, 7);
        solution.insertIntoBSTRecursive(root, 1);
        solution.insertIntoBSTRecursive(root, 3);

        System.out.print("BST after recursive insertions: ");
        solution.printInOrder(root);
        
        // Using Iterative Insertion
        solution.insertIntoBSTIterative(root, 5);
        System.out.print("\nBST after adding 5 iteratively: ");
        solution.printInOrder(root);
    }
}