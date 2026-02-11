package revision;
import java.util.*;

public class question25 {
//least common ancestor
static class TreeNode{
    int data;
    TreeNode left, right;
    TreeNode(int data){
        this.data=data;
    }
}
public static TreeNode lca(TreeNode root , TreeNode a , TreeNode b){
    while(root!=null){
        if(a.data<root.data && b.data<root.data){
            root=root.left;
        }else if (a.data>root.data && b.data>root.data){
            root=root.right;
        }else{
            return root;
        }
    }
    return null;
}

public static void main(String[] args){
    TreeNode root = new TreeNode(20);
    root.left = new TreeNode(10);
    root.right = new TreeNode(30);
    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(15);

    TreeNode nodeA = root.left.left;
    TreeNode nodeB = root.left.right;

    TreeNode result = lca(root, nodeA ,nodeB);
    System.out.println(result.data);
}
}
