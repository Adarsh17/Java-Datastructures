import java.util.*;

class Node
{
    int data;
    Node next;
    
    public Node(int data)
    {
        this.data=data;
        this.next=null;
    }
}

public class SimpleLinkedList
{
    public Node head=null;
    public Node tail=null;
    
    public void add(int n)
    {
        Node n1=new Node(n);
        
        if(head==null)
        {
            head=tail=n1;
        }
        
        else
        {
            tail.next=n1;
            tail=n1;
        }
    }
    
    public void display()
    {
        Node n1=head;
        while(n1!=null)
        {
            System.out.print(n1.data+" ");
            n1=n1.next;
        }
    }
    
    public static void main(String args[])
    {
        SimpleLinkedList sll=new SimpleLinkedList();
        sll.add(1);
        sll.add(2);
        sll.add(3);
        sll.add(4);
        sll.add(5);
        sll.display();
    }
}