/*
27025. 동아리 명단 중도 취소자 제거 (D2)
https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ87xcTa9IfHBIOQ&categoryId=AZ87xcTa9IfHBIOQ&categoryType=CODE
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
      int N = Integer.parseInt(br.readLine());

      ArrayList<Integer> list = new ArrayList<>();

      st = new StringTokenizer(br.readLine());
      for (int n = 0; n < N; n++) {
        list.add(Integer.parseInt(st.nextToken()));
      }

      int K = Integer.parseInt(br.readLine());

      st = new StringTokenizer(br.readLine());
      for (int k = 0; k < K; k++) {
        list.remove(Integer.valueOf(Integer.parseInt(st.nextToken())));
      }

      bw.write("#" + t);

      if (list.isEmpty()) {
        bw.write(" empty");
      } else {
        for (int n : list) {
          bw.write(" " + n);
        }
      }

      bw.write("\n");
    }
    
    bw.flush();
  }
}
