/*
7102. 준홍이의 카드놀이 (D3)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWkIlHWqBYcDFAXC&categoryId=AWkIlHWqBYcDFAXC&categoryType=CODE&problemTitle=7102&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      int[] cnt = new int[N + M + 1];
      int max = 0;

      for (int n = 1; n <= N; n++) {
        for (int m = 1; m <= M; m++) {
          int sum = n + m;
          cnt[sum]++;

          if (max < cnt[sum]) {
            max = cnt[sum];
          }
        }
      }

      ArrayList<Integer> list = new ArrayList<>();

      for (int i = 1; i < cnt.length; i++) {
        if (cnt[i] == max) {
          list.add(i);
        }
      }

      bw.write("#" + t);
      for (int num : list) {
        bw.write(" " + num);
      }
      bw.write("\n");
    }

    bw.flush();
  }
}
