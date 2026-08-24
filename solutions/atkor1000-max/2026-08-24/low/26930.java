import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;
import java.util.EmptyStackException;

class Solution
{
	public static void main(String args[]) throws Exception
	{


		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        sc.nextLine();


		for(int test_case = 1; test_case <= T; test_case++)
		{
			Stack<Character> stack = new Stack<>();
			String code = sc.nextLine();
            //System.out.println(code);
            Boolean ignore = false;
            char kicker = '[';
            Boolean valid = true;
            for (int i = 0; i < code.length(); i++) {
                
                Character c = code.charAt(i);
                if (ignore) {
    				if (c == kicker) ignore = false;
    				continue;
				}

				if (c == '\'' || c == '\"') {
    				ignore = true;
    				kicker = c;
    				continue;
				}
                
                if (ignore) continue;
                
                if (c == '{'  || c == '(') {
                	stack.push(c);
                }
                
                else if (c == '}') {
                	Character p;
						if (stack.empty()) {
                        	valid = false;
                        	break;
                        }
                    	p = stack.peek();
                        if (p != '{') {
                    		valid = false;
                        	break;
                    	} else stack.pop();

                }
                
                else if (c == ')') {
                	Character p;
                    	if (stack.empty()) {
                        	valid = false;
                        	break;
                        }
                    	p = stack.peek();
                        if (p != '(') {
                    		valid = false;
                        	break;
                    	} else stack.pop();
                }
            }
            //System.out.println(valid);
            valid = stack.empty() && valid;
            //System.out.println(stack.empty());
            if (valid) System.out.println("#" + test_case + " 1");
            else System.out.println("#" + test_case + " 0");
		}
	}
}