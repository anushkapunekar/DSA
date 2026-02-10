package revision;
import java.util.*;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode(int data){
        this.data = data;
        this.left=null;
        this.right=null;
    }
}
public class question16 {
    //dfs traversal recursive
    public static void preorder(TreeNode root){
        if(root == null)return;
        System.out.println(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void inorder(TreeNode root){
        if(root==null)return;
        inorder(root.left);
        System.out.println(root.data+" ");
        inorder(root.right);
    }
    public static void postorder(TreeNode root){
        if(root==null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data+" ");
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.print("preorder:");
        preorder(root);
        System.out.println();

        System.out.print("inorder:");
        inorder(root);
        System.out.println();

        System.out.print("postorder:");
        postorder(root);
        System.out.println();


    }
}
