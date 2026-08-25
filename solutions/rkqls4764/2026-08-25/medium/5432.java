/*
5432. 쇠막대기 자르기 (D4)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWVl47b6DGMDFAXm&categoryId=AWVl47b6DGMDFAXm&categoryType=CODE&problemTitle=5432&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      String input = br.readLine();
      int answer = 0;
      int cnt = 0;

      for (int i = 0; i < input.length(); i++) {
        if (input.charAt(i) == '(') {
          if (input.charAt(i + 1) == ')') {
            // 레이저
            answer += cnt;
            i++;  // 레이저의 닫는 괄호 건너뛰기
          } else {
            // 스틱 시작
            cnt++;
          }
        } else {
          // 스틱 끝
          cnt--;
          answer++; // 스틱 총 개수 = 잘린 횟수 + 1
        }
      }

      bw.write("#" + t + " " + answer + "\n");
    }

    bw.flush();
  }
}
