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
public class question19 {
    //find maxdepth 
    public static int maxDepth(TreeNode root){
       if(root==null) return 0 ;
       int leftHeight = maxDepth(root.left);
       int rightHeight = maxDepth(root.right);
       return Math.max(leftHeight, rightHeight)+1;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left= new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left= new TreeNode(4);
        System.out.println(maxDepth(root));
    }
}
