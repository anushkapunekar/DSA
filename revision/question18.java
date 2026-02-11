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
public class question18 {
    //bfs traversal(levelwise)
     public static void levelWise(TreeNode root){
        if(root==null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode current = q.poll();
            System.out.println(current.data+ " ");
            if(current.left!=null)q.add(current.left);
            if(current.right!=null)q.add(current.right);
        }
        System.out.println();
          
    }
    public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    
    levelWise(root); 
    }}

