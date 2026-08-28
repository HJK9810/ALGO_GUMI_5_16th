/*
26934. 회전 드럼식 커피 로스터 (D3)
https://swexpertacademy.com/main/code/userProblem/userProblemList.do?problemTitle=26934&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static class Basket {
    int idx;
    int water;

    public Basket(int idx, int water) {
      this.idx = idx;
      this.water = water;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      Basket[] basket = new Basket[M];
      st = new StringTokenizer(br.readLine());
      for (int m = 0; m < M; m++) {
        basket[m] = new Basket(m + 1, Integer.parseInt(st.nextToken()));
      }

      Queue<Basket> roast = new LinkedList<>();
      for (int i = 0; i < N; i++) {
        roast.add(basket[i]);
      }

      int inputIdx = N;

      while (true) {
        if (roast.size() == 1) {
          break;
        }

        Basket cur = roast.poll();
        cur.water = (int)(cur.water / 2);

        if (cur.water == 0) {
          if (inputIdx < M) {
            roast.add(basket[inputIdx++]);
          }
        } else {
          roast.add(cur);
        }
      }

      bw.write("#" + t + " " + roast.poll().idx + "\n");
    }

    bw.flush();
  }
}
