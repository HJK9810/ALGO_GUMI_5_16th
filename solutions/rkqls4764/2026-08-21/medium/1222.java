/*
1222. [S/W 문제해결 기본] 6일차 - 계산기1 (D4)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14mbSaAEwCFAYD&categoryId=AV14mbSaAEwCFAYD&categoryType=CODE&problemTitle=1222&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (int t = 1; t <= 10; t++) {
      int length = Integer.parseInt(br.readLine());
      String line = br.readLine();
      int answer = 0;

      for (int i = 0; i < length; i++) {
        int input = line.charAt(i) - '0';

        // 숫자면 더하기
        if (0 < input && input < 10) {
          answer += input;
        }
      }

      bw.write("#" + t + " " + answer + "\n");
    }

    bw.flush();
  }
}
