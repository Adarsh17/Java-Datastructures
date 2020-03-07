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

public class LinkedListInsertAtPos 
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
    
    public void insertAtPos(int n,int n2)
    {
        Node no=new Node(n);
        Node temp=head;
        Node temp2=null;
        int i=0;
        if(n2>0){
            while(temp!=null && i<n2)
            {
                temp2=temp;
                temp=temp.next;
                i++;
            }
            no.next=temp2.next;
            temp2.next=no;
        }
        else if(n2==0){
            no.next=head;
            head=no;
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
    }
    
    public static void main(String args[])
    {
        LinkedListInsertAtPos m=new LinkedListInsertAtPos();
        m.insert(1);
        m.insert(2);
        m.insert(3);
        m.insert(4);
        m.insert(5);
        m.insertAtPos(6,0);
        m.display();
    }
}