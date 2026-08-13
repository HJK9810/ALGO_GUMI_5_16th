import java.util.Scanner;

class Solution {
  static char[][] field = new char[8][8];
  static int length;
  static int count;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str;
    for(int tc = 1; tc <= 10; tc++) {
      length = sc.nextInt();
      for(int i = 0; i < 8; i++) {
        str = sc.next();
        for(int j = 0; j < 8; j++) {
          field[i][j] = str.charAt(j);
        }
      }

      count = 0;

      for(int i = 0; i < 8; i++) {
        for(int j = 0; j < 8; j++) {
          if(j <= 8 - length) {
            count += checkRow(i, j);
          }
          if(i <= 8 - length) {
            count += checkCol(i, j);
          }
        }
      }
      System.out.println("#" + tc + " " + count);
    }

    sc.close();
  }

  static int checkRow(int row, int col) {
    for(int j = 0; j < length / 2; j++) {
      if(field[row][col + j] != field[row][col + length - j - 1]) {
        return 0;
      }
    }
    return 1;
  }

  static int checkCol(int row, int col) {
    for(int i = 0; i < length / 2; i++) {
      if(field[row + i][col] != field[row + length - i - 1][col]) {
        return 0;
      }
    }
    return 1;
  }
}