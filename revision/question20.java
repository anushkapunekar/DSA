package revision;
import java.util.*;


public class question20 {
    static class TreeNode{
    int data;
    TreeNode left, right;
    TreeNode(int data){
        this.data=data;
    }
}

    //search in bst
    public static boolean search(TreeNode root , int target){
         TreeNode current = root;
         while(current!=null){
            if(target == current.data)return true;
            if(target<current.data){
                current=current.left;
            }else{
                current=current.right;
            }

         }
         return false;
    }
    public static void main(String[] args){
       TreeNode root = new TreeNode(5);
       root.left= new TreeNode(3);
       root.right = new TreeNode(7);

       int target = 7;
       System.out.println(search(root,target));
    }
}
