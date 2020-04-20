/*

Input:
    5 2
    3 4 7 6 5
    
Output:
    4
    6
    3
    5
    7
    
*/


import java.util.*;
public class Waiter
{
    public static void print(Stack<Integer> st)
    {
        while(!st.isEmpty())
        {
            System.out.println(st.pop());
        }
    }
    public static void main(String args[])
    {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int q=scanner.nextInt();
        Stack<Integer> st1=new Stack<Integer>();
        for(int i=1;i<=n;i++)
        {
            int number=scanner.nextInt();
            st1.push(number);
        }
        
        ArrayList<Integer> al=new ArrayList<Integer>();
        int lower=2,upper=100;
        while(lower<=upper)
        {
            int flag=0;
            for(int i=2;i<=lower/2;i++)
            {
                if(lower%i==0)
                {
                    flag=1;
                    break;
                }
            }
            if(flag!=1)
            {
                al.add(lower);
            }
            lower++;
        }
        
        int m=0;
        int prime=al.get(m);
        for(int i=1;i<=q;i++)
        {
            Stack<Integer> st2=new Stack<Integer>();
            Stack<Integer> newSt1=new Stack<Integer>();
            while(!st1.isEmpty())
            {
                int num=st1.pop();
                if(num%prime==0)
                {
                    st2.push(num);
                }
                else
                {
                    newSt1.push(num);
                }
            }
            m++;
            prime=al.get(m);
            st1=newSt1;
            print(st2);
        }
        print(st1);
        
    }
}
