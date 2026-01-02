package DSA.Trees_and_BST;

class Node {
    int val;
    Node left, right;

    public Node(int val) {
        this.val = val;
        left = right = null;
    }
}

public class implementationBST {
    Node root;

    public void insert(int val) {
        root = insertRecursive(root, val);
    }

    private Node insertRecursive(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (val < root.val) {
            root.left = insertRecursive(root.left, val);
        } else if (val > root.val) {
            root.right = insertRecursive(root.right, val);
        }
        return root;
    }

    public boolean search(int key) {
        return searchRecursive(root, key);
    }

    private boolean searchRecursive(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.val == key) {
            return true;
        }
        return key < root.val 
            ? searchRecursive(root.left, key) 
            : searchRecursive(root.right, key);
    }

    public static void main(String[] args) {
        implementationBST tree = new implementationBST();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        int keyToFind = 60;
        if (tree.search(keyToFind)) {
            System.out.println(keyToFind + " found in the BST.");
        } else {
            System.out.println(keyToFind + " not found.");
        }
    }
}