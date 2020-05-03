/*
Input:
    4 
    5
    0 0 1 1 0
    1 0 1 1 0
    0 1 0 0 0 
    0 0 0 0 1
    
Output:    
    6

*/
import java.util.*;
public class GraphLargestRegion
{
    static int r,c,count;
    
    public static boolean isSafe(int arr[][],int row,int col,boolean visited[][])
    {
        return ((row>=0) && (row<r) && (col>=0) && (col<c) && (arr[row][col]==1 && !visited[row][col]));
    }
    
    public static void DFS(int arr[][],int row,int col,boolean visited[][])
    {
         int x[]={0,0,1,-1,1,-1,1,-1};
         int y[]={1,-1,0,0,1,-1,-1,1};
         
         visited[row][col]=true;
         for(int i=0;i<8;i++)
         {
             if(isSafe(arr,row+x[i],col+y[i],visited))
             {
                 count++;
                 DFS(arr,row+x[i],col+y[i],visited);
             }
         }
    }
    
    public static int  findLargestRegion(int arr[][])
    {
        boolean visited[][]=new boolean[r][c];
        int result=0;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(arr[i][j]==1 && !visited[i][j])
                {
                    count=1;
                    DFS(arr,i,j,visited);
                    result=Math.max(result,count);
                }
            }
        }
        return result;
        
        
    }
    public static void main(String args[])
    {
        Scanner scanner=new Scanner(System.in);
        r=scanner.nextInt();
        c=scanner.nextInt();
        int arr[][]=new int[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                
                arr[i][j]=scanner.nextInt();
            }
        }
        
        
        System.out.println(findLargestRegion(arr));
    }
}
