/*
Input:
    5
    56 32 89 75 19
    
Output:
    19 32 56 75 89 

*/

import java.util.*;
class  Node 
{
    int data;
    Node next;
    
    public Node(int data)
    {
        this.data=data;
        this.next=null;
    }
}

public class LinkedListSort 
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
    
    public void sort()
    {
        Node temp1=head;
        while(temp1!=null)
        {
            Node temp2=temp1.next;
            while(temp2!=null)
            {
                if(temp1.data>temp2.data)
                {
                    int t=temp1.data;
                    temp1.data=temp2.data;
                    temp2.data=t;
                }
                temp2=temp2.next;
            }
            temp1=temp1.next;
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
    }
    
    public static void main(String args[])
    {
        Scanner scanner=new Scanner(System.in);
        LinkedListSort m=new LinkedListSort();
        int n=scanner.nextInt();
        for(int i=1;i<=n;i++)
        {
            int number=scanner.nextInt();
            m.insert(number);
        }
        m.sort();
        m.display();
        System.out.println();
    }
}