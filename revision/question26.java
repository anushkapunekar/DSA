package revision;
import java.util.*;

public class question26 {
    //insertion of a node
    
    static class TreeNode{
        int data;
        TreeNode left, right;
        TreeNode(int data){
            this.data=data;
        }
    }
    public static TreeNode insert(TreeNode root, int val){
        if(root==null){
            return new TreeNode(val);
    }
    //recursive 
    // if(val<root.data){
    //     root.left=insert(root.left, val);
    // }else if(val>root.data){
    //     root.right=insert(root.right, val);
    // }
    // return root;
    TreeNode current = root ;
    TreeNode parent = null;
    while(current!=null){
        parent=current;
        if(val<current.data){
            current=current.left;
        }else if(val>current.data){
            current=current.right;
        }else{
            return root;
        }
    }
    if(val<parent.data){
        parent.left= new TreeNode(val);
    }else{
        parent.right = new TreeNode(val);
    }
    return root;
}
    public static void main(String[] args){
        TreeNode root = null;
        root = insert(root,50);
        insert(root, 30);
        insert(root,70);
        insert(root, 20);

        System.out.println(root.data);
        System.out.println(root.left.data);

    }}
