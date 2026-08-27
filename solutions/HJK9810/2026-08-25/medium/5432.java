import java.util.ArrayDeque;
import java.util.Scanner;

class Solution {
  private int algorithm (String inputStr, ArrayDeque<Character> stack) {
    char[] line = inputStr.toCharArray();
    stack = new ArrayDeque<>();
    int cutCount = 0;
    boolean isCutAvail = false;

    for (char alpa : line) {
      if (alpa == '(') {
        isCutAvail = true;
        stack.push(alpa);
        continue;
      }

      if (isCutAvail) {
        isCutAvail = false;
        stack.pop();
        cutCount += stack.size();
      } else {
        stack.pop();
        cutCount++;
      }
    }

    return cutCount;
  }

	public static void main(String args[]) throws Exception {
    Solution sol = new Solution();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
    
    ArrayDeque<Character> stack = new ArrayDeque<>();

		for(int test_case = 1; test_case <= T; test_case++) {
      String line = sc.next();
      int cutCount = sol.algorithm(line, stack);

      System.out.printf("#%d %d\n", test_case, cutCount);
		}
	}
}
