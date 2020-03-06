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

public class LinkedListBasicOperations
{
    public Node head=null;
    public Node tail=null;
    
    public void insert(int n)
    {
        Node no=new Node(n);
        if(head==null)
        {
            head=no;
            tail=no;
        }
        
        else{
            tail.next=no;
            tail=no;
        }
    }
      public void insertFirst(int n1)
        {
            Node no1=new Node(n1);
            no1.next=head;
            head=no1;
        }
    
    
    // public void insertFirst(int n)
    // {
    //     Node no=new Node(n);
    //     no.next=head;
    //     head=no;
    // }
    
    public void delete()
    {
        Node temp=head;
        Node temp1=head;
        if(temp!=null){
            while(temp!=tail)
            {
                temp1=temp;
                temp=temp.next;
            }
            temp1.next=null;
            temp1=tail;
        }
    }
    
    public void deleteFirst()
    {
        Node temp=head;
        head=null;
        head=temp.next;
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
    }
    
    
    public static void main(String args[])
    {
        Main ll=new Main();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insertFirst(0);
        ll.display();
       
        
    }
}