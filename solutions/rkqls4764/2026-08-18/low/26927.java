/*
26927. 다트 최다 점수 집계 (D2)
https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpCyaHYnHBIQj&categoryId=AZ6wpCyaHYnHBIQj&categoryType=CODE
*/

import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      int N = Integer.parseInt(br.readLine());
      String scores = br.readLine();
      int[] cnt = new int[10];

      for (int i = 0; i < N; i++) {
        int cur = scores.charAt(i) - '0';
        cnt[cur]++;
      }

      int maxIdx = 0;

      for (int i = 0; i < cnt.length; i++) {
        if (cnt[i] >= cnt[maxIdx]) {
          maxIdx = i;
        }
      }

      bw.write("#" + t + " " + maxIdx + " " + cnt[maxIdx] + "\n");
    }

    bw.flush();
  }
}
