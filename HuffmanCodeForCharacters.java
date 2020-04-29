import java.util.*;
class Node
{
    int data;
    char c;
    Node left,right;
}

class Comparison implements Comparator<Node>
{
    public int compare(Node x,Node y)
    {
        return x.data-y.data;
    }
}
public class HuffmanCodeForCharacters
{
    public static void print(Node root,String s)
    {
        if(root.left==null && root.right==null && Character.isLetter(root.c))
        {
            System.out.println(root.c+":"+s);
            return;
        }
        print(root.left,s+"0");
        print(root.right,s+"1");
    }
    public static void main(String args[])
    {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        char ch[]=new char[n];
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            ch[i]=scanner.next().charAt(0);
        }
        
        for(int i=0;i<n;i++)
        {
            arr[i]=scanner.nextInt();
        }
        
        PriorityQueue<Node> pq=new PriorityQueue<Node>(n,new Comparison());
        
        for(int i=0;i<n;i++)
        {
            Node no=new Node();
            no.data=arr[i];
            no.c=ch[i];
            
            no.left=null;
            no.right=null;
            
            pq.add(no);
        }
        
        Node root=null;
        while(pq.size()>1)
        {
            Node x=pq.peek();
            pq.poll();
            
            Node y=pq.peek();
            pq.poll();
            
            Node newNode=new Node();
            newNode.data=x.data+y.data;
            newNode.c='-';
            
            newNode.left=x;
            newNode.right=y;
            
            root=newNode;
            
            pq.add(newNode);
        }
        
        print(root,"");
    }
}
