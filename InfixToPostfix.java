/*

Input:
    a+b*(c^d-e)^(f+g*h)-i

Output:
    a b c d ^ e - f g h * + ^ * + i - 

*/

import java.util.*;
public class InfixToPostfix
{
    public static int prec(char ch)
    {
        switch(ch)
        {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
    public static String convert(String s)
    {
        String result="";
        Stack<Character> st=new Stack<Character>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(Character.isDigit(ch) || Character.isLetter(ch) )
            {
                result+=ch;
            }
            else if(ch=='(')
            {
                st.push(ch);
            }
            else if(ch==')')
            {
                while(!st.isEmpty() && st.peek()!='(')
                    result+=st.pop();
                if(!st.isEmpty() && st.peek()!='(')
                    return "invalid";
                else
                    st.pop();
            }
            else
            {
                while(!st.isEmpty() && prec(ch)<=prec(st.peek()))
                {
                    if(st.peek()=='(')
                        return "invalid";
                    result+=st.pop();
                }
                st.push(ch);
            }
        }
        
        while(!st.isEmpty())
        {
            if(st.peek()=='(')
                return "invalid";
                result+=st.pop();
        }
        return result;
    }
    public static void main(String args[])
    {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        String result=convert(s);
        for(int i=0;i<result.length();i++)
        {
            System.out.print(result.charAt(i)+" ");
        }
    }
}
