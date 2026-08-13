import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
  public static void main (String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();

    for (int test_case = 1; test_case <= T; test_case++) {
      long N = sc.nextLong();
      long count = 0;

      while (N >= 2) {
        if (N == 2) break;

        double sqrtN = Math.sqrt(N);
        if ((long)sqrtN * (long)sqrtN == N) {
          N = (long) sqrtN;
          count += 1;
        } else {
          long nextPow = (long) sqrtN + 1;
          count += (nextPow * nextPow- N + 1);
          N = nextPow;
        }
      }

      System.out.printf("#%d %d\n", test_case, count);
    }
  }
}
