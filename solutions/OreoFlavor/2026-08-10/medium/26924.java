import java.util.Scanner;

class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int testCase = sc.nextInt();
    int K, N, M;

    for(int tc = 1; tc <= testCase; tc++) {
      K = sc.nextInt();
      N = sc.nextInt();
      M = sc.nextInt();
      int[] water = new int[N + 1];

      for(int i = 0; i < M; i++) {
        water[sc.nextInt()] = 1;
      }

      int loc = 0;
      int count = 0;
      int possible = 0;

      while(loc != N) {
        if(loc + K >= N) {
          loc = N;
          break;
        }
        possible = 0;
        for(int i = loc + K; i > loc; i--) {
          if(water[i] == 1) {
            loc = i;
            count++;
            possible = 1;
            break;
          }
        }
        if(possible == 0) {
          break;
        }
      }
      System.out.println("#" + tc + " " + (possible == 1 ? count : 0));
    }
  }
}
