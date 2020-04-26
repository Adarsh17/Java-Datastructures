/*

Input:
    4
    6
    7
    8
    9

Output:
    9 8 7 6 
*/
import java.util.*;
public class ReversingQueue
{
    public static LinkedList<Integer> ll=new LinkedList<Integer>();
    
    public static LinkedList<Integer> reverseQueue(LinkedList<Integer> ll)
    {
        Stack<Integer> st=new Stack<Integer>();
        while(!ll.isEmpty())
        {
            st.push(ll.peek());
            ll.removeFirst();
        }
        while(!st.isEmpty())
        {
            ll.add(st.peek());
            st.pop();
        }
        return ll;
    }
    
    public static void Print()
    {
        Iterator itr=ll.iterator();
        while(itr.hasNext())
        {
            System.out.print(itr.next()+" ");
        }
    }
    
    public static void main(String args[])
    {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        for(int i=1;i<=n;i++)
        {
            int number=scanner.nextInt();
            ll.add(number);
        }
        ll=reverseQueue(ll);
        Print();
    }
}
