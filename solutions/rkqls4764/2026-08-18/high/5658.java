/*
5658. [모의 SW 역량테스트] 보물상자 비밀번호
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRUN9KfZ8DFAUo&categoryId=AWXRUN9KfZ8DFAUo&categoryType=CODE&problemTitle=5658&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
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
      int K = Integer.parseInt(st.nextToken());
      String line = br.readLine();
      
      ArrayList<Integer> list = new ArrayList<>();
      int length = N / 4;

      for (int s = 0; s < N; s++) {
        int e = (s + length) % N;
        int idx = s;

        StringBuilder sb = new StringBuilder();

        while (true) {
          if (idx == e) {
            break;
          }

          sb.append(line.charAt(idx));

          if (sb.length() == length) {
            int num = Integer.parseInt(sb.toString(), 16);

            if (!list.contains(num)) {
              list.add(num);
            }
          }

          idx = (idx + 1) % N;
        }
      }

      Collections.sort(list, Collections.reverseOrder());

      bw.write("#" + t + " " + list.get(K - 1) + "\n");
    }

    bw.flush();
  }
}
