/*
26935. 광장 광고탑 회전판 (D2)
https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpFLaHanHBIQj&categoryId=AZ6wpFLaHanHBIQj&categoryType=CODE
*/

import java.util.*;

class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();

    for (int t = 1; t <= T; t++) {
      int N = sc.nextInt();
      int M = sc.nextInt();

      int[] arr = new int[N];

      for (int n = 0; n < N; n++) {
        arr[n] = sc.nextInt();
      }

      int answer = arr[M % N];

      System.out.println("#" + t + " " + answer);
    }
  }
}
