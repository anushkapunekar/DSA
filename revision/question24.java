package revision;
import java.util.*;
public class question24 {
    //validate if its bst or not
    static class TreeNode{
    int data;
    TreeNode left, right;
    TreeNode(int data){
        this.data=data;
    }
}
    public static boolean isValid(TreeNode root){
        return valid(root, Long.MIN_VALUE , Long.MAX_VALUE);
    }
    public static boolean valid(TreeNode root , long min, long max){
        if(root==null) return true;
        if(root.data<=min||root.data>=max)return false;
        return valid(root.left ,min, root.data)&& valid(root.right ,root.data,max);
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        root.left= new TreeNode(5);
        root.right = new TreeNode(15);

        System.out.println("is valid bst? :" + isValid(root));
    }
}
