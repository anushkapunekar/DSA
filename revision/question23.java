package revision;
import java.util.*;
public class question23 {
    //insert a given node in binary search tree 
    static class TreeNode{
    int data;
    TreeNode left, right;
    TreeNode(int data){
        this.data=data;
    }
}
   public static TreeNode insert(TreeNode root , int val){
       TreeNode newNode = new TreeNode(val);
       if(root == null ){
        return newNode;
       }
       TreeNode current = root;
       TreeNode parent = null;
       while(current!=null){
        parent= current;
        if(val<current.data){
            current=current.left;
        }else if(val>current.data){
            current=current.right;
        }else{
            return root;
        }
         
       }
       if(val<parent.data){
        parent.left = newNode;
       }else{
        parent.right = newNode;
       }
       return root;

   }
   public static void main(String[] args){
    TreeNode root = new TreeNode(10);
    insert(root, 5);
    insert(root , 15);
    insert(root, 12);
    System.out.println("Left child: " + root.left.data);   
    System.out.println("Right child: " + root.right.data);
    System.out.println("Right->Left: " + root.right.left.data);
   }
}
