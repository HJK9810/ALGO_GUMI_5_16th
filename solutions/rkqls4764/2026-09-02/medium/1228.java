/*
1228. [S/W 문제해결 기본] 8일차 - 암호문1 (D3)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14w-rKAHACFAYD&categoryId=AV14w-rKAHACFAYD&categoryType=CODE&problemTitle=1228&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    for (int t = 1; t <= 10; t++) {
      int N = Integer.parseInt(br.readLine());
      ArrayList<Integer> password = new ArrayList<>();

      st = new StringTokenizer(br.readLine());
      for (int n = 0; n < N; n++) {
        password.add(Integer.parseInt(st.nextToken()));
      }

      int cnt = Integer.parseInt(br.readLine());
      
      st = new StringTokenizer(br.readLine());
      while (cnt-- > 0) {
        String I = st.nextToken();
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        ArrayList<Integer> add = new ArrayList<>();
        
        while (y-- > 0) {
          add.add(Integer.parseInt(st.nextToken()));
        }

        password.addAll(x, add);
      }

      bw.write("#" + t);
      for (int i = 0; i < 10; i++) {
        bw.write(" " + password.get(i));
      }
      bw.write("\n");
    }

    bw.flush();
  }
}
