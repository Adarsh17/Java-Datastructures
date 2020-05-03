/*

Input:
    5
    A
    B
    C
    D
    E
    8
    A B
    A D
    A E
    B C
    B E
    B D
    C D
    C E
    
Output:
    Graph - Adjacency List:
    A: B D E 
    B: A C E D 
    C: B D E 
    D: A B C 
    E: A B C 
    
*/


import java.util.*;
public class GraphAdjacencyList<T>
{
    Map<T,List<T>> hm=new LinkedHashMap<>();
    
    public void addVertex(T s)
    {
        hm.put(s,new LinkedList<T>());
    }
    
    public void addEdge(T s1,T s2,boolean b)
    {
        if(!hm.containsKey(s1))
        {
            addVertex(s1);
        }
        
        if(!hm.containsKey(s2))
        {
            addVertex(s2);
        }
        
        hm.get(s1).add(s2);
        if(b==true)
        {
            hm.get(s2).add(s1);
        }
    }
    
    public String convertString()
    {
        StringBuffer sb=new StringBuffer();
        for(T i:hm.keySet())
        {
            sb.append(i.toString()+": ");
            for(T j:hm.get(i))
            {
                sb.append(j.toString()+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    
    public static void main(String args[])
    {
        Scanner scanner=new Scanner(System.in);
        GraphAdjacencyList<String> al=new GraphAdjacencyList<String>();
        int v=scanner.nextInt();
        scanner.nextLine();
        for(int i=1;i<=v;i++)
        {
            String s=scanner.nextLine();
            al.addVertex(s);
        }
        
        int edges=scanner.nextInt();
        scanner.nextLine();
        for(int i=1;i<=edges;i++)
        {
            String s1=scanner.nextLine();
            String words[]=s1.split(" ");
            al.addEdge(words[0],words[1],true);
        }
        
        System.out.println("Graph - Adjacency List:");
        System.out.println(al.convertString());
    }
}
