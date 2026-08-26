/*
1225. [S/W 문제해결 기본] 7일차 - 암호생성기 (D3)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14uWl6AF0CFAYD&categoryId=AV14uWl6AF0CFAYD&categoryType=CODE&problemTitle=1225&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.StringTokenizer;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    for (int t = 1; t <= 10; t++) {
      int testcase = Integer.parseInt(br.readLine());
      int[] numbers = new int[8];

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < numbers.length; i++) {
        numbers[i] = Integer.parseInt(st.nextToken());
      }

      int idx = 0;
      int cnt = 1;

      while (true) {
        numbers[idx] -= cnt;

        if (numbers[idx] <= 0) {
          numbers[idx] = 0;
          idx = (idx + 1) % numbers.length;
          break;
        }

        idx = (idx + 1) % numbers.length;
        cnt = (cnt + 1) % 6;
        if (cnt == 0) cnt++;
      }

      bw.write("#" + testcase);
      for (int i = 0; i < numbers.length; i++) {
        bw.write(" " + numbers[idx]);
        idx = (idx + 1) % numbers.length;
      }
      bw.write("\n");
    }

    bw.flush();
  }
}