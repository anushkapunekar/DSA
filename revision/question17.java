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
public class question17 {
    //dfs iterative
    public static void preorder(TreeNode root){
        if(root==null)return ;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode current = st.pop();
            System.out.println(current.data+" ");
            if(current.right!=null)st.push(current.right);
            if(current.left!=null)st.push(current.left);
        }
        System.out.println();
    }

    public static void inorder(TreeNode root){
        if(root==null)return;
        Stack<TreeNode> st =new Stack<>();
        TreeNode current = root;
        while(current!=null||!st.isEmpty()){
            while(current!=null){
                st.push(current);
                current=current.left;
            }
            current=st.pop();
            System.out.println(current.data+" ");
            current=current.right;
        }
        System.out.println();
    }    

    public static void postorder(TreeNode root){
        if(root==null) return;
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(root);
        while(!st1.isEmpty()){
            TreeNode current = st1.pop();
            st2.push(current);
            if(current.left!=null)st1.push(current.left);
            if(current.right!=null)st1.push(current.right);
        }
        while(!st2.isEmpty()){
            System.out.println(st2.pop().data+" ");
        }
        System.out.println();
    }
        public static void main(String[] args){
           TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.print("Preorder: "); preorder(root);
        System.out.print("Inorder: ");  inorder(root);
        System.out.print("Postorder: "); postorder(root);
        }

    }

