import java.util.*;
class Node
{
    int data;
    Node left,right;
    
    public Node(int data)
    {
        this.data=data;
        this.left=null;
        this.right=null;
    }
}


public class Bst{
    
     public static Node root=null;
    public void Preorder(Node temp)
    {
        if(temp == null) return;
        System.out.print(temp.data+" ");
        Preorder(temp.left);
        Preorder(temp.right);
        
    }
    public void Inorder(Node temp)
    {
        if(temp == null) return;
        Inorder(temp.left);
        System.out.print(temp.data+" ");
        Inorder(temp.right);
        
    }
    public void Postorder(Node temp)
    {
        if(temp == null) return;
        Postorder(temp.left);
        Postorder(temp.right);
        System.out.print(temp.data+" ");
        
    }
    public void addNode(int data)
    {
        Node n=new Node(data);
        Node temp=root;
        Node prev=root;
        
        if(root==null)
        {
            root=n;
            return;
        }
        
        while(temp!=null)
        {
        if(data<temp.data)
        {
            
                prev=temp;
                temp=temp.left;
        }
        else if(data>temp.data)
        {
                prev=temp;
                temp=temp.right;
        }

        }
        if(data<prev.data)
            prev.left=n;
        else 
         prev.right=n;
    }
    
    public static void main(String args[])
    {
      
      Bst b=new Bst();
       b.addNode(5);
       b.addNode(3);
       b.addNode(7);
       b.addNode(4);
       
       b.Preorder(root);
       System.out.println();
       b.Inorder(root);
       System.out.println();
       b.Postorder(root);
        
    }
}