package revision;
import java.util.*;
public class question22 {
    //floor in bt
    
    
    static class TreeNode{
    int data;
    TreeNode left, right;
    TreeNode(int data){
        this.data=data;
    }
}
  public static int floor(TreeNode root, int target){
    int floor= -1;
    TreeNode current = root;
    while(current!=null){
        if(current.data==target){
            return current.data;
        }else if(target<current.data){
            current=current.left;
        }else{
            floor=current.data;
            current=current.right;
        }
    }
    return floor;
  }
    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        int target = 6;
        int result = floor(root , target);
        System.out.println(result);
    }
}


