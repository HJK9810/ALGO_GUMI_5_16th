import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
  private boolean checkAirLine(int[] line, int X) {
    boolean isDown = false;
    int changeCount = 1;

    for (int col = 1; col < line.length; col++) {
      int current = line[col];
      int before = line[col - 1];

      if (before == current) {
        if (isDown) {
          changeCount += 1;
          if (changeCount == X) {
            isDown = false;
            changeCount = 0;
          }
        } else {
          changeCount++;
        }
      } else if (Math.abs(current - before) != 1) return false;
      else if (before < current) {
        if (isDown || changeCount < X) return false;
        else changeCount = 1;
      } else if (before > current) {
        if (isDown) return false;

        isDown = X != 1;
        changeCount = X == 1 ? 0 : 1;
      }
    }

    return !isDown;
  }

	public static void main(String args[]) throws Exception {
    Solution sol = new Solution();

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int T = Integer.parseInt(input.readLine());

		for(int test_case = 1; test_case <= T; test_case++) {
      st = new StringTokenizer(input.readLine());
      int N = Integer.parseInt(st.nextToken());
      int X = Integer.parseInt(st.nextToken());
      
      int[][] boards = new int[N][N];
      int[][] board_transit = new int[N][N];
      for (int row = 0; row < N; row++) {
        String[] line = input.readLine().split(" ");
        for (int col = 0; col < N; col++) {
          boards[row][col] = Integer.parseInt(line[col]);
          board_transit[col][row] = Integer.parseInt(line[col]);
        }
      }

      int count = 0;
      for (int row = 0; row < N; row++) {
        if (sol.checkAirLine(boards[row], X)) count++;
        if (sol.checkAirLine(board_transit[row], X)) count++;
      }

      System.out.printf("#%d %d\n", test_case, count);
		}
	}
}
