import java.util.Stack;

public class Study {
	
	
	int result;
	int temp_result;
	
	
	public static void main(String[] args)
	
	{
		int n = 45;	
			
		if(palindrome(n))
			System.out.println("Palindrome");
		else
			System.out.println("Not Palindrome");
			
	}
	
	public static boolean palindrome(int n)
	{
		Stack<Integer> st1 = new Stack<>();
		Stack<Integer> st2 = new Stack<>();
		
		while(n > 0)
		{
			st1.push(n%2);
			
			n = n / 2;
		}
		
		int i = 0;
		
		while(i < st1.size()/2)
		{
			st2.push(st1.pop());
		}
		
		while(!st1.empty() && !st2.empty())
		{
			if(st1.pop()!=st2.pop())
			{
				return false;
			}
		}
		return true;
	}

	public static void EvenPattern(int n)
	{
		for(int i = 0; i < n; i ++)
		{
			for(int j = 0; j < n; j++)
			{
				System.out.println(n);
			}
		}
	}
}
