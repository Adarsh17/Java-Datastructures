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

Output:
    2 0 3 1 

*/


import java.util.*;
public class BfsTraversal
{
    static int v;
    static LinkedList<Integer> ll[];
    
    public BfsTraversal(int v)
    {
        this.v=v;
        ll=new LinkedList[v];
        for(int i=0;i<v;++i)
            ll[i]=new LinkedList();   
    }
    
    public void addEdge(int i,int j)
    {
        ll[i].add(j);
    }
    
    public  void bfs(int num)
    {
        boolean visited[]=new boolean[v];
        LinkedList<Integer> queue=new LinkedList<Integer>();
        
        visited[num]=true;
        queue.add(num);
        
        while(queue.size()!=0)
        {
            num=queue.poll();
            System.out.print(num+" ");
            
            Iterator<Integer> itr=ll[num].listIterator();
            while(itr.hasNext())
            {
                int n=itr.next();
                while(!visited[n])
                {
                    visited[n]=true;
                    queue.add(n);
                }
            }
        }
    }
    
    public static void main(String args[])
    {
        Scanner scanner=new Scanner(System.in);
        int v=scanner.nextInt();
        BfsTraversal bt=new BfsTraversal(v);
        int edges=scanner.nextInt();
        for(int i=1;i<=edges;i++)
        {
            int n1=scanner.nextInt();
            int n2=scanner.nextInt();
            bt.addEdge(n1,n2);
        }
        
        bt.bfs(2);
        
    }
}
