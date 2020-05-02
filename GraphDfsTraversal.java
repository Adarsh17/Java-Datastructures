/*

Input:
    4
    6
    0 1
    0 2 
    1 2
    2 0 
    2 3
    3 3
    2

Output:
    2 0 1 3 

*/


import java.util.*;
public class DfsTraversal
{
    int v;
    LinkedList<Integer> ll[];
    
    public DfsTraversal(int v)
    {
        this.v=v;
        ll=new LinkedList[v];
        for(int i=0;i<v;i++)
        {
            ll[i]=new LinkedList();
        }
    }
    
    public void addEdge(int i,int j)
    {
        ll[i].add(j);
    }
    
    public void DFSTraverse(boolean visited[],int num)
    {
        visited[num]=true;
        System.out.print(num+" ");
        
        Iterator<Integer> itr=ll[num].listIterator();
        while(itr.hasNext())
        {
            int n=itr.next();
            if(!visited[n])
            {
                visited[n]=true;
                DFSTraverse(visited,n);
            }
        }
    }
    
    public void DFS(int num)
    {
        boolean visited[]=new boolean[v];
        DFSTraverse(visited,num);
    }
    
    public static void main(String args[])
    {
        Scanner scanner=new Scanner(System.in);
        int v=scanner.nextInt();
        DfsTraversal dt=new DfsTraversal(v);
        int edges=scanner.nextInt();
        for(int i=1;i<=edges;i++)
        {
            int n1=scanner.nextInt();
            int n2=scanner.nextInt();
            dt.addEdge(n1,n2);
        }
        
        int n=scanner.nextInt();
        if(n==0 || n==1 || n==2 || n==3)
        {
            dt.DFS(n);
        }
        else
        {
            System.out.println("Invalid input");
        }
    }
}
