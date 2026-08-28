/*
4128. [모의 SW 역량테스트] 요리사
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWJR5apqD0EDFAXc&categoryId=AWJR5apqD0EDFAXc&categoryType=CODE&problemTitle=4128&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static int N;
  public static int[][] synergy;
  public static int answer;
  public static boolean[] selected;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      N = Integer.parseInt(br.readLine());
      synergy = new int[N][N];

      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
          synergy[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      answer = Integer.MAX_VALUE;
      selected = new boolean[N];

      combination(0, 0);

      bw.write("#" + t + " " + answer + "\n");
    }

    bw.flush();
  }

  public static void combination(int idx, int cnt) {
    // 선택한 개수가 N/2개면 계산
    if (cnt == N / 2) {
      int A = 0;
      int B = 0;

      for (int i = 0; i < N; i++) {
        for (int j = i + 1; j < N; j++) {
          if (selected[i] && selected[j]) { // A에 저장
            A += synergy[i][j] + synergy[j][i];
          } else if (!selected[i] && !selected[j]) { // B에 저장
            B += synergy[i][j] + synergy[j][i];
          }
        }
      }

      answer = Math.min(answer, Math.abs(A - B));

      return;
    }

    if (idx == N) {
      return;
    }

    // idx 선택
    selected[idx] = true;
    combination(idx + 1, cnt + 1);
    selected[idx] = false;

    // idx 선택 안함
    combination(idx + 1, cnt);
  }
}
