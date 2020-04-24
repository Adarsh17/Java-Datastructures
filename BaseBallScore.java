/*


Input:
    5 2 C D +

Output:
    30
    
*/

import java.util.*;
public class BaseBallScore
{
    public static void main(String args[])
    {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        String words[]=s.split(" ");
        int sum=0,result=0;;
        Stack<String> st=new Stack<String>();
        for(int i=0;i<words.length;i++)
        {
            char ch=words[i].charAt(0);
            if(Character.isDigit(ch))
            {
                st.push(words[i]);
            }
            
            else if(ch=='C')
            {
                st.pop();
            }
            
            else if(ch=='D')
            {
                int n=Integer.parseInt(String.valueOf(st.peek()));
                int square=n*n;
                String val=String.valueOf(square);
                st.push(val);
            }
            
            else if(ch=='+')
            {
                for(int j=st.size()-1;j>=st.size()-2;j--)
                {
                    sum+=Integer.parseInt(st.get(j));
                }
            }
        }
        
        while(!st.isEmpty())
        {
            result+=Integer.parseInt(st.pop());
        }
        
        System.out.println(result);
        
    }
}
