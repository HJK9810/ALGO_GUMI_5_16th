import java.util.Scanner;

class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int testCase = sc.nextInt();

    for(int tc = 1; tc <= testCase; tc++) {
      int N = sc.nextInt();
      int M = sc.nextInt();

      int[] walk = new int[N];

      int high = 0;
      int low = 1000000; //N <= 100, 걸음 수 <= 10000
      int total = 0;

      for(int i = 0; i < N; i++) {
        walk[i] = sc.nextInt();
      }

      for(int i = 0; i < N - M + 1; i++) {
        total = 0;
        for(int j = 0; j < M; j++) {
          total += walk[i + j]; 
        }

        if(total < low) {
          low = total;
        }
        if(total > high) {
          high = total;
        }
      }

      System.out.println("#" + tc + " " + (high - low));
    }
    sc.close();
  }
}