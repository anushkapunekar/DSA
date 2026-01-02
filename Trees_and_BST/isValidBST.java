package DSA.Trees_and_BST;

class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
    }
}

public class isValidBST {

    public boolean validate(Node root) {
        // Use Long to handle edge cases where node.val is Integer.MIN/MAX_VALUE
        return checkRange(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean checkRange(Node node, long min, long max) {
        if (node == null) {
            return true;
        }

       
        if (node.val <= min || node.val >= max) {
            return false;
        }

        
        return checkRange(node.left, min, node.val) && 
               checkRange(node.right, node.val, max);
    }

    public static void main(String[] args) {
        isValidBST validator = new isValidBST();

        // Creating a valid BST:
        //      10
        //     /  \
        //    5    15
        //        /  \
        //       12   20
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.right.left = new Node(12);
        root.right.right = new Node(20);

        if (validator.validate(root)) {
            System.out.println("The tree is a valid BST.");
        } else {
            System.out.println("The tree is NOT a valid BST.");
        }
    }

}

//TC=o(n);
//SC=o(h); h = height