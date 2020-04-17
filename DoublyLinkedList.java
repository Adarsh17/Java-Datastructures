/*
Input:
  4 7 2 9
  
Output:
  Normal order:
        4 7 2 9
  Reverse order:
        9 2 7 4

*/

import java.util.*;
class Node
{
    int data;
    Node next,prev;
    
    public Node(int data)
    {
        this.data=data;
        this.next=this.prev=null;
    }
}

public class DoublyLinkedList
{
    public static Node head,tail;
    
    public void insert(int data)
    {
        Node no=new Node(data);
        if(head==null)
        {
            head=tail=no;
            tail.next=null;
            head.prev=null;
        }
        else
        {
            tail.next=no;
            no.prev=tail;
            no.next=null;
            tail=no;
            
            
        }
    }
    
    public void display()
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
        Node temp2=tail;
        while(temp2!=null)
        {
            System.out.print(temp2.data+" ");
            temp2=temp2.prev;
        }
    }
    public static void main(String args[])
    {
        DoublyLinkedList ll=new DoublyLinkedList();
        ll.insert(4);
        ll.insert(7);
        ll.insert(2);
        ll.insert(9);
        ll.display();
    }
}
