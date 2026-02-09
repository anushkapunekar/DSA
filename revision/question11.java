package revision;
import java.util.*;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class question11 {
    //reverse a linkedlist recursively
    public static Node reverse(Node head){
        if(head==null || head.next==null) return head;
        Node newHead = reverse(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;

    }
    public static void display(Node head){
        Node temp = head;
        while(temp!=null){
        System.out.println(temp.data+"");
        temp=temp.next;
        }
    }
     public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next=new Node(3);
        head.next.next.next= new Node(4);
        display(head);

        head= reverse(head);
        System.out.println("reversed list:");
        display(head);
        
        
    }

}
