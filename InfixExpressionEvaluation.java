/*

Input:
    100 * ( 2 + 12 ) / 14

Output:
    100

*/

import java.util.*;
public class InfixExpressionEvaluation
{
    public static int evaluate(String s)
    {
        char ch[]=s.toCharArray();
        Stack<Integer> values=new Stack<Integer>();
        Stack<Character> ops=new Stack<Character>();
        
        for(int i=0;i<ch.length;i++)
        {
            if(ch[i]==' ')
                continue;
                
            if(ch[i]>='0' && ch[i]<='9')
            {
                StringBuffer sb=new StringBuffer();
                while(i<ch.length && ch[i]>='0' && ch[i]<='9')
                    sb.append(ch[i++]);
                values.push(Integer.parseInt(sb.toString()));
            }
            
            else if(ch[i]=='(')
            {
                ops.push(ch[i]);
            }
            
            else if(ch[i]==')')
            {
                while(ops.peek()!='(')
                    values.push(join(ops.pop(),values.pop(),values.pop()));
                ops.pop();
            }
            
            else if(ch[i]=='+' || ch[i]=='-' || ch[i]=='*' || ch[i]=='/')
            {
                while(!ops.isEmpty() && hasPrec(ch[i],ops.peek()))
                    values.push(join(ops.pop(),values.pop(),values.pop()));
                ops.push(ch[i]);
            }
        }
        
        while(!ops.isEmpty())
                    values.push(join(ops.pop(),values.pop(),values.pop()));
        return values.pop();
    }
    
    public static boolean hasPrec(char a,char b)
    {
        if(b==')' || b=='(')
         return false;
        if((a=='*' || a=='/') && (b=='+' || b=='-'))
            return false;
        else
            return true;
    }
    
    public static int join(char ops,int b,int a)
    {
        switch(ops)
        {
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return a/b;
        }
        return 0;
    }
    
    public static void main(String args[])
    {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        System.out.println(evaluate(s));
    }
}
