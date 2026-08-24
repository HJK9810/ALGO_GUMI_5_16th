import java.util.Scanner;

class Solution {
  static int[][] snail;
  static int count;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int testCase = sc.nextInt();

    for(int tc = 1; tc <= testCase; tc++) {
      int N = sc.nextInt();
      snail = new int[N][N];
      count = 1;
      makeTR(N, 0, 0);

      System.out.println("#" + tc);
      for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
          System.out.print(snail[i][j] + " ");
        }
        System.out.println();
      }
    }

    sc.close();
  }

  static void makeTR(int N, int row, int col) { //ㄱ shape
    if(N == 1) {
      snail[row][col] = count;
      return;
    }
    for(int j = 0; j < N; j++) {
      snail[row][col + j] = count++;
    }
    for(int i = 1; i < N; i++) {
      snail[row + i][col + N - 1] = count++;
    }
    makeBL(N - 1, row + 1, col);
  }

  static void makeBL(int N, int row, int col) { // ㄴ shape
    if(N == 1) {
      snail[row][col] = count;
      return;
    }
    
    for(int j = N - 1; j >= 0; j--) {
      snail[row + N - 1][col + j] = count++;
    }

    for(int i = N - 2; i >= 0; i--) {
      snail[row + i][col] = count++;
    }
    makeTR(N - 1, row, col + 1);
  }
}