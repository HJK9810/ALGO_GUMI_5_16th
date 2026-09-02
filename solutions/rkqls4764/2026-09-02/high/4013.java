/*
4013. [모의 SW 역량테스트] 특이한 자석
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeV9sKkcoDFAVH&categoryId=AWIeV9sKkcoDFAVH&categoryType=CODE&problemTitle=4013&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static final int MAGNET_CNT = 4;
  public static final int GEAR_CNT = 8;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      int K = Integer.parseInt(br.readLine());
      int[][] magnet = new int[MAGNET_CNT][GEAR_CNT];

      for (int m = 0; m < MAGNET_CNT; m++) {
        st = new StringTokenizer(br.readLine());
        for (int g = 0; g < GEAR_CNT; g++) {
          magnet[m][g] = Integer.parseInt(st.nextToken());
        }
      }

      int[] startIdx = new int[] { 0, 0, 0, 0 };  // 빨간 화살표 위치, 회전 계산에 사용

      while (K-- > 0) {
        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken()) - 1;
        int rotate = Integer.parseInt(st.nextToken());
        boolean clockDirection = rotate == 1 ? true : false;

        // 회전시킨 자석 기준으로 왼쪽에 있는 자석들 회전 검사
        rotateLeft(magnet, startIdx, num, !clockDirection);

        // 회전시킨 자석 기준으로 오른쪽에 있는 자석들 회전 검사
        rotateRight(magnet, startIdx, num, !clockDirection);

        // 입력받은 회전 방향대로 회전
        startIdx[num] = clockDirection ? startIdx[num] - 1 : startIdx[num] + 1;
        startIdx[num] = (startIdx[num] + GEAR_CNT) % GEAR_CNT;
      }

      int score = 0;

      for (int m = 0; m < magnet.length; m++) {
        int value = magnet[m][startIdx[m]]; // 빨간 화살표 위치의 값

        if (value == 0) { // n극이면 점수 없음
          continue;
        }

        score += Math.pow(2, m);  // s극이면 각각 1, 2, 4, 8점
      }

      bw.write("#" + t + " " + score + "\n");
    }

    bw.flush();
  }

  /* 왼쪽으로 회전 검사 */
  public static void rotateLeft(int[][] magnet, int[] startIdx, int cur, boolean clockDirection) {
    int left = cur - 1;

    if (left < 0) {
      return;
    }

    int curGear = magnet[cur][(startIdx[cur] + 6) % GEAR_CNT];
    int leftGear = magnet[left][(startIdx[left] + 2) % GEAR_CNT];

    if (curGear == leftGear) {
      return;
    }

    rotateLeft(magnet, startIdx, left, !clockDirection);

    // 닿아 있는 극이 다르면 회전
    startIdx[left] = clockDirection ? startIdx[left] - 1 : startIdx[left] + 1;
    startIdx[left] = (startIdx[left] + GEAR_CNT) % GEAR_CNT;
  }

  /* 오른쪽으로 회전 검사 */
  public static void rotateRight(int[][] magnet, int[] startIdx, int cur, boolean clockDirection) {
    int right = cur + 1;

    if (right >= MAGNET_CNT) {
      return;
    }

    int curGear = magnet[cur][(startIdx[cur] + 2) % GEAR_CNT];
    int rightGear = magnet[right][(startIdx[right] + 6) % GEAR_CNT];

    if (curGear == rightGear) {
      return;
    }
    
    rotateRight(magnet, startIdx, right, !clockDirection);

    // 닿아 있는 극이 다르면 회전
    startIdx[right] = clockDirection ? startIdx[right] - 1 : startIdx[right] + 1;
    startIdx[right] = (startIdx[right] + GEAR_CNT) % GEAR_CNT;
  }
}
