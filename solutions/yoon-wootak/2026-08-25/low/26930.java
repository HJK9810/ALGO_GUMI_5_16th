import java.util.*;
import java.io.*;

class Solution {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case=1; test_case<=T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			
			String s = br.readLine();

			char quote = ' ';
			boolean isValid = true;
			Deque<Character> stack = new ArrayDeque<>();
			for (int i=0; i<s.length(); i++) {
				char c = s.charAt(i);
				
				if (quote != ' ') {
					if (quote == c) {
						quote = ' ';
					}
					continue;
				}
				
				if (c == '\'' || c == '\"') {
					quote = c;
				}
				else if (c == '(' || c == '{') {
					stack.push(c);
				}
				else if (c == ')') {
					if (!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					}
					else {
						isValid = false;
						break;
					}
				}
				else if (c == '}') {
					if (!stack.isEmpty() && stack.peek() == '{') {
						stack.pop();
					}
					else {
						isValid = false;
						break;
					}
				}
			}
			
			if (!stack.isEmpty() || !isValid) {
				sb.append("0").append("\n");
			}
			else {
				sb.append("1").append("\n");
			}
		}
		
		System.out.println(sb);
	}
}