import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

class Solution {
  private StringBuilder sb;
  private ArrayDeque<Integer> queue;
  private int minCode;

  private ArrayDeque<Integer> initialDeque(String[] input) {
    queue = new ArrayDeque<>();
    minCode = Integer.MAX_VALUE;

    for (String data : input) {
      int num = Integer.parseInt(data);
      queue.add(num);
      if (minCode > num) {
        minCode = num;
      }
    }

    return queue;
  }

  // 한세트값 = 15 & 전체 list 개수 * 5 = 한 세트를 '모두' 거칠때까지의 횟수
  private void algorithm(String[] data) {
    queue = initialDeque(data);
    int minCase = (minCode - 1) / 15;

    for (int idx = 0; idx < queue.size(); idx++) {
      int num = queue.poll();
      queue.add(num - minCase * 15);
    }

    while (queue.peekLast() != 0) {
      for (int num = 0; num < 5; num++) {
        int first = queue.poll() - (num + 1);
        if (first <= 0) {
          queue.add(0);
          break;
        } else {
          queue.add(first);
        }
      }
    }

    for (Integer num : queue) {
      sb.append(num).append(" ");
    }
  }

	public static void main(String args[]) throws Exception {
    Solution sol = new Solution();
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    sol.sb = new StringBuilder();

    for (int num = 0; num < 10; num++) {
      int test_case = Integer.parseInt(input.readLine());
      String[] data = input.readLine().split(" ");
      sol.algorithm(data);
      
      System.out.printf("#%d %s\n", test_case, sol.sb.toString());
      sol.sb.setLength(0);
    }

    input.close();
  }
}
