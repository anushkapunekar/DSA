package DSA.Trees_and_BST;

public class preorderBT {
    static class Node{
        int data;
        Node left, right;

        public Node(int item){
            data=item;
            left=right=null;
        }
    }
    Node root;

    public preorderBT(){
        root=null;
    }
    void preorderTraversal(Node node){
        if(node==null){
            return;
        }

        System.out.println(node.data+"");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }
    public static void main(String[] args) {
        preorderBT tree =new preorderBT();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Pre-order traversal results:");
        tree.preorderTraversal(tree.root);
    }
}


