/*

Input:
    100 80 60 70 60 75 85

Output:
    1 1 1 2 1 4 6 

*/


import java.util.*;
public class StockSpan
{
    public static void method(int arr[],int n,int arr2[])
    {
        arr2[0]=1;
        for(int i=1;i<n;i++)
        {
            arr2[i]=1;
            for(int j=i-1;j>=0 && arr[i]>=arr[j];j--)
            {
                arr2[i]++;
            }
        }
    }
    public static void main(String args[])
    {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        String words[]=s.split(" ");
        int arr[]=new int[words.length];
        for(int i=0;i<words.length;i++)
        {
            arr[i]=Integer.parseInt(words[i]);
        }
        int length=arr.length;
        int arr2[]=new int[length];
        method(arr,length,arr2);
        for(int i=0;i<arr2.length;i++)
        {
            System.out.print(arr2[i]+" ");
        }
    }
}
