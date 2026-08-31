/*
4123. [모의 SW 역량테스트] 숫자 만들기
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWJRxtsKDKIDFAXc&categoryId=AWJRxtsKDKIDFAXc&categoryType=CODE&problemTitle=4123&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static int max;
  public static int min;
  public static int[] operatorCnt;
  public static int[] number;
  public static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      N = Integer.parseInt(br.readLine());

      operatorCnt = new int[4]; // +, -, *, /
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < 4; i++) {
        operatorCnt[i] = Integer.parseInt(st.nextToken());
      }

      number = new int[N];
      st = new StringTokenizer(br.readLine());
      for (int n = 0; n < N; n++) {
        number[n] = Integer.parseInt(st.nextToken());
      }

      max = Integer.MIN_VALUE;
      min = Integer.MAX_VALUE;
      
      dfs(1, number[0]);

      bw.write("#" + t + " " + (max - min) + "\n");
    }

    bw.flush();
  }

  public static void dfs(int idx, int result) {
    if (idx == N) {
      max = Math.max(max, result);
      min = Math.min(min, result);
      return;
    }

    if (operatorCnt[0] != 0) {
      operatorCnt[0]--;
      int add = result + number[idx];
      dfs(idx + 1, add);
      operatorCnt[0]++;
    }

    if (operatorCnt[1] != 0) {
      operatorCnt[1]--;
      int sub = result - number[idx];
      dfs(idx + 1, sub);
      operatorCnt[1]++;
    }

    if (operatorCnt[2] != 0) {
      operatorCnt[2]--;
      int mul = result * number[idx];
      dfs(idx + 1, mul);
      operatorCnt[2]++;
    }

    if (operatorCnt[3] != 0) {
      operatorCnt[3]--;
      int div = result / number[idx];
      dfs(idx + 1, div);
      operatorCnt[3]++;
    }
  }
}
