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
    
    /*---------------------------------------printing bst in inorder,preorder,postorder-----------------------*/
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
    
    /*---------------------------------------------------Node insertion------------------------------------------------*/
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
 /*------------------------------------------------To find height of bst---------------------------------------*/   
    public int findHeight(Node temp)
    {
        if(temp==null)
        {
            return 0;
        }
        
        else
        {
            int lh=findHeight(temp.left);
            int rh=findHeight(temp.right);
            
            if(lh>rh)
            {
                return (lh+1);
            }
            else
            {
                return (rh+1);
            }
        }
    }
    /*--------------------------------------------Distance between any two nodes---------------------------*/
    
    public static Node lca(Node root,int n1,int n2)
    {
        if(root==null)
        {
            return root;
        }
        
        if(root.data==n1 || root.data==n2)
        {
            return root;
        }
        
        Node left=lca(root.left,n1,n2);
        Node right=lca(root.right,n1,n2);
        
        if(left!=null && right!=null)
        {
            return root;
        }
        
        if(left!=null)
        {
            return lca(root.left,n1,n2);
        }
        else
        {
            return lca(root.left,n1,n2);
        }
    }
    
    public static int lvl(Node root,int n,int d)
    {
        if(root==null)
        {
            return -1;
        }
        
        if(root.data==n)
        {
            return d;
        }
        
        int left=lvl(root.left,n,d+1);
        if(left==-1)
        left=lvl(root.right,n,d+1);
        
        return left;
    }
    
    public int findDistance(Node root,int n1,int n2)
    {
        Node lower=lca(root,n1,n2);
        
        int dist1=lvl(root,n1,0);
        int dist2=lvl(root,n2,0);
        
        return dist1+dist2;
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
        
       System.out.println("The height of bst is " + b.findHeight(root) ); 
        
       System.out.println("The distance between 4 and 7 is " + findDistance(root,4,7));
        
    }
}
