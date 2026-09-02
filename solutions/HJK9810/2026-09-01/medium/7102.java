import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
      sb.setLength(0);
      int N = sc.nextInt();
      int M = sc.nextInt();

      int[] counts = new int[N + M + 1];
      for (int first = 1; first <= N; first++) {
        for (int second = 1; second <= M; second++) {
          counts[first + second]++;
        }
      }

      int maxValue = counts[0];
      for (int num = 2; num < N + M + 1; num++) {
        if (maxValue < counts[num]) {
          maxValue = counts[num];
          sb.setLength(0);
          sb.append(" " + num);
        } else if (maxValue == counts[num]) {
          sb.append(" " + num);
        }
      }

      System.out.println("#" + test_case + sb.toString());
		}
    sc.close();
	}
}
