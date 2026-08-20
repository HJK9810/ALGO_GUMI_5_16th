import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
  static int K;
  static Deque<Integer> stack;
  static int input;
  static int count;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int testCase = sc.nextInt();

    for(int tc = 1; tc <= testCase; tc++) {
      K = sc.nextInt();
      stack = new ArrayDeque<>();
      count = 0;

      for(int i = 0; i < K; i++) {
        input = sc.nextInt();
        if(input == 0) {
          stack.pop();
        }
        else {
          stack.push(input);
        }
      }
      
      while(!stack.isEmpty()) {
        count += stack.pop();
      }

      System.out.println("#" + tc + " " + count);
    }

    sc.close();
  }
}