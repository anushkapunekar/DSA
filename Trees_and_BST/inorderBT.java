package DSA.Trees_and_BST;

public class inorderBT {
    static class Node{
        int data;
        Node left, right;

        public Node(int item){
            data=item;
            left=right=null;
        }
    }
    Node root;

    public inorderBT(){
        root=null;
    }

    void inorderTraversal(Node node){
        if(node==null){
            return;
        }
        inorderTraversal(node.left);
        System.out.println(node.data+"");
        inorderTraversal(node.right);
    }

    public static void main(String[] args) {
        inorderBT tree =new inorderBT();
        tree.root=new Node(1);
        tree.root.left=new Node(2);
        tree.root.right=new Node(3);
        tree.root.left.left=new Node(4);
        tree.root.left.right=new Node(5);
        tree.root.right.left=new Node(6);

        System.out.println("In-order traversal :");
        tree.inorderTraversal(tree.root);

    }
}


//output: In-order traversal :
/*4
2
5
1
6
3*/
//TC=O(N) ;
//SC=O(h); height of tree due to recursion