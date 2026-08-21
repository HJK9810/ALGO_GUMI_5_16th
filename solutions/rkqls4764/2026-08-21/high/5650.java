/*
5650. [모의 SW 역량테스트] 핀볼 게임
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRF8s6ezEDFAUo&categoryId=AWXRF8s6ezEDFAUo&categoryType=CODE&problemTitle=5650&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/

import java.io.*;
import java.util.*;

class Solution {
  public static int[][] directions = {{ 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }};  // 오른쪽, 밑, 왼쪽, 위
  public static int[][] map;
  public static HashMap<Integer, ArrayList<int[]>> wormholes;
  public static int answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine().trim());

    for (int t = 1; t <= T; t++) {
      int N = Integer.parseInt(br.readLine().trim());
      map = new int[N + 2][N + 2]; // 가장자리를 블록 5로 처리
      wormholes = new HashMap<>();

      // 웜홀 ArrayList 초기화
      for (int i = 6; i <= 10; i++) {
        wormholes.put(i, new ArrayList<>());
      }

      HashSet<int[]> start = new HashSet<>();

      for (int i = 0; i < map.length; i++) {
        for (int j = 0; j < map.length; j++) {
          map[i][j] = 5;
        }
      }

      for (int i = 1; i <= N; i++) {
        st = new StringTokenizer(br.readLine().trim());
        for (int j = 1; j <= N; j++) {
          int num = Integer.parseInt(st.nextToken());
          map[i][j] = num;

          // 출발 위치 후보 추가
          if (num == 0) {
            start.add(new int[] { i, j });
          }

          // 웜홀 위치 저장
          if (6 <= num && num <= 10) {
            wormholes.get(num).add(new int[] { i, j });
          }
        }
      }

      answer = 0;

      // 모든 출발 위치 후보, 진행 방향 실행하여 점수 구하기
      for (int[] s : start) {
        for (int dIdx = 0; dIdx < directions.length; dIdx++) {
          int x = s[0] + directions[dIdx][0];
          int y = s[1] + directions[dIdx][1];

          // 종료를 위해 출발지를 -1로 설정했다가 복구
          int temp = map[s[0]][s[1]];
          map[s[0]][s[1]] = -1;
          playPinball(x, y, dIdx, 0);
          map[s[0]][s[1]] = temp;
        }
      }

      bw.write("#" + t + " " + answer + "\n");
    }

    bw.flush();
  }

  public static void playPinball(int x, int y, int dIdx, int score) {
    while (true) {
      int cur = map[x][y];

      // -1이면 종료
      if (cur == -1) {
        answer = Math.max(answer, score);
        return;
      }

      // 웜홀이면 다른 웜홀로 이동, 진행 방향 유지
      if (6 <= cur && cur <= 10) {  
        int[] out = goWormhole(x, y);
        x = out[0];
        y = out[1];
      }

      // 블록 처리, 점수 증가
      if (1 <= cur && cur <= 5) {  
        dIdx = goBlock(map[x][y], dIdx);
        score += 1;
      }

      x = x + directions[dIdx][0];
      y = y + directions[dIdx][1];
    }
  }

  /* 웜홀 반대편 찾기 */
  public static int[] goWormhole(int inX, int inY) {
    int[] out = new int[2];
    int num = map[inX][inY];
    
    for (int[] wormhole : wormholes.get(num)) {
      if (wormhole[0] != inX || wormhole[1] != inY) {
        out = wormhole;
      }
    }

    return out;
  }

  /* 블록별 다음 이동 방향 찾기 */
  public static int goBlock(int block, int dIdx) {
    switch (block) {
      case 1:
        if (dIdx == 2) return 3;
        if (dIdx == 1) return 0;
        break;
      case 2:
        if (dIdx == 3) return 0;
        if (dIdx == 2) return 1;
        break;
      case 3:
        if (dIdx == 3) return 2;
        if (dIdx == 0) return 1;
        break;
      case 4:
        if (dIdx == 1) return 2;
        if (dIdx == 0) return 3;
        break;
    }

    return (dIdx + 2) % 4;
  } 
}
