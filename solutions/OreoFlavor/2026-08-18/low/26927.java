import java.util.Scanner;

class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int testCase = sc.nextInt();
    for(int tc = 1; tc <= testCase; tc++) {
      int N = sc.nextInt();

      int[] scores = new int[10];

      String record = sc.next();
      for(int i = 0; i < N; i++) {
        scores[record.charAt(i) - 48]++;
      }

      int max = 0;
      for(int i = 0; i < 10; i++) {
        if(scores[max] <= scores[i]) {
          max = i;
        }
      }

      System.out.println("#" + tc + " " + max + " " + scores[max]);
    }
  }
}