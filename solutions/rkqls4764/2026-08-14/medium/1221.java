/*
1221. [S/W 문제해결 기본] 5일차 - GNS
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14jJh6ACYCFAYD&
*/

import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());

    Map<String, Integer> map = new HashMap<>();
    map.put("ZRO", 0);
    map.put("ONE", 1);
    map.put("TWO", 2);
    map.put("THR", 3);
    map.put("FOR", 4);
    map.put("FIV", 5);
    map.put("SIX", 6);
    map.put("SVN", 7);
    map.put("EGT", 8);
    map.put("NIN", 9);

    String[] numbers = new String[] { "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN" };

    for (int t = 1; t <= T; t++) {
      st = new StringTokenizer(br.readLine());
      st.nextToken(); // #1 입력 버림
      int length = Integer.parseInt(st.nextToken());
      int[] answer = new int[length];

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < length; i++) {
        int num = map.get(st.nextToken());
        answer[i] = num;
      }

      Arrays.sort(answer);

      bw.write("#" + t + "\n");
      for (int i = 0; i < length; i++) {
        bw.write(numbers[answer[i]] + " ");
      }
      bw.write("\n");
    }

    bw.flush();
  }
}