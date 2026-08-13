import java.util.Scanner;
import java.util.Arrays;

class Solution {
  private static int BOARD_SIZE = 8;

  private boolean checkPalindrome(char[] words) {
    int left = 0;
    int right = words.length - 1;

    while (left < right) {
      if (words[left] != words[right]) return false;
      left++;
      right--;
    }

    return true;
  }

  public static void main (String args[]) throws Exception {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    // int T = sc.nextInt();

    for (int test_case = 1; test_case <= 10; test_case++) {
      int N = sc.nextInt();
      char[][] boards = new char[BOARD_SIZE][BOARD_SIZE];
      int count = 0;

      for (int row = 0; row < BOARD_SIZE; row++) {
        char[] alph = sc.next().toCharArray();
        for (int col = 0; col < BOARD_SIZE; col++) {
          boards[row][col] = alph[col];
        }
      }

      for (int row = 0; row < BOARD_SIZE; row++) {
        for (int col = 0; col < BOARD_SIZE; col++) {
          if (col <= BOARD_SIZE - N) {
            char[] rowWord = Arrays.copyOfRange(boards[row], col, col + N);
            if (sol.checkPalindrome(rowWord)) count++;
          }

          if (row <= BOARD_SIZE - N) {
            char[] colWord = new char[N];
            for (int idx = 0; idx < N; idx++) {
              colWord[idx] = boards[row + idx][col];
            }

            if (sol.checkPalindrome(colWord)) count++;
          }
        }
      }

      System.out.printf("#%d %d\n", test_case, count);
		}
	}
}
