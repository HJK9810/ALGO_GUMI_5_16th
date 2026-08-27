import java.util.ArrayList;
import java.util.Scanner;

class Solution {
  private static final int[][] DIR = new int[][] {{0, 0}, {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
  private int moveCount;

  private int[][] sortCharge(ArrayList<int[]> chargeCases) {
    int size = chargeCases.size();
    int[][] sortedCase = new int[size][2];

    for (int idx = 0; idx < size; idx++) {
      sortedCase[idx] = chargeCases.get(idx);
    }

    for (int end = size - 1; end >= 0; end--) {
      for (int index = 0; index < end; index++) {
        if (sortedCase[index][1] < sortedCase[index + 1][1]) {
          int[] temp = sortedCase[index + 1];
          sortedCase[index + 1] = sortedCase[index];
          sortedCase[index] = temp;
        }
      }
    }

    return sortedCase;
  }

  private int[] movePos(int[] current, int dirNum) {
    int dRow = DIR[dirNum][0];
    int dCol = DIR[dirNum][1];

    return new int[] {current[0] + dRow, current[1] + dCol};
  }

  private ArrayList<int[]>[][] initialBoard(ArrayList<int[]> inputCases) {
    ArrayList<int[]>[][] boards = new ArrayList[10][10];

    for (int row = 0; row < 10; row++) {
      for (int col = 0; col < 10; col++) {
        boards[row][col] = new ArrayList<>();
        boards[row][col].add(new int[] {0, 0});
      }
    }

    for (int idx = 0; idx < inputCases.size(); idx++) {
      int[] inputCase = inputCases.get(idx);
      int col = inputCase[0];
      int row = inputCase[1];
      int size = inputCase[2];
      int charge = inputCase[3];

      for (int r = row - size; r <= row + size; r++) {
        for (int c = col - size; c <= col + size; c++) {
          if (r >= 0 && r < 10 && c >= 0 && c < 10 && Math.abs(r - row) + Math.abs(c - col) <= size) {
            boards[r][c].add(new int[] {idx + 1, charge});
          }
        }
      }
    }

    return boards;
  }

  private int algorithm(ArrayList<int[]> inputCase, ArrayList<Integer> aMoveInput, ArrayList<Integer> bMoveInput) {
    ArrayList<int[]>[][] boards = initialBoard(inputCase);

    int totalCharge = 0;
    aMoveInput.add(0, 0);
    bMoveInput.add(0, 0);

    int[] aPos = new int[] {0, 0};
    int[] bPos = new int[] {9, 9};

    for (int move = 0; move < moveCount + 1; move++) {
      aPos = movePos(aPos, aMoveInput.get(move));
      bPos = movePos(bPos, bMoveInput.get(move));

      int[][] aCharge = sortCharge(boards[aPos[0]][aPos[1]]);
      int[][] bCharge = sortCharge(boards[bPos[0]][bPos[1]]);

      if (aCharge.length == 1 && aCharge.length == bCharge.length) continue;
      else if (aCharge[0][0] == bCharge[0][0]) {
        totalCharge += (aCharge[0][1] + Math.max(aCharge[1][1], bCharge[1][1]));
      } else {
        totalCharge += (aCharge[0][1] + bCharge[0][1]);
      }
    }

    return totalCharge;
  }

	public static void main(String args[]) throws Exception {
    Solution sol = new Solution();

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
      sol.moveCount = sc.nextInt();
      int A = sc.nextInt();
      ArrayList<int[]> inputCase = new ArrayList<>();
      ArrayList<Integer> aMoveInput = new ArrayList<>();
      ArrayList<Integer> bMoveInput = new ArrayList<>();
      
      for (int idx = 0; idx < sol.moveCount; idx++) {
        aMoveInput.add(sc.nextInt());
      }
      for (int idx = 0; idx < sol.moveCount; idx++) {
        bMoveInput.add(sc.nextInt());
      }
      for (int idx = 0; idx < A; idx++) {
        inputCase.add(new int[] {sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt(), sc.nextInt()});
      }

      int result = sol.algorithm(inputCase, aMoveInput, bMoveInput);

      System.out.printf("#%d %d\n", test_case, result);
		}

    sc.close();
	}
}
