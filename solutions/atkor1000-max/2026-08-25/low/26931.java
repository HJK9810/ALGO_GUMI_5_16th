import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			String belt = sc.next();
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < belt.length(); i++) {
                char c = belt.charAt(i);
            	if (stack.empty()) {
                    stack.push(c);
                	continue;
                }
                if (stack.peek() == c) {
                	stack.pop();
                    continue;
                }
                else stack.push(c);
            }
            
            
            System.out.println("#" + test_case + " " + stack.size());
		}
	}
}