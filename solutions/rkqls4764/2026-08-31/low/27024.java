/*
27024. 줄 서기 앞뒤 삽입 (D2)
https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ87xb8K9IPHBIOQ&categoryId=AZ87xb8K9IPHBIOQ&categoryType=CODE
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
      ArrayDeque<Integer> deque = new ArrayDeque<>();

      while (N-- > 0) {
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int id = Integer.parseInt(st.nextToken());

        if (c == 1) {
          deque.addFirst(id);
        } else if (c == 2) {
          deque.addLast(id);
        }
      }

      bw.write("#" + t);
      for (int num : deque) {
        bw.write(" " + num);
      }
      bw.write("\n");
    }

    bw.flush();
  }
}
