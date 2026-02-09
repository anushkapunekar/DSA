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

public class question12 {
    //reverse a linkedlist iteratively
    public static Node reverseLL(Node head){
        Node curr = head;
        Node prev = null;
        while(curr!=null){
            Node next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public static void display(Node head){
        Node temp =head;
        while(temp!=null){
            System.out.println(temp.data+ " ");
            temp=temp.next;
        }
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

       
        display(head);

        head = reverseLL(head);

        System.out.println("After Reversal:");
        display(head);
    }

}
