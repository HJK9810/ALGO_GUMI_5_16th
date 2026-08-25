import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Solution {
    static String line;
    static Deque<Character> stack;
    static String result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for(int tc = 1; tc <= 10; tc++) {
            stack = new ArrayDeque<>();

            int N = sc.nextInt();
            line = sc.next();

            stack.push(line.charAt(0));
            
            for(int i = 1; i < N; i++) {
                if(!stack.isEmpty() && stack.peek().equals(line.charAt(i))) {
                    stack.pop();
                }
                else {
                    stack.push(line.charAt(i));
                }
            }
            
            result = "";
            while(!stack.isEmpty()) {
                result += stack.pollLast();
            }
            
            System.out.println("#" + tc + " " + result);
        }
    }
}