import java.util.ArrayDeque;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
      char[] line = sc.next().toCharArray();
      ArrayDeque<Character> stack = new ArrayDeque<>();

      for (char alpa : line) {
        stack.push(alpa);

        while (stack.size() > 1) {
          char last = stack.pop();
          if (stack.peek() == last) {
            stack.pop();
          } else {
            stack.push(last);
            break;
          }
        }
      }

      System.out.printf("#%d %d\n", test_case, stack.size());
		}
	}
}
