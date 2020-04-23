/*

Inputs:
    1000
    2

    1453287
    3

Outputs:
    0
    
    1287

*/

import java.util.*;
public class RemoveKdigitsToGetSmallNum
{
    public static String remove(String s,int k)
    {
        Stack<Character> st=new Stack<Character>();
        if(k==s.length())
        {
            return "0";
        }
        
        if(k>s.length())
        {
            return "0";
        }
        
        if(k==0)
        {
            return s;
        }
        
        int i=0;
        while(i<s.length())
        {
            while(k>0 && !st.isEmpty() && st.peek()>s.charAt(i))
            {
                st.pop();
                k--;
            }
            st.push(s.charAt(i));
            i++;
        }
        
        while(k>0)
        {
            st.pop();
            k--;
        }
        
        StringBuffer sb=new StringBuffer();
        while(!st.isEmpty())
        {
            sb.append(st.pop());
        }
        sb.reverse();
        
        while(sb.length()>1 && sb.charAt(0)=='0')
        {
            sb.deleteCharAt(0);
        }
        
        String result=sb.toString();
        return result;
    }
    
    public static void main(String args[])
    {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        int k=scanner.nextInt();
        System.out.println(remove(s,k));
    }
}
