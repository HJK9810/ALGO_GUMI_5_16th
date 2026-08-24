import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;

class Solution
{
    
    public static int getPrecedence(char op) {
        if (op == '*') return 2;
        if (op == '+') return 1;
        return 0;
    } //이것도 이렇게 할 필요 없는데... 잘 보이긴 한다
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
        T = 10;


		for(int test_case = 1; test_case <= T; test_case++)
		{
			Stack<Character> operatorStack = new Stack<>();
			Stack<Character> tokens = new Stack<>(); //스택일 필요 없는데 c++ 때문에 뇌가 썩음
            Stack<Long> calculation = new Stack<>();
            
            int l = sc.nextInt();
            String term = sc.next();
            for (int i = 0; i < l; i++) {
                Character c = term.charAt(i);
            	if (c >= '0' && c <= '9') {
                    tokens.add(c);
                } 
                else if (c == '(') operatorStack.push(c);
            	else if (c == ')') {
                    while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                        tokens.add(operatorStack.pop());
                    }
                    if (!operatorStack.isEmpty()) {
                        operatorStack.pop(); // Pop '('
                    }
                } 
                else if (c == '+' || c == '*') {
                    while (!operatorStack.isEmpty() && operatorStack.peek() != '(' &&
                           getPrecedence(operatorStack.peek()) >= getPrecedence(c)) {
                        tokens.add(operatorStack.pop());
                    }
                    operatorStack.push(c);
                }
            }
            
            while (!operatorStack.empty()) {
    			tokens.push(operatorStack.pop());
			}
            
            
            //System.out.println(tokens.size());
            for (int j = 0; j < tokens.size(); j++) {
            	//System.out.println(j)
                Character c = tokens.get(j);
                //System.out.print(c);
                if (c == '+') {
                	long a = calculation.pop();
                    long b = calculation.pop();
                    long result = a + b;
                    calculation.push(result);
                }
                else if (c == '*') {
                	long a = calculation.pop();
                    long b = calculation.pop();
                    long result = a * b;
                    calculation.push(result);
                }
                else {
                    int k = c - '0';
                    //System.out.println(k);
                    Long x = new Long(k);
                    calculation.push(x);
                }
            }
            
            
            long value = calculation.pop();
			System.out.println("#" + test_case + " " + value);
		}
	}
}