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
public class question10 {
    //find middle elementin a linkedlist
    public static Node middleElement(Node head){
        Node slow = head;
        Node fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow =slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next=new Node(3);
        head.next.next.next= new Node(4);
        
        Node middle = middleElement(head);
        if(middle!=null){
            System.out.println(middle.data);
        }
    }
}
