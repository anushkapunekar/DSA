package revision;
import java.util.*;
public class question21 {
    //find the celing
    static class TreeNode{
    int data;
    TreeNode left, right;
    TreeNode(int data){
        this.data=data;
    }
}
  public static int ceiling(TreeNode root, int target){
    int ceiling = -1;
    TreeNode current = root;
    while(current!=null){
        if(current.data==target){
            return current.data;
        }else if(target>current.data){
            current=current.right;
        }else{
            ceiling=current.data;
            current=current.left;
        }
    }
    return ceiling;
  }
    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        int target = 6;
        int result = ceiling(root , target);
        System.out.println(result);
    }
}
