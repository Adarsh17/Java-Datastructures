/*

Input:
    4
    1
    2
    3
    4

Output:

    3
    
*/


import java.util.*;
public class MancunianFantabulousPairs
{
    public static void main(String args[])
    {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int arr[]=new int[n+1];
        int arr2[]=new int[n+1];
        int arr3[]=new int[n+1];
        for(int i=1;i<=n;i++)
        {
            arr[i]=scanner.nextInt();
        }
        Stack<Integer> st=new Stack<Integer>();
        for(int i=arr.length-1;i>=1;i--)
        {
            while(!st.isEmpty() && arr[i]>arr[st.peek()])
            {
                arr2[st.peek()]=st.peek()-i;
                st.pop();
            }
            st.push(i);
        }
        
        while(!st.isEmpty())
        {
            arr2[st.peek()]=st.peek();
            st.pop();
        }
        
        for(int i=1;i<=n;i++)
        {
            while(!st.isEmpty() && arr[st.peek()]<arr[i])
            {
                int x=i-st.peek()+1;
                arr3[x]=Math.max(arr3[x],arr2[st.peek()]);
                st.pop();
            }
            st.push(i);
        }
        
        int x=0;
        for(int i=2;i<=n;i++)
        {
            x+=arr3[i];
        }
        
        System.out.println(x);
    }
}
