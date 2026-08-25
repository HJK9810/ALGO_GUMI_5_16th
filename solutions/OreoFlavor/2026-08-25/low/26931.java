import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Deque;
import java.util.ArrayDeque;
//14:50
class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= testCase; tc++) {
            String input = br.readLine();
            Deque<Character> stack = new ArrayDeque<>();

            for(int i = 0; i < input.length(); i++) {
                char current = input.charAt(i);
                if(!stack.isEmpty() && stack.peek() == current) {
                    stack.pop();
                }
                else {
                    stack.push(current);
                }
            }

            sb.append('#');
            sb.append(tc);
            sb.append(' ');
            sb.append(stack.size());
            sb.append('\n');
        }
        
        System.out.print(sb);

        br.close();
    }
}