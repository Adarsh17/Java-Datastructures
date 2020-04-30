import java.util.*;
public class GraphMatrix
{
    public static int v;
    public static boolean arr[][];
    
    public GraphMatrix(int vertices)
    {
        v=vertices;
        arr=new boolean[vertices][vertices];
    }
    
    public static void add(int i,int j)
    {
        arr[i][j]=true;
        arr[j][i]=true;
    }
    
    public static String convertString()
    {
        StringBuffer sb=new StringBuffer();
        System.out.print("      ");
        for(int i=0;i<v;i++)
        {
            System.out.print(i+"    ");
        }
        System.out.println();
        for(int i=0;i<v;i++)
        {
            sb.append(i+"    ");
            for(boolean j:arr[i])
            {
                sb.append((j?1:0)+"    ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    
    public static void main(String args[])
    {
        Scanner scanner=new Scanner(System.in);
        int vertices=scanner.nextInt();
        GraphMatrix m=new GraphMatrix(vertices); 
        int edges=scanner.nextInt();
        for(int i=1;i<=edges;i++)
        {
            int n1=scanner.nextInt();
            int n2=scanner.nextInt();
            add(n1,n2);
        }
        System.out.println(m.convertString());
    }
}
