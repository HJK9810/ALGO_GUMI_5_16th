import java.util.Scanner;

class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int testCase = sc.nextInt();
    
    for(int tc = 1; tc <= testCase; tc++) {
      int days = sc.nextInt();
      int max = 0;
      int min = 1000000;

      for(int i = 0; i < days; i++) {
        int input = sc.nextInt();
        if(max < input) {
          max = input;
        }
        if(min > input) {
          min = input;
        }
      }

      System.out.println("#" + tc + " " + (max - min));
    }
  }
}
